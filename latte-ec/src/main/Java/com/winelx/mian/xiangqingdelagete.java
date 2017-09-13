package com.winelx.mian;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.diabin.latte.delegates.LatteDelegate;
import com.example.latteec.ec.R;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by 10942 on 2017/9/13 0013.
 */

public class xiangqingdelagete extends LatteDelegate {

    public static xiangqingdelagete create() {
        return new xiangqingdelagete();
    }

    @Override
    public Object setLayout() {
        return R.layout.xiangqin_botton;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }
}
