package com.yhw.wan.coreapp.main.setting;

import android.widget.Button;

import com.yhw.wan.core.basemvp.BaseMVPDelegate;
import com.yhw.wan.core.ui.loader.CoreLoader;
import com.yhw.wan.coreapp.R;
import com.yhw.wan.ui.recycler.MultipleItemEntity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by jieku02 on 2018/1/9.
 */

public class Setting4Delegate extends BaseMVPDelegate<SettingPresenter, SettingModel>
        implements SettingContract.SettingView {

    @BindView(R.id.button3)
    Button mButton;

    @Override
    protected void loadData() {
        mButton.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.loadData("");
            }
        }, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_setting4_layout;
    }

    @Override
    public void setData(List<MultipleItemEntity> beanList) {
        mButton.setText("啥啥啥时好时坏收拾收拾");
    }

    @Override
    public void showLoading() {
        CoreLoader.showLoading(getContext());
    }

    @Override
    public void hideLoading() {
        mButton.postDelayed(new Runnable() {
            @Override
            public void run() {
                CoreLoader.stopLoading();
            }
        }, 2000);
    }

    @Override
    public void showError() {
        mButton.setText("123456789");
    }
}
