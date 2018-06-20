package com.yhw.wan.core.basemvp;

import java.lang.ref.WeakReference;

/**
 * Created by BYDeXL on 2018/1/9.
 */

public abstract class BasePresenter<M, V> {
    protected M mModel;
    private WeakReference<V> mViewRef;

    void onAttach(M model, V view) {
        mModel = model;
        mViewRef = new WeakReference<>(view);
    }

    protected V getView() {
        return isViewAttached() ? mViewRef.get() : null;
    }

    private boolean isViewAttached() {
        return null != mViewRef && null != mViewRef.get();
    }

    void onDetach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}