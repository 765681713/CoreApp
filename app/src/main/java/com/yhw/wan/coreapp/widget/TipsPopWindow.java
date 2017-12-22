package com.yhw.wan.coreapp.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.yhw.wan.coreapp.R;


/**
 * Created by jieku015 on 2016/5/24.
 */
public class TipsPopWindow extends PopupWindow implements View.OnClickListener {

    private Context mContext;
    private LayoutInflater inflater;
    private TextView mOkText;
    private TextView mContentText;
    private TextView mTitleText;
    private TextView mCancelText;
    private PopDialogListener mListener;

    public TipsPopWindow(Context mContext) {
        this.mContext = mContext;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mView = inflater.inflate(R.layout.tips_pop_layout, null);
        mOkText = (TextView) mView.findViewById(R.id.text_ok);
        mOkText.setOnClickListener(this);
        mCancelText = (TextView) mView.findViewById(R.id.text_cancel);
        mCancelText.setOnClickListener(this);
        mCancelText.setVisibility(View.GONE);
        mTitleText = mView.findViewById(R.id.text_title);
        mContentText = mView.findViewById(R.id.text_content);
        //设置SelectPicPopupWindow的View
        this.setContentView(mView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setClippingEnabled(false);
        this.setAnimationStyle(R.style.AlphaAnimationPreview);
        //设置SelectPicPopupWindow弹出窗体动画效果
//        this.setAnimationStyle(R.style.myPopAnimStyle);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x33000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
    }

    public void setRightBtn(String tips) {
        mOkText.setText(tips);
    }

    public void setLeftBtn(String tips) {
        mCancelText.setText(tips);
        mCancelText.setVisibility(View.VISIBLE);
    }

    public void setLeftBtnColor(int colorId){
        mCancelText.setTextColor(mContext.getResources().getColor(colorId));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_cancel: {
                dismiss();
                break;
            }
            case R.id.text_ok: {
                if (mListener != null) {
                    mListener.onDismiss();
                }
                dismiss();
                break;
            }
        }
    }

    public void setTitle(String hint) {
        mTitleText.setText(hint);
    }

    public void setContent(String hint) {
        mContentText.setText(hint);
    }


    @Override
    public void dismiss() {
        super.dismiss();
    }


    public void setLisener(PopDialogListener listener) {
        this.mListener = listener;
    }

    public interface PopDialogListener {
        public void onDismiss();
    }
}
