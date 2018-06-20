package com.yhw.wan.core.delegates.swipeback;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.yhw.wan.core.R;
import com.yhw.wan.core.R2;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;


/**
 * Created by 刘世波 on 16/2/7.
 */
public abstract class BaseBackFragment extends SwipeBackFragment {
    private View baseView;
    @SuppressWarnings("SpellCheckingInspection")
    private Unbinder mUnbinder = null;
    private ImageView backView;
    private TextView titleView;
    private TextView rightView;

    @OnClick(R2.id.base_right_btn)
    void onRightBtnClick() {
        onRightClick();
    }

    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        baseView = inflater.inflate(R.layout.delegate_base_layout, container, false);
        final View rootView;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((int) setLayout(), null);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        } else {
            throw new ClassCastException("type of setLayout() must be int or View!");
        }
        ((FrameLayout) baseView.findViewById(R.id.base_layout)).addView(rootView);
        mUnbinder = ButterKnife.bind(this, baseView);
        backView = baseView.findViewById(R.id.base_img_back);
        titleView = baseView.findViewById(R.id.base_title);
        rightView = baseView.findViewById(R.id.base_right_btn);
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportDelegate().pop();
            }
        });
        hideTitleBar();
        onBindView(savedInstanceState, baseView);
        return attachToSwipeBack(baseView);
    }

    public void setTitle(String title) {
        titleView.setText(title);
    }

    public void setTitle(int titleRes) {
        titleView.setText(titleRes);
    }

    public void setRightTitle(String rightTitle) {
        rightView.setText(rightTitle);
    }

    public void showRightBtn() {
        rightView.setVisibility(View.VISIBLE);
    }

    public void hideLeftBtn() {
        backView.setVisibility(View.GONE);
    }

    public void showLeftBtn() {
        backView.setVisibility(View.VISIBLE);
    }

    public void hideTitleBar() {
        if (baseView != null) {
            baseView.findViewById(R.id.base_title_layout).setVisibility(View.GONE);
        }
    }

    public void showTitleBar() {
        if (baseView != null) {
            baseView.findViewById(R.id.base_title_layout).setVisibility(View.VISIBLE);
        }
    }

    public void onRightClick() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setParallaxOffset(0.5f);
    }

}
