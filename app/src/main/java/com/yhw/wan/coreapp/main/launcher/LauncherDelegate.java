package com.yhw.wan.coreapp.main.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.yhw.wan.core.delegates.CoreDelegate;
import com.yhw.wan.core.util.storage.CorePreference;
import com.yhw.wan.coreapp.R;
import com.yhw.wan.coreapp.main.EcBottomDelegate;
import com.yhw.wan.ui.launcher.ILauncherListener;
import com.yhw.wan.ui.launcher.OnLauncherFinishTag;
import com.yhw.wan.ui.launcher.ScrollLauncherTag;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;


/**
 * Created by 傅令杰 on 2017/4/22
 */

public class LauncherDelegate extends CoreDelegate {

    @BindView(R.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    private int mCount = 3;
    private ILauncherListener mILauncherListener = null;

    @OnClick(R.id.tv_launcher_timer)
    void onClickTimerView() {
        checkIsShowScroll();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener) {
            mILauncherListener = (ILauncherListener) activity;
        }
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        intervalTime();
    }

    //判断是否显示滑动启动页
    private void checkIsShowScroll() {
        if (!CorePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name())) {
            getSupportDelegate().start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
            getSupportDelegate().start(new EcBottomDelegate(), SINGLETASK);
            if (mILauncherListener != null) {
                mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
            }
        }
    }

    //倒计时
    public void intervalTime() {
        //倒计时
        Observable.interval(0, 1, TimeUnit.SECONDS)//设置0延迟，每隔一秒发送一条数据
                .take(mCount + 1)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return mCount - aLong; //
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//操作UI主要在UI线程
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Long value) {
                        mTvTimer.setText(MessageFormat.format("跳过\n{0}s", value));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        checkIsShowScroll();
                    }
                });
    }

}
