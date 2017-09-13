package com.diabin.latte.delegates;

/**
 * Created by 10942 on 2017/8/26 0026.
 */

public abstract class LatteDelegate extends PermissionCheckerDelegate {
    public <T extends LatteDelegate>
    T getParentDegate() {
        return (T) getParentFragment();
    }
}
