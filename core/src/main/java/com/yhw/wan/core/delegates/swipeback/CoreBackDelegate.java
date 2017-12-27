package com.yhw.wan.core.delegates.swipeback;

/**
 * Created by 傅令杰 on 2017/4/2
 */

public abstract class CoreBackDelegate extends BaseBackFragment {

    @SuppressWarnings("unchecked")
    public <T extends CoreBackDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }

}
