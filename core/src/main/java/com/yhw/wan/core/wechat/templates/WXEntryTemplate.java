package com.yhw.wan.core.wechat.templates;


import com.yhw.wan.core.wechat.BaseWXEntryActivity;
import com.yhw.wan.core.wechat.CoreWeChat;

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        CoreWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
