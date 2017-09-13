package com.diabin.latte.ui.recytcler;

import android.support.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * Created by 10942 on 2017/9/13 0013.
 */

public class baseDecoration extends DividerItemDecoration {

    private baseDecoration(@ColorInt int color, int size) {
        setDividerLookup(new DivierLooKupImp(color, size));
    }

    public static baseDecoration create(@ColorInt int color, int size) {
        return new baseDecoration(color, size);
    }
}
