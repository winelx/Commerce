package com.example.a10942.commerce;

import com.diabin.latte.activities.ProxyActivity;
import com.diabin.latte.delegates.LatteDelegate;
import com.winelx.launcher.LauncherScrollDelegate;

public class MainActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegare() {
        return new LauncherScrollDelegate();
    }
}
