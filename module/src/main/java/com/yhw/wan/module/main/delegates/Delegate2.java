package com.yhw.wan.module.main.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.yhw.wan.core.delegates.bottom.BottomItemDelegate;
import com.yhw.wan.module.R;

/**
 * Created by jieku02 on 2017/12/21.
 */

public class Delegate2 extends BottomItemDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_layout_2;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }
    
}
