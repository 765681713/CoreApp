package com.yhw.wan.coreapp.main.setting;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.yhw.wan.core.utils.callback.CallbackManager;
import com.yhw.wan.core.utils.callback.CallbackType;
import com.yhw.wan.core.utils.callback.IGlobalCallback;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by BYDeXL on 2018/1/9.
 */

public class SettingPresenter extends SettingContract.SettingPresenter {

    @Override
    protected void loadData(String url) {
        final SettingContract.SettingView mView = getView();
        if (mView == null) {
            return;
        }
        mView.showLoading();
        CallbackManager.getInstance()
                .addCallback(CallbackType.LOAD_SUCCESS, new IGlobalCallback<String>() {
                    @Override
                    public void executeCallback(@Nullable String args) {
                        mView.hideLoading();
                        mView.setData(null);
                    }
                })
                .addCallback(CallbackType.LOAD_FAILUER, new IGlobalCallback<String>() {
                    @Override
                    public void executeCallback(@Nullable String args) {
                        mView.hideLoading();
                        mView.showError();
                    }
                })
                .addCallback(CallbackType.LOAD_ERROR, new IGlobalCallback<String>() {
                    @Override
                    public void executeCallback(@Nullable String args) {
                        mView.hideLoading();
                        mView.showError();
                    }
                });
        mModel.loadDaily(url);
    }

    @Override
    protected void loadData2(String url) {
        final SettingContract.SettingView mView = getView();
        if (mView == null) {
            return;
        }
        mView.showLoading();
        Observable.just(url).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        if (TextUtils.isEmpty(s)) {
                            mView.setData(null);
                        } else {
                            mView.showError();
                        }
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        mView.showError();
                        mView.hideLoading();
                    }
                });
    }
}
