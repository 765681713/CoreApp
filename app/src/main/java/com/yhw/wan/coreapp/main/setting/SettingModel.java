package com.yhw.wan.coreapp.main.setting;

import android.text.TextUtils;

import com.yhw.wan.core.utils.callback.CallbackManager;
import com.yhw.wan.core.utils.callback.CallbackType;
import com.yhw.wan.core.utils.callback.IGlobalCallback;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by BYDeXL on 2018/1/9.
 */

public class SettingModel implements SettingContract.SettingModel {

    @Override
    public void loadDaily(String url) {
        Observable.just(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        IGlobalCallback callback = CallbackManager.getInstance().getCallback(CallbackType.LOAD_SUCCESS);
                        if (TextUtils.isEmpty(s)) {
                            if (callback != null) {
                                callback.executeCallback(s);
                            }
                        } else {
                            callback = CallbackManager.getInstance().getCallback(CallbackType.LOAD_FAILUER);
                            if (callback != null) {
                                callback.executeCallback(s);
                            }
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        IGlobalCallback callback = CallbackManager.getInstance().getCallback(CallbackType.LOAD_ERROR);
                        if (callback != null) {
                            callback.executeCallback("error");
                        }
                    }
                });
    }

}
