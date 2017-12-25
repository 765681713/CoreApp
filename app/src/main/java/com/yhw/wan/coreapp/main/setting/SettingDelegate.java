package com.yhw.wan.coreapp.main.setting;

import android.view.View;

import com.yhw.wan.core.net.rx.RxRestClient;
import com.yhw.wan.coreapp.adapter.Delegate1Adapter;
import com.yhw.wan.coreapp.adapter.Delegate1Converter;
import com.yhw.wan.coreapp.common.Constants;
import com.yhw.wan.ui.recycler.MultipleItemEntity;
import com.yhw.wan.ui.recycler.MultipleRecyclerAdapter;
import com.yhw.wan.ui.refresh.RefreshListDelegate;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by jieku02 on 2017/12/21.
 */

public class SettingDelegate extends RefreshListDelegate {

    @Override
    protected void initView() {
        showTitleBar();
        showLeftBtn();
        setTitle("Setting");
    }

    @Override
    protected MultipleRecyclerAdapter getAdapter(List<MultipleItemEntity> data) {
        return Delegate1Adapter.create(data);
    }

    @Override
    protected void loadData(int page, final boolean isRefresh) {
        RxRestClient.builder().url(Constants.TEST)
                .params(Constants.PAGE, page)
                .build()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        List<MultipleItemEntity> list = new Delegate1Converter().setJsonData(s).convert();
                        if (isRefresh) {
                            onRefreshFinish(list);
                        } else {
                            onLoadMoreFinish(list);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        if (isRefresh) {
                            onRefreshFinish(null);
                        } else {
                            onLoadMoreFinish(null);
                        }
                    }
                });
    }

    @Override
    protected void onItemClick(View view, int position, List<MultipleItemEntity> data) {

    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

}
