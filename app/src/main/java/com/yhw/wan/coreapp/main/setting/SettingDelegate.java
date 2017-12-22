package com.yhw.wan.coreapp.main.setting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.yhw.wan.core.delegates.CoreDelegate;
import com.yhw.wan.coreapp.R;

/**
 * Created by jieku02 on 2017/12/21.
 */

public class SettingDelegate extends CoreDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_setting_layout;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        showTitleBar();

    }

}
