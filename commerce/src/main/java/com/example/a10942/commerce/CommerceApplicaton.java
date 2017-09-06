package com.example.a10942.commerce;

import android.app.Application;

import com.diabin.latte.app.latte;
import com.diabin.latte.net.interceptors.DebugInterceptor;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.winelx.Icon.FontEcModule;
import com.winelx.database.DatabaseManager;

/**
 * @class name：com.example.a10942.commerce
 * @anthor winelx
 * @time 2017/8/21 0021 10:59
 */
public class CommerceApplicaton extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        latte.init(this)
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.17")
                .configure();
        DatabaseManager.getInstance().init(this);

    }
}
