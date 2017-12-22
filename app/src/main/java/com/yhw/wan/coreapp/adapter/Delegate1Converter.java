package com.yhw.wan.coreapp.adapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yhw.wan.ui.recycler.DataConverter;
import com.yhw.wan.ui.recycler.ItemType;
import com.yhw.wan.ui.recycler.MultipleFields;
import com.yhw.wan.ui.recycler.MultipleItemEntity;

import java.util.ArrayList;

/**
 * Created by jieku02 on 2017/12/21.
 */

public class Delegate1Converter extends DataConverter {

    @Override
    public ArrayList<MultipleItemEntity> convert() {
        final JSONArray dataArray = JSON.parseObject(getJsonData()).getJSONArray("data");
        final int size = dataArray.size();
        for (int i = 0; i < size; i++) {
            final JSONObject data = dataArray.getJSONObject(i);
            final String key = data.getString("key" + (i + 1));
            final MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setField(MultipleFields.ITEM_TYPE, ItemType.TEXT)
                    .setField(MultipleFields.KEY, key)
                    .build();
            ENTITIES.add(entity);
        }
        return ENTITIES;
    }

}
