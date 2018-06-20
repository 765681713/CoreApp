package com.yhw.wan.core.ui.loader;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

import com.blankj.utilcode.util.SizeUtils;
import com.wang.avi.AVLoadingIndicatorView;
import com.yhw.wan.core.R;
import com.yhw.wan.core.utils.DimenUtil;


/**
 * Created by 刘世波 on 2017/4/2
 */

public class CoreLoader {

    private static final int LOADER_SIZE_SCALE = 5;
    private static final int LOADER_OFFSET_SCALE = 10;

    private static AppCompatDialog mLoader;

    private static final String DEFAULT_LOADER = LoaderStyle.BallClipRotatePulseIndicator.name();

    public static void showLoading(Context context, Enum<LoaderStyle> type) {
        showLoading(context, type.name());
    }

    public static void showLoading(Context context, String type) {
        if (mLoader == null) {
            mLoader = new AppCompatDialog(context, R.style.dialog);
            final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
            avLoadingIndicatorView.setIndicatorColor(context.getResources().getColor(R.color.color_ff50b0));
//            avLoadingIndicatorView.setBackgroundResource(R.drawable.av_loader_border);
            int padding = SizeUtils.dp2px(10);
            avLoadingIndicatorView.setPadding(padding, padding, padding, padding);
            mLoader.setContentView(avLoadingIndicatorView);
            int deviceWidth = DimenUtil.getScreenWidth();
            int deviceHeight = DimenUtil.getScreenHeight();
            final Window dialogWindow = mLoader.getWindow();
            if (dialogWindow != null) {
                final WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                lp.width = deviceWidth / LOADER_SIZE_SCALE;
                lp.height = deviceHeight / LOADER_SIZE_SCALE;
                lp.gravity = Gravity.CENTER;
            }
            mLoader.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    return true;
                }
            });
            mLoader.setCanceledOnTouchOutside(false);
        }
        mLoader.show();
    }

    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    public static void stopLoading() {
        if (mLoader != null) {
            mLoader.cancel();
        }
    }

    public static void destroy() {
        mLoader = null;
    }

}
