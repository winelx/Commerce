package com.example.a10942.commerce;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.diabin.latte.activities.ProxyActivity;
import com.diabin.latte.app.latte;
import com.diabin.latte.delegates.LatteDelegate;
import com.winelx.singn.ISignLiastener;
import com.winelx.singn.SigninDetegate;


public class MainActivity extends ProxyActivity implements ISignLiastener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegare() {
        return new SigninDetegate();
    }

    @Override
    public void onSignInSuccess() {

    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(latte.geteApplication(), "注册成功", Toast.LENGTH_SHORT).show();
    }
}
