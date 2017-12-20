package com.yhw.wan.core.delegates.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.yhw.wan.core.delegates.web.event.Event;
import com.yhw.wan.core.delegates.web.event.EventManager;
import com.yhw.wan.core.util.log.LatteLogger;

/**
 * Created by 傅令杰
 */

final class CoreWebInterface {
    private final WebDelegate DELEGATE;

    private CoreWebInterface(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    static CoreWebInterface create(WebDelegate delegate) {
        return new CoreWebInterface(delegate);
    }

    @SuppressWarnings("unused")
    @JavascriptInterface
    public String event(String params) {
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        LatteLogger.d("WEB_EVENT",params);
        if (event != null) {
            event.setAction(action);
            event.setDelegate(DELEGATE);
            event.setContext(DELEGATE.getContext());
            event.setUrl(DELEGATE.getUrl());
            return event.execute(params);
        }
        return null;
    }
}
