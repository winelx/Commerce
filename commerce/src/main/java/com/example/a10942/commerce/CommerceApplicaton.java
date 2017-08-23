package com.example.a10942.commerce;

import android.app.Application;

import com.diabin.app.latte.latte;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

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
                .withApiHost("")
                .configure();
    }
}
