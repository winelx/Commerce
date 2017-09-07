package com.diabin.latte.wechat.templates;


import com.diabin.latte.wechat.BaseWXEntryActivity;

/**
 * Created by User on 2017/8/20.
 */

public class WXEntryTemplate extends BaseWXEntryActivity {
    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
    }
}
