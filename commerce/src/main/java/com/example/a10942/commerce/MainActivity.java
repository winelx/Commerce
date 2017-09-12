package com.example.a10942.commerce;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import com.diabin.latte.activities.ProxyActivity;
import com.diabin.latte.app.latte;
import com.diabin.latte.delegates.LatteDelegate;
import com.diabin.latte.ui.loader.ILauncherListener;
import com.diabin.latte.ui.loader.OnLauncherFinishTag;
import com.winelx.launcher.LauncherScrollDelegate;
import com.winelx.mian.index.IndexDelegate;
import com.winelx.singn.ISignLiastener;
import com.winelx.singn.SingUpDelegate;


public class MainActivity extends ProxyActivity implements ILauncherListener,
        ISignLiastener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    //这里设置第一个界面
    @Override
    public LatteDelegate setRootDelegare() {
        return new LauncherScrollDelegate();
    }

    @Override
    public void onSignInSuccess() {
        Toast.makeText(latte.geteApplication(), "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignUpSuccess() {
        Toast.makeText(latte.geteApplication(), "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag Tag) {
        switch (Tag) {
            case SIGNED:
                //已经登陆的操作
                Toast.makeText(latte.geteApplication(), "检测到用户已登陆", Toast.LENGTH_LONG).show();
                getSupportDelegate().startWithPop(new IndexDelegate());
                break;
            case NOT_SIGNED:
                //未登录的操作
                Toast.makeText(latte.geteApplication(), "检测到用户未登陆", Toast.LENGTH_LONG).show();
//                startWithPop(new SingUpDelegate());
                getSupportDelegate().startWithPop(new SingUpDelegate());
                break;
            default:
                break;
        }
    }
}
