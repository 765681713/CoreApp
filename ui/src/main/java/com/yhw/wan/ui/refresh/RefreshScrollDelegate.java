package com.yhw.wan.ui.refresh;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yhw.wan.core.delegates.CoreDelegate;
import com.yhw.wan.ui.R;
import com.yhw.wan.ui.R2;
import com.yhw.wan.ui.recycler.MultipleItemEntity;

import butterknife.BindView;

/**
 * Created by jieku02 on 2017/12/25.
 */

public abstract class RefreshScrollDelegate extends CoreDelegate implements OnRefreshListener {

    @BindView(R2.id.refresh_layout)
    RefreshLayout mRefreshLayout = null;
    @BindView(R2.id.scroll_view)
    ScrollView mScrollView = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_refresh_scroll;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        showTitleBar();
        showLeftBtn();
        mRefreshLayout.setPrimaryColorsId(R.color.color_029ff1, R.color.common_white);//全局设置主题颜色
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadmore(false);//是否启用上拉加载功能
        mRefreshLayout.setDisableContentWhenRefresh(true);//是否在刷新的时候禁止列表的操作
        mRefreshLayout.setDisableContentWhenLoading(true);//是否在加载的时候禁止列表的操作
        mRefreshLayout.setOnRefreshListener(this);
        mScrollView.addView(initView());
        refreshData();
    }

    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    private void refreshData() {
        loadData();
    }

    protected void onRefreshFinish(MultipleItemEntity entity) {
        if (entity != null) {
            updateView(entity);
        }
        mRefreshLayout.finishRefresh(2000);
    }

    protected abstract void loadData();

    protected abstract void updateView(MultipleItemEntity entity);

    protected abstract View initView();

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        refreshData();
    }

}
