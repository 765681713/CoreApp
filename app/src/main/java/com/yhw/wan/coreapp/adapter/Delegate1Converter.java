package com.yhw.wan.coreapp.adapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yhw.wan.core.util.log.CoreLogger;
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
        try {
            final JSONObject jsonObject = JSON.parseObject(getJsonData());
            final int code = jsonObject.getInteger("code");
            if (code == 1) {
                final JSONArray dataArray = jsonObject.getJSONArray("data");
                final int size = dataArray.size();
                for (int i = 0; i < size; i++) {
                    final JSONObject data = dataArray.getJSONObject(i);
                    final String key = data.getString("key" + (i + 1));
                    final MultipleItemEntity entity = MultipleItemEntity.builder()
                            .setItemType(ItemType.TEXT)
                            .setField(MultipleFields.KEY, key)
                            .build();
                    ENTITIES.add(entity);
                }
                return ENTITIES;
            } else {
                CoreLogger.w("DataConverter : ", getJsonData());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
