package com.yhw.wan.coreapp.main.setting;

import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.yhw.wan.core.net.rx.RxRestClient;
import com.yhw.wan.coreapp.R;
import com.yhw.wan.coreapp.adapter.Delegate1Converter;
import com.yhw.wan.coreapp.common.Constants;
import com.yhw.wan.ui.recycler.ItemType;
import com.yhw.wan.ui.recycler.MultipleFields;
import com.yhw.wan.ui.recycler.MultipleItemEntity;
import com.yhw.wan.ui.refresh.RefreshScrollDelegate;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by BYDeXL on 2017/12/21.
 */

public class Setting3Delegate extends RefreshScrollDelegate {

    private TextView mTv;
    private int mCount = 0;

    @Override
    protected void loadData() {
        RxRestClient.builder().url(Constants.TEST)
                .build()
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        final JSONObject jsonObject = JSON.parseObject(s);
                        final int code = jsonObject.getInteger("code");
                        if (code == 1) {
                            final JSONArray dataArray = jsonObject.getJSONArray("data");
                            final int size = dataArray.size();
                            if (mCount < size) {
                                final String data = dataArray.getString(mCount);
                                final MultipleItemEntity entity = MultipleItemEntity.builder()
                                        .setItemType(ItemType.TEXT)
                                        .setField(MultipleFields.KEY, data)
                                        .build();
                                onRefreshFinish(entity);
                                mCount++;
                                return;
                            }
                        }
                        onRefreshFinish(null);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        onRefreshFinish(null);
                    }
                });
    }

    @Override
    protected void updateView(MultipleItemEntity entity) {
        mTv.setText(entity.getField(MultipleFields.KEY).toString());
    }

    @Override
    protected View initView() {
        mCount = 1;
        mTv = new TextView(getContext());
        mTv.setText("init");
        mTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        mTv.setTextColor(getResources().getColor(R.color.color_ff50b0));
        return mTv;
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

}
