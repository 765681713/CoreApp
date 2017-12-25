package com.yhw.wan.ui.recycler;

import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;

import java.util.List;

/**
 * Created by 傅令杰
 */

public abstract class MultipleRecyclerAdapter extends
        BaseMultiItemQuickAdapter<MultipleItemEntity, MultipleViewHolder> {

    protected MultipleRecyclerAdapter(List<MultipleItemEntity> data) {
        super(data);
        init();
    }

    public void refresh(List<MultipleItemEntity> data) {
        getData().clear();
        setNewData(data);
        notifyDataSetChanged();
    }

    //设置不同的item布局
    private void init() {
        addType();
        openLoadAnimation();
        //多次执行动画
        isFirstOnly(false);
    }

    protected abstract void addType();

    @Override
    protected MultipleViewHolder createBaseViewHolder(View view) {
        return MultipleViewHolder.create(view);
    }

}
