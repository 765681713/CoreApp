package com.yhw.wan.core.delegates;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;

import com.blankj.utilcode.util.ToastUtils;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by 刘世波 on 2017/4/2
 */

public abstract class CoreDelegate extends BaseDelegate {
    private Dialog mDialog;
    private ProgressDialog dialog;

    @SuppressWarnings("unchecked")
    public <T extends CoreDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

    /**
     * 创建进度条对话框
     */
    protected Dialog onCreateProgressDialog(Context context, String content) {
        if (dialog == null) {
            dialog = new ProgressDialog(context, ProgressDialog.THEME_HOLO_LIGHT);
        }
        dialog.setMessage("".equals(content) ? "正在努力加载......" : content);
        return dialog;
    }

    protected void showProgressDialog(String content) {
        mDialog = onCreateProgressDialog(getActivity(), content);
        if (mDialog == null) {
            return;
        }
        mDialog.show();
    }

    /**
     * 显示进度条对话框
     */
    protected void showProgressDialog() {
        mDialog = onCreateProgressDialog(getActivity(), "");
        if (mDialog == null) {
            return;
        }
        mDialog.show();
    }

    /**
     * 隐藏进度条对话框
     */
    protected void hideProgressDialog() {
        if (isProgressing()) {
            mDialog.dismiss();
        }
    }

    /**
     * 进度条是否在显示
     */
    protected boolean isProgressing() {
        return (mDialog != null && mDialog.isShowing());
    }

    //土司
    protected void showMyToast(String msg) {
        ToastUtils.showShort(msg);
    }
}
