package com.yhw.wan.ui.refresh;

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
import com.yhw.wan.core.delegates.CoreDelegate;
import com.yhw.wan.ui.R;
import com.yhw.wan.ui.R2;
import com.yhw.wan.ui.recycler.BaseDecoration;
import com.yhw.wan.ui.recycler.MultipleItemEntity;
import com.yhw.wan.ui.recycler.MultipleRecyclerAdapter;
import com.yhw.wan.ui.recycler.RecyclerItemListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by jieku02 on 2017/12/25.
 */

public abstract class RefreshListDelegate extends CoreDelegate {

    @BindView(R2.id.refresh_layout)
    TwinklingRefreshLayout mRefreshLayout = null;
    @BindView(R2.id.recycler_view)
    RecyclerView mRecyclerView = null;

    private ArrayList<MultipleItemEntity> datas;
    private int mCurrentPage = 1;
    private MultipleRecyclerAdapter mAdapter = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_refresh_list;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        hideTitleBar();
        hideLeftBtn();
        datas = new ArrayList<>();
        ProgressLayout headerView = new ProgressLayout(getContext());
        mRefreshLayout.setHeaderView(headerView);
        mRefreshLayout.setMaxHeadHeight(140);
        mRefreshLayout.setOverScrollBottomShow(false);
        mRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                refreshData();
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                loadMoreData();
            }
        });
        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.addItemDecoration(BaseDecoration.create(
                ContextCompat.getColor(getContext(), R.color.app_background), 2));
        mRecyclerView.addOnItemTouchListener(new RecyclerItemListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                RefreshListDelegate.this.onItemClick(view, position, datas);
            }
        });
        mAdapter = getAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);
        initView();
        refreshData();
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    private void loadMoreData() {
        mCurrentPage++;
        loadData(mCurrentPage, false);
    }

    private void refreshData() {
        mCurrentPage = 1;
        loadData(mCurrentPage, true);
    }

    protected void onRefreshFinish(List<MultipleItemEntity> list) {
        if (list == null || list.isEmpty()) {
            mRefreshLayout.finishRefreshing();
            return;
        }
        datas.clear();
        datas.addAll(list);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefreshing();
    }

    protected void onLoadMoreFinish(List<MultipleItemEntity> list) {
        if (list == null || list.isEmpty()) {
            mRefreshLayout.finishLoadmore();
            return;
        }
        datas.addAll(list);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore();
    }

    protected abstract void loadData(int page, boolean isRefresh);

    protected abstract void initView();

    protected abstract MultipleRecyclerAdapter getAdapter(List<MultipleItemEntity> data);

    protected abstract void onItemClick(View view, int position, List<MultipleItemEntity> data);

}
