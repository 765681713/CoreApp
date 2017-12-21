package com.yhw.wan.module.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.yhw.wan.module.R;
import com.yhw.wan.ui.recycler.ItemType;
import com.yhw.wan.ui.recycler.MultipleFields;
import com.yhw.wan.ui.recycler.MultipleItemEntity;
import com.yhw.wan.ui.recycler.MultipleViewHolder;

import java.util.List;

/**
 * Created by jieku02 on 2017/12/21.
 */

public class Delegate1Adapter extends BaseMultiItemQuickAdapter<MultipleItemEntity, MultipleViewHolder> {


    public Delegate1Adapter(List<MultipleItemEntity> data) {
        super(data);
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);
        openLoadAnimation();
        //多次执行动画
        isFirstOnly(false);
    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {
        switch (holder.getItemViewType()) {
            case ItemType.TEXT:
                String text = entity.getField(MultipleFields.KEY);
                holder.setText(R.id.text_single, text);
                break;
        }
    }

}
