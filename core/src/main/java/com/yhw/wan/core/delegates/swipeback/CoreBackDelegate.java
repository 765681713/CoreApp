package com.yhw.wan.core.delegates.swipeback;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by 傅令杰 on 2017/4/2
 */

public abstract class CoreBackDelegate extends BaseBackFragment {

    @SuppressWarnings("unchecked")
    public <T extends CoreBackDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

}
