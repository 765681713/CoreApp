package com.yhw.wan.core.delegates.bottom;

import android.widget.Toast;

import com.yhw.wan.core.R;
import com.yhw.wan.core.app.Core;
import com.yhw.wan.core.delegates.CoreDelegate;


/**
 * Created by 傅令杰
 */

public abstract class BottomItemDelegate extends CoreDelegate {
    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, "双击退出" + Core.getApplicationContext().getString(R.string.app_name), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
