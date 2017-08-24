package com.example.a10942.commerce;

import android.app.Application;

import com.diabin.latte.app.latte;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.winelx.Icon.FontEcModule;

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
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.17")
                .configure();
    }
}
