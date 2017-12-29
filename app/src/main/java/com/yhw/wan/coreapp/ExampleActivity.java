package com.yhw.wan.coreapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.yhw.wan.core.activities.ProxyActivity;
import com.yhw.wan.core.app.Core;
import com.yhw.wan.core.delegates.CoreDelegate;
import com.yhw.wan.coreapp.main.launcher.LauncherDelegate;
import com.yhw.wan.ui.launcher.ILauncherListener;
import com.yhw.wan.ui.launcher.OnLauncherFinishTag;

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

//        CoreGreenDao.getInstance().getDaoSession().getUserProfileDao()
//        GlideApp
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
//        RxBus.getInstance().register()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<RxBusMsg>() {
//                    @Override
//                    public void accept(RxBusMsg msg) throws Exception {
//                        if (msg.getRequest() == RxBusMsg.REQUEST_ONE) {
//                            CoreLogger.i("ExampleActivity", msg + "");
//                        }
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        throwable.printStackTrace();
//                    }
//                });
//        RxBus.getInstance().post(
//                new RxBusMsg.Builder<String>(RxBusMsg.REQUEST_ONE)
//                        .data("REQUEST_ONE").msg("REQUEST_ONE").build());
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
        return new LauncherDelegate();
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        RxBus.getInstance().unregisterAll();
        Core.getConfigurator().rmActivity();
    }


}
