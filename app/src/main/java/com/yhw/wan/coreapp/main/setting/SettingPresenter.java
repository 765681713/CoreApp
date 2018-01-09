package com.yhw.wan.coreapp.main.setting;

/**
 * Created by jieku02 on 2018/1/9.
 */

public class SettingPresenter extends SettingContract.SettingPresenter {

    @Override
    protected void loadData(String url) {
        final SettingContract.SettingView mView = getView();
        if (mView == null) {
            return;
        }
        mView.showLoading();
        mModel.loadDaily(url);
        mView.hideLoading();
        mView.setData(null);
    }

}
