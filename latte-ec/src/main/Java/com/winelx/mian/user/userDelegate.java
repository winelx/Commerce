package com.winelx.mian.user;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.diabin.latte.delegates.bottom.BottomItemDalegate;
import com.example.latteec.ec.R;

/**
 * Created by 10942 on 2017/9/8 0008.
 * 我的
 */

public class userDelegate extends BottomItemDalegate {
    @Override
    public Object setLayout() {
        return R.layout.user_bottom_fragment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

}
