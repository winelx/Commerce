package com.diabin.latte.ui.recytcler;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

/**
 * Created by 10942 on 2017/9/11 0011.
 */

public class MultipleViewHolder extends BaseViewHolder {
    public MultipleViewHolder(View view) {
        super(view);
    }

    public static MultipleViewHolder create(View view) {
        return  new MultipleViewHolder(view);
    }
}
