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
        getConfigurations().put(ConfigType.APPLICATION_CONTEXR.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<Object, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context geteApplication() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXR.name());
    }

}
