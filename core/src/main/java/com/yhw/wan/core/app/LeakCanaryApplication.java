package com.yhw.wan.core.app;

import android.support.multidex.MultiDexApplication;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by jieku02 on 2017/12/28.
 */

public class LeakCanaryApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

}
