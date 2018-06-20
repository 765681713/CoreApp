package com.yhw.wan.core.pay;

import android.app.Activity;
import android.os.AsyncTask;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.yhw.wan.core.app.ConfigKeys;
import com.yhw.wan.core.app.Core;
import com.yhw.wan.core.net.RestClient;
import com.yhw.wan.core.net.callback.ISuccess;
import com.yhw.wan.core.ui.loader.CoreLoader;
import com.yhw.wan.core.utils.CoreLogger;
import com.yhw.wan.core.wechat.CoreWeChat;

/**
 * Created by 刘世波
 */

public class CorePay {

    //设置支付回调监听
    private IAlPayResultListener mIAlPayResultListener = null;

    private CorePay() {
    }

    public static CorePay create() {
        return new CorePay();
    }

    public CorePay setPayResultListener(IAlPayResultListener listener) {
        this.mIAlPayResultListener = listener;
        return this;
    }

    public void alPay(final Activity mActivity, String alPayUrl, int orderId) {
        final String singUrl = alPayUrl + orderId;
        //获取签名字符串
        RestClient.builder()
                .url(singUrl)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final String paySign = JSON.parseObject(response).getString("result");
                        CoreLogger.d("PAY_SIGN", paySign);
                        //必须是异步的调用客户端支付接口
                        final PayAsyncTask payAsyncTask = new PayAsyncTask(mActivity, mIAlPayResultListener);
                        payAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paySign);
                    }
                })
                .build()
                .post();
    }

    public void weChatPay(String weChatPayUrl, int orderId) {
        CoreLoader.stopLoading();
        final String weChatPrePayUrl = weChatPayUrl + orderId;
        CoreLogger.d("WX_PAY", weChatPrePayUrl);

        final IWXAPI iwxapi = CoreWeChat.getInstance().getWXAPI();
        final String appId = Core.getConfiguration(ConfigKeys.WE_CHAT_APP_ID);
        iwxapi.registerApp(appId);
        RestClient.builder()
                .url(weChatPrePayUrl)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        final JSONObject result =
                                JSON.parseObject(response).getJSONObject("result");
                        final String prepayId = result.getString("prepayid");
                        final String partnerId = result.getString("partnerid");
                        final String packageValue = result.getString("package");
                        final String timestamp = result.getString("timestamp");
                        final String nonceStr = result.getString("noncestr");
                        final String paySign = result.getString("sign");

                        final PayReq payReq = new PayReq();
                        payReq.appId = appId;
                        payReq.prepayId = prepayId;
                        payReq.partnerId = partnerId;
                        payReq.packageValue = packageValue;
                        payReq.timeStamp = timestamp;
                        payReq.nonceStr = nonceStr;
                        payReq.sign = paySign;
                        iwxapi.sendReq(payReq);
                    }
                })
                .build()
                .post();
    }

}
