package com.yhw.wan.coreapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.yhw.wan.core.delegates.CoreDelegate;

import butterknife.OnClick;

/**
 * Created by 傅令杰 on 2017/4/2
 */

public class ExampleDelegate extends CoreDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @OnClick(R.id.btn_test)
    void onClickTest() {
        testWX();
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
//        testRestClient();
    }

    private void testWX() {
    }
}
