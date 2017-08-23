package com.diabin.app.latte;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * @class name：com.diabin.latte
 * @anthor winelx
 * @time 2017/8/21 0021 10:57
 */
public final class latte {

    public static Configurator init(Context context) {
            getCOnfigurations().put(ConfigType.APPLICATION_CONTEXR.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String, Object> getCOnfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }
}
