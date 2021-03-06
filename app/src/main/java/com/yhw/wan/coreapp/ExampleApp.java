package com.yhw.wan.coreapp;


import android.content.Context;
import android.support.multidex.MultiDex;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.yhw.wan.core.app.Core;
import com.yhw.wan.core.app.LeakCanaryApplication;
import com.yhw.wan.core.net.interceptors.DebugInterceptor;
import com.yhw.wan.coreapp.utils.crash.CrashHandler;
import com.yhw.wan.coreapp.utils.event.ShareEvent;
import com.yhw.wan.coreapp.utils.event.TestEvent;
import com.yhw.wan.coreapp.utils.icon.FontEcModule;

/**
 * Created by BYDeXL on 2017/12/19.
 */

public class ExampleApp extends LeakCanaryApplication {

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
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}