package com.yhw.wan.coreapp.main.setting;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.yhw.wan.core.delegates.swipeback.CoreBackDelegate;
import com.yhw.wan.coreapp.R;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by BYDeXL on 2017/12/21.
 */

public class Setting2Delegate extends CoreBackDelegate {


    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_setting_layout;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        showTitleBar();
        showLeftBtn();
    }
}
