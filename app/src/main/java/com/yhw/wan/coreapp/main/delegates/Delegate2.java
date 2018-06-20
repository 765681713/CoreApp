package com.yhw.wan.coreapp.main.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;
import com.yhw.wan.core.delegates.bottom.BottomItemDelegate;
import com.yhw.wan.coreapp.R;
import com.yhw.wan.coreapp.utils.PayUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by BYDeXL on 2017/12/21.
 */

public class Delegate2 extends BottomItemDelegate {

    @BindView(R.id.button)
    Button mBtn1;

    @BindView(R.id.button2)
    Button mBtn2;

    @OnClick(R.id.button)
    void onBtn1Click() {
        new MaterialDialog.Builder(getContext())
                .title(" base ")
                .content(" MaterialDialog ")
                .positiveText("确定")
                .positiveColorRes(R.color.common_black)
                .negativeText("取消")
                .show();
    }

    @OnClick(R.id.button2)
    void onBtn2Click() {
//        Dialog dialog = new AlertDialog.Builder(getContext()).create();
        PayUtils.create(this).beginPayDialog();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_layout_2;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        hideTitleBar();
    }

}
