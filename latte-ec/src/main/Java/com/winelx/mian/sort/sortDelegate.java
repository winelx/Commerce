package com.winelx.mian.sort;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.diabin.latte.delegates.bottom.BottomItemDalegate;
import com.example.latteec.ec.R;

/**
 * Created by 10942 on 2017/9/8 0008.
 * 分类
 */

public class sortDelegate extends BottomItemDalegate {
    @Override
    public Object setLayout() {
        return R.layout.sort_bottom_fragment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

}
