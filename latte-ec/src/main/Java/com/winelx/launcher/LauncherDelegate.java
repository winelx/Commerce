package com.winelx.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.diabin.latte.app.AccountManager;
import com.diabin.latte.app.IUserChecker;
import com.diabin.latte.delegates.LatteDelegate;
import com.diabin.latte.ui.loader.ILauncherListener;
import com.diabin.latte.ui.loader.OnLauncherFinishTag;
import com.diabin.latte.ui.scanner.ScrollLauncherTag;
import com.diabin.latte.util.Timer.BaseTImerTask;
import com.diabin.latte.util.Timer.ITimerListener;
import com.diabin.latte.util.storage.LattePreference;
import com.example.latteec.ec.R;
import com.example.latteec.ec.R2;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 10942 on 2017/9/4 0004.
 * tv_launcher_timer
 * 启动页
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener {
    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    private Timer mTimer = null;
    private int mCount = 5;
    private ILauncherListener mILauncherListener = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof ILauncherListener) {
            mILauncherListener = (ILauncherListener) activity;
        }
    }

    @OnClick(R2.id.tv_launcher_timer)
    void onClicKTimerView() {
        if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            chaecLauncher();
        }

    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTImerTask task = new BaseTImerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }


    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        initTimer();
    }

    //判断是否显示滑动启动页
    public void chaecLauncher() {
        if (!LattePreference.getAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name())) {
            start(new LauncherScrollDelegate(), SINGLETASK);
        } else {
            //检查用户是否登陆
            AccountManager.CheckAccount(new IUserChecker() {
                @Override
                public void onsignIn() {
                    //已经登陆
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                    }
                }

                @Override
                public void onNotSignIN() {
                    //没有登陆
                    if (mILauncherListener != null) {
                        mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
                    }
                }
            });
        }
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                            chaecLauncher();
                        }
                    }
                }
            }
        });
    }


}
