package com.diabin.app.latte;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @class name：com.diabin.app.latte
 * @anthor winelx
 * @time 2017/8/21 0021 11:01
 * 配置文件的存储和获取
 */
public class Configurator {
    /**
     * 存储配置
     */
    private static final HashMap<String, Object> LATTE_CONFIGS = new HashMap<>();
    //字体存储
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<IconFontDescriptor>();

    //创建枚举，初始化枚举类
    private Configurator() {
        initICOn();
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    final HashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    /**
     * 线程安全单例实现
     */
    static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    //实现configurator，用静态的方法。
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    @SuppressWarnings("unchecked")
    final <T> Object getCOnfiguration(Enum<ConfigType> key) {
        checkCOnfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }

    private void checkCOnfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("error");
        }
    }

    private  void  initICOn(){
        if (ICONS.size()>0){
            final Iconify.IconifyInitializer initializer=Iconify.with(ICONS.get(0));
        for (int i=1;i<=ICONS.size();i++){
        initializer.with(ICONS.get(i));
        }
        }
    }
    public  final  Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
        return this;
    }
}
