package com.yhw.wan.coreapp.main.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.swisstar.facesdk.FaceManager;
import com.yhw.wan.core.delegates.bottom.BottomItemDelegate;
import com.yhw.wan.coreapp.R;

/**
 * Created by jieku02 on 2017/12/21.
 */

public class Delegate3 extends BottomItemDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_layout_3;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
//        FaceManager.getInstance().getDevicesId(this);
    }
    
}
