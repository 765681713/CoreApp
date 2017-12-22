package com.yhw.wan.coreapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.yhw.wan.core.activities.ProxyActivity;
import com.yhw.wan.core.app.Core;
import com.yhw.wan.core.delegates.CoreDelegate;
import com.yhw.wan.coreapp.main.EcBottomDelegate;
import com.yhw.wan.ui.launcher.ILauncherListener;
import com.yhw.wan.ui.launcher.OnLauncherFinishTag;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import qiu.niorgai.StatusBarCompat;

public class ExampleActivity extends ProxyActivity implements
        ILauncherListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Core.getConfigurator().withActivity(this);
        StatusBarCompat.translucentStatusBar(this, true);
//        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public CoreDelegate setRootDelegate() {
        return new EcBottomDelegate();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag tag) {
        switch (tag) {
            case SIGNED:
//                Toast.makeText(this, "启动结束，用户登录了", Toast.LENGTH_LONG).show();
//                getSupportDelegate().startWithPop(new EcBottomDelegate());
                break;
            case NOT_SIGNED:
//                Toast.makeText(this, "启动结束，用户没登录", Toast.LENGTH_LONG).show();
//                getSupportDelegate().startWithPop(new SignInDelegate());
                break;
            default:
                break;
        }
    }

    @Subscribe
    public void fuc(){

    }
}
