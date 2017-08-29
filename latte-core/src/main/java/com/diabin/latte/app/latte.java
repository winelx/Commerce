package com.diabin.latte.app;

import android.content.Context;

import java.util.HashMap;

/**
 * @class name：com.diabin.latte
 * @anthor winelx
 * @time 2017/8/21 0021 10:57
 */
public final class latte {

    public static Configurator init(Context context) {
        getCOnfigurations().put(ConfigType.APPLICATION_CONTEXR.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String, Object> getCOnfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context geteApplication() {
        return (Context) getCOnfigurations().get(ConfigType.APPLICATION_CONTEXR.name());
    }
}
