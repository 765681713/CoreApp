package com.yhw.wan.coreapp;


import android.support.multidex.MultiDexApplication;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.yhw.wan.core.app.Core;
import com.yhw.wan.core.net.interceptors.DebugInterceptor;
import com.yhw.wan.coreapp.utils.event.ShareEvent;
import com.yhw.wan.coreapp.utils.event.TestEvent;
import com.yhw.wan.coreapp.utils.icon.FontEcModule;

/**
 * Created by jieku02 on 2017/12/19.
 */

public class ExampleApp extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Core.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://www.yhw.wan.com")
                .withInterceptor(new DebugInterceptor("test", R.raw.test))
                .withWeChatAppId("你的微信AppKey")
                .withWeChatAppSecret("你的微信AppSecret")
                .withJavascriptInterface("core")
                .withWebEvent("test", new TestEvent())
                .withWebEvent("share", new ShareEvent())
                .configure();
//        initStetho();
//        DatabaseManager.getInstance().init(this);

//        CallbackManager.getInstance()
//                .addCallback(CallbackType.TAG_OPEN_PUSH, new IGlobalCallback() {
//                    @Override
//                    public void executeCallback(@Nullable Object args) {
//
//                    }
//                })
//                .addCallback(CallbackType.TAG_STOP_PUSH, new IGlobalCallback() {
//                    @Override
//                    public void executeCallback(@Nullable Object args) {
//
//                    }
//                });
    }
}