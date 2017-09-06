package com.diabin.latte.app;

import com.diabin.latte.util.storage.LattePreference;

/**
 * Created by 10942 on 2017/9/5 0005.
 * 管理用户数据
 */

public class AccountManager {
    private enum SignTag {
        SING_TAG
    }

    //保存用户登陆状态，登陆后调用
    public static void setSignState(boolean state) {
        LattePreference.setAppFlag(SignTag.SING_TAG.name(), state);
    }

    //判断是已经登陆
    private static boolean isSigIn() {
        return LattePreference.getAppFlag(SignTag.SING_TAG.name());
    }

    public static void CheckAccount(IUserChecker checker) {
        if (isSigIn()) {
            checker.onsignIn();//已经登陆
        } else {
            checker.onNotSignIN();//没有登陆
        }
    }
}
