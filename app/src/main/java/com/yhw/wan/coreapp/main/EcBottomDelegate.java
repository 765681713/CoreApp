package com.yhw.wan.coreapp.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yhw.wan.core.delegates.bottom.BaseBottomDelegate;
import com.yhw.wan.core.delegates.bottom.BottomItemDelegate;
import com.yhw.wan.core.delegates.bottom.BottomTabBean;
import com.yhw.wan.core.delegates.bottom.ItemBuilder;
import com.yhw.wan.core.utils.StatusBarUtils;
import com.yhw.wan.coreapp.main.delegates.Delegate1;
import com.yhw.wan.coreapp.main.delegates.Delegate2;
import com.yhw.wan.coreapp.main.delegates.Delegate3;
import com.yhw.wan.coreapp.main.delegates.Delegate4;

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
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (getView() != null) {
            getView().postDelayed(new Runnable() {
                @Override
                public void run() {
                    StatusBarUtils.showStatusBar(getProxyActivity().getWindow());
                }
            }, 250);
        }
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
