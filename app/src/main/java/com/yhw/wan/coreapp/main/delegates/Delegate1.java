package com.yhw.wan.coreapp.main.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.yhw.wan.core.delegates.bottom.BottomItemDelegate;
import com.yhw.wan.core.delegates.web.WebDelegateImpl;
import com.yhw.wan.coreapp.R;
import com.yhw.wan.coreapp.main.setting.Setting2Delegate;
import com.yhw.wan.coreapp.main.setting.Setting3Delegate;
import com.yhw.wan.coreapp.main.setting.Setting4Delegate;
import com.yhw.wan.coreapp.main.setting.SettingDelegate;

import butterknife.OnClick;

/**
 * Created by BYDeXL on 2017/12/21.
 */

public class Delegate1 extends BottomItemDelegate {

    @OnClick(R.id.textView2)
    void onTvClick() {
        getParentDelegate().getSupportDelegate().start(new SettingDelegate());
    }

    @OnClick(R.id.textView3)
    void onTv2Click() {
        getParentDelegate().getSupportDelegate().start(new Setting3Delegate());
    }

    @OnClick(R.id.textView4)
    void onTv3Click() {
        getParentDelegate().getSupportDelegate().start(new Setting2Delegate());
    }

    @OnClick(R.id.textView5)
    void onTv4Click() {
        getParentDelegate().getSupportDelegate().start(new Setting4Delegate());
    }

    @OnClick(R.id.textView6)
    void onTv5Click() {
        getParentDelegate().getSupportDelegate().start(WebDelegateImpl.create("http://www.gghypt.net/"));
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_layout_1;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        showTitleBar();
        hideLeftBtn();
        setTitle("Delegate1");
    }

}
