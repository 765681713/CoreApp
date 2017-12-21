package com.yhw.wan.module.main;

import android.graphics.Color;


import com.yhw.wan.core.delegates.bottom.BaseBottomDelegate;
import com.yhw.wan.core.delegates.bottom.BottomItemDelegate;
import com.yhw.wan.core.delegates.bottom.BottomTabBean;
import com.yhw.wan.core.delegates.bottom.ItemBuilder;
import com.yhw.wan.module.main.delegates.Delegate1;
import com.yhw.wan.module.main.delegates.Delegate2;
import com.yhw.wan.module.main.delegates.Delegate3;
import com.yhw.wan.module.main.delegates.Delegate4;

import java.util.LinkedHashMap;

/**
 * Created by 傅令杰
 */

public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "Delegate1"), new Delegate1());
        items.put(new BottomTabBean("{fa-sort}", "Delegate2"), new Delegate2());
        items.put(new BottomTabBean("{fa-compass}", "Delegate3"), new Delegate3());
        items.put(new BottomTabBean("{fa-shopping-cart}", "Delegate4"), new Delegate4());
        return builder.addItems(items).build();
    }

    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
