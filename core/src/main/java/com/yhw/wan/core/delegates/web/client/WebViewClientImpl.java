package com.yhw.wan.core.delegates.web.client;

import android.graphics.Bitmap;
import android.os.Handler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.yhw.wan.core.app.Core;
import com.yhw.wan.core.delegates.IPageLoadListener;
import com.yhw.wan.core.delegates.web.WebDelegate;
import com.yhw.wan.core.delegates.web.route.Router;
import com.yhw.wan.core.ui.loader.CoreLoader;
import com.yhw.wan.core.util.log.LatteLogger;

/**
 * Created by 傅令杰
 */

public class WebViewClientImpl extends WebViewClient {

    private final WebDelegate DELEGATE;
    private IPageLoadListener mIPageLoadListener = null;
    private static final Handler HANDLER = Core.getHandler();

    public void setPageLoadListener(IPageLoadListener listener) {
        this.mIPageLoadListener = listener;
    }

    public WebViewClientImpl(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        LatteLogger.d("shouldOverrideUrlLoading", url);
        return Router.getInstance().handleWebUrl(DELEGATE, url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadStart();
        }
        CoreLoader.showLoading(view.getContext());
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (mIPageLoadListener != null) {
            mIPageLoadListener.onLoadEnd();
        }
        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                CoreLoader.stopLoading();
            }
        }, 1000);
    }
}
