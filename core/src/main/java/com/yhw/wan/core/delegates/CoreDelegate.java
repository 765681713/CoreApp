package com.yhw.wan.core.delegates;

/**
 * Created by 傅令杰 on 2017/4/2
 */

public abstract class CoreDelegate extends BaseDelegate {

    @SuppressWarnings("unchecked")
    public <T extends CoreDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }

}
