package com.yhw.wan.core.ui.loader;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.wang.avi.AVLoadingIndicatorView;
import com.yhw.wan.core.R;
import com.yhw.wan.core.utils.DimenUtil;


/**
 * Created by 傅令杰 on 2017/4/2
 */

public class CoreLoader {

    private static final int LOADER_SIZE_SCALE = 8;
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
            mLoader.setContentView(avLoadingIndicatorView);
            int deviceWidth = DimenUtil.getScreenWidth();
            int deviceHeight = DimenUtil.getScreenHeight();
            final Window dialogWindow = mLoader.getWindow();
            if (dialogWindow != null) {
                final WindowManager.LayoutParams lp = dialogWindow.getAttributes();
                lp.width = deviceWidth / LOADER_SIZE_SCALE;
                lp.height = deviceHeight / LOADER_SIZE_SCALE;
                lp.height = lp.height + deviceHeight / LOADER_OFFSET_SCALE;
                lp.gravity = Gravity.CENTER;
            }
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
