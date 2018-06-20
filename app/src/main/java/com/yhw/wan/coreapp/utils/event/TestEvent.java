package com.yhw.wan.coreapp.utils.event;

import android.webkit.WebView;
import android.widget.Toast;

import com.yhw.wan.core.delegates.web.event.Event;


/**
 * Created by 刘世波
 */

public class TestEvent extends Event {
    @Override
    public String execute(String params) {
        Toast.makeText(getContext(), getAction(), Toast.LENGTH_LONG).show();
        if (getAction().equals("test")) {
            final WebView webView = getWebView();
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.evaluateJavascript("nativeCall();", null);
                }
            });
        }
        return null;
    }
}
