/**
 * Copyright 2017 JessYan
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yhw.wan.core.utils;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.internal.Preconditions;
import com.yhw.wan.core.basemvp.BaseView;

import io.reactivex.annotations.NonNull;

/**
 * ================================================
 * 使用此类操作 RxLifecycle 的特性
 * <p>
 * Created by JessYan on 26/08/2017 17:52
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */

public class RxLifeUtils {

    private RxLifeUtils() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    /**
     * 绑定 Activity/Fragment 的生命周期
     * @param view
     * @return
     */
    public static<T> LifecycleTransformer<T> bindToLifecycle(@NonNull BaseView view) {
        Preconditions.checkNotNull(view, "view == null");
        if (view instanceof LifecycleProvider) {
            return ((LifecycleProvider<T>) view).bindToLifecycle();
        } else {
            throw new IllegalArgumentException("view isn't Lifecycleable");
        }
    }

}
