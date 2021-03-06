package com.yhw.wan.core.basemvp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.yhw.wan.core.delegates.CoreDelegate;

import java.lang.reflect.ParameterizedType;

/**
 * Created by BYDeXL on 2018/1/9.
 */

public abstract class BaseMVPDelegate<T extends BasePresenter, M extends BaseModel> extends CoreDelegate {
    protected T mPresenter;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        mPresenter = getTInstance(0);
        mPresenter.onAttach(getTInstance(1), this);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadData();
    }

    protected abstract void loadData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    private <T> T getTInstance(int i) {
        try {
            return ((Class<T>) ((ParameterizedType) (getClass().getGenericSuperclass()))
                    .getActualTypeArguments()[i]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
