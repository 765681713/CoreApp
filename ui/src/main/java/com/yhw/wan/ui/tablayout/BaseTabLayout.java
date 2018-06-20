package com.yhw.wan.ui.tablayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.yhw.wan.core.delegates.CoreDelegate;
import com.yhw.wan.ui.R;
import com.yhw.wan.ui.R2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by BYDeXL on 2017/12/25.
 */

public abstract class BaseTabLayout extends CoreDelegate implements
        ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {

    @BindView(R2.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R2.id.view_pager)
    ViewPager mViewPager;
    private List<CoreDelegate> mFragments;
    private List<String> mTitleBeans;
    private MyAdapter myAdapter;

    @Override
    public Object setLayout() {
        return R.layout.delegate_tab_layout;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        mFragments = new ArrayList<>();
        mTitleBeans = new ArrayList<>();
        // 为ViewPager设置适配器
        myAdapter = new MyAdapter(getChildFragmentManager());
        mViewPager.setAdapter(myAdapter);
        mViewPager.addOnPageChangeListener(this);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(this);
        mTitleBeans.addAll(getTitles());
        initPager();
    }

    protected abstract List<String> getTitles();

    protected abstract CoreDelegate getDelegateByType(int type);

    private void initPager() {
        mFragments.clear();
        int size = mTitleBeans.size();
        for (int i = 0; i < size; i++) {
            mFragments.add(getDelegateByType(i));
        }
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class MyAdapter extends FragmentPagerAdapter {
        MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {//获取页面的个数
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleBeans.get(position);
        }
    }

}
