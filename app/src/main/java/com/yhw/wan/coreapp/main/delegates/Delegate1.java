package com.yhw.wan.coreapp.main.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.yhw.wan.core.delegates.bottom.BottomItemDelegate;
import com.yhw.wan.core.net.rx.RxRestClient;
import com.yhw.wan.coreapp.R;
import com.yhw.wan.coreapp.adapter.Delegate1Adapter;
import com.yhw.wan.coreapp.adapter.Delegate1Converter;
import com.yhw.wan.ui.recycler.BaseDecoration;
import com.yhw.wan.ui.recycler.MultipleItemEntity;
import com.yhw.wan.ui.recycler.RecyclerItemListener;

import java.util.ArrayList;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by jieku02 on 2017/12/21.
 */

public class Delegate1 extends BottomItemDelegate {

    @BindView(R.id.refresh_layout)
    TwinklingRefreshLayout mRefreshLayout = null;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView = null;

    private ArrayList<MultipleItemEntity> datas;

    @Override
    public Object setLayout() {
        return R.layout.delegate_layout_1;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
//        mRefreshLayout = rootView.findViewById(R.id.refresh_layout);
//        mRecyclerView = rootView.findViewById(R.id.recycler_view);

        datas = new ArrayList<>();
        ProgressLayout headerView = new ProgressLayout(getContext());
        mRefreshLayout.setHeaderView(headerView);
        mRefreshLayout.setMaxHeadHeight(140);
        mRefreshLayout.setOverScrollBottomShow(false);
        mRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {

            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {

            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(BaseDecoration.create(
                ContextCompat.getColor(getContext(),
                        R.color.app_background), 5));
        mRecyclerView.addOnItemTouchListener(new RecyclerItemListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
        mRecyclerView.setAdapter(new Delegate1Adapter(datas));

        RxRestClient.builder().url("/test.php")
                .build()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        datas.addAll(new Delegate1Converter().setJsonData(s).convert());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });

    }

}
