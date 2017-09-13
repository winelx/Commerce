package com.diabin.latte.ui.recytcler;

import com.choices.divider.Divider;
import com.choices.divider.DividerItemDecoration;

/**
 * Created by 10942 on 2017/9/13 0013.
 */

public class DivierLooKupImp implements DividerItemDecoration.DividerLookup {

    private final int CoLOR;
    private final int SIZE;

    public DivierLooKupImp(int coLOR, int SIZE) {
        this.CoLOR = coLOR;
        this.SIZE = SIZE;
    }

    @Override
    public Divider getVerticalDivider(int position) {
        return new Divider.Builder()
                .size(SIZE)
                .color(CoLOR)
                .build();
    }

    @Override
    public Divider getHorizontalDivider(int position) {
        return null;
    }
}
