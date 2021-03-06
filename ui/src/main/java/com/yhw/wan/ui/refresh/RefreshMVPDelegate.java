package com.yhw.wan.ui.refresh;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yhw.wan.core.basemvp.BaseMVPDelegate;
import com.yhw.wan.core.basemvp.BaseModel;
import com.yhw.wan.core.basemvp.BasePresenter;
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
 * Created by BYDeXL on 2017/12/25.
 */

public abstract class RefreshMVPDelegate<T extends BasePresenter, M extends BaseModel>
        extends BaseMVPDelegate<T, M> implements OnRefreshListener, OnLoadmoreListener {

    @BindView(R2.id.refresh_layout)
    RefreshLayout mRefreshLayout = null;
    @BindView(R2.id.recycler_view)
    RecyclerView mRecyclerView = null;

    private ArrayList<MultipleItemEntity> mData;
    private int mCurrentPage = 1;
    private MultipleRecyclerAdapter mAdapter = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_refresh_list;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        super.onBindView(savedInstanceState, rootView);
        hideTitleBar();
        mRefreshLayout.setPrimaryColorsId(R.color.color_029ff1, R.color.common_white);//全局设置主题颜色
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadmore(true);//是否启用上拉加载功能
//        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(false);//是否在列表不满一页时候开启上拉加载功能
        mRefreshLayout.setDisableContentWhenRefresh(true);//是否在刷新的时候禁止列表的操作
        mRefreshLayout.setDisableContentWhenLoading(true);//是否在加载的时候禁止列表的操作
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        mData = new ArrayList<>();
        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.addItemDecoration(BaseDecoration.create(
                ContextCompat.getColor(getContext(), R.color.app_background), 2));
        mRecyclerView.addOnItemTouchListener(new RecyclerItemListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                RefreshMVPDelegate.this.onItemClick(view, position, mData);
            }
        });
        mAdapter = getAdapter(mData);
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
            mRefreshLayout.finishRefresh(2000);
            return;
        }
        mData.clear();
        mData.addAll(list);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishRefresh(2000);
    }

    protected void onLoadMoreFinish(List<MultipleItemEntity> list) {
        if (list == null || list.isEmpty()) {
            mRefreshLayout.finishLoadmore(2000);
            return;
        }
        mData.addAll(list);
        mAdapter.notifyDataSetChanged();
        mRefreshLayout.finishLoadmore(2000);
    }

    protected abstract void loadData(int page, boolean isRefresh);

    protected abstract void initView();

    protected abstract MultipleRecyclerAdapter getAdapter(List<MultipleItemEntity> data);

    protected abstract void onItemClick(View view, int position, List<MultipleItemEntity> data);

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        refreshData();
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        loadMoreData();
    }
}
