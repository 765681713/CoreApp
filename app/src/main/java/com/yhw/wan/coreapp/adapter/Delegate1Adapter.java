package com.yhw.wan.coreapp.adapter;

import com.yhw.wan.coreapp.R;
import com.yhw.wan.ui.recycler.ItemType;
import com.yhw.wan.ui.recycler.MultipleFields;
import com.yhw.wan.ui.recycler.MultipleItemEntity;
import com.yhw.wan.ui.recycler.MultipleRecyclerAdapter;
import com.yhw.wan.ui.recycler.MultipleViewHolder;

import java.util.List;

/**
 * Created by BYDeXL on 2017/12/21.
 */

public class Delegate1Adapter extends MultipleRecyclerAdapter {

    public static Delegate1Adapter create(List<MultipleItemEntity> data) {
        return new Delegate1Adapter(data);
    }

    private Delegate1Adapter(List<MultipleItemEntity> data) {
        super(data);
    }

    @Override
    protected void addType() {
        addItemType(ItemType.TEXT, R.layout.item_multiple_text);

    }

    @Override
    protected void convert(MultipleViewHolder holder, MultipleItemEntity entity) {
        switch (holder.getItemViewType()) {
            case ItemType.TEXT:
                String text = String.format("{fa-%s}", entity.getField(MultipleFields.KEY));
                holder.setText(R.id.text_single, text);
                break;
        }
    }

}
