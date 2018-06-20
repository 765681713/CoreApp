package com.yhw.wan.core.utils.callback;

import android.support.annotation.Nullable;

/**
 * Created by 刘世波
 */

public interface IGlobalCallback<T> {

    void executeCallback(@Nullable T args);
}
