package com.example.a10942.commerce;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.diabin.latte.delegates.LatteDelegate;

/**
 * Created by 10942 on 2017/8/26 0026.
 */

public class ExampleDalegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.example_fragment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }
}
