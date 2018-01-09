package com.yhw.wan.core.basemvp;

import java.lang.ref.WeakReference;

/**
 * Created by jieku02 on 2018/1/9.
 */

public abstract class BasePresenter<M, V> {
    protected M mModel;
    protected WeakReference<V> mViewRef;

    protected void onAttach(M model, V view) {
        mModel = model;
        mViewRef = new WeakReference<>(view);
    }

    protected V getView() {
        return isViewAttached() ? mViewRef.get() : null;
    }

    protected boolean isViewAttached() {
        return null != mViewRef && null != mViewRef.get();
    }

    protected void onDetach() {
        if (null != mViewRef) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}