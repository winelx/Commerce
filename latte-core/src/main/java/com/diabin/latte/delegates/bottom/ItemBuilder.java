package com.diabin.latte.delegates.bottom;

import java.util.LinkedHashMap;

/**
 * Created by 10942 on 2017/9/8 0008.
 */

public final class ItemBuilder {

    private final LinkedHashMap<BottomTabBean, BottomItemDalegate> ITEMS = new LinkedHashMap<>();

    static ItemBuilder Builder() {
        return new ItemBuilder();
    }

    public final ItemBuilder addItem(BottomTabBean bean, BottomItemDalegate delegate) {
        ITEMS.put(bean, delegate);
        return this;
    }

    public final ItemBuilder addItems(LinkedHashMap<BottomTabBean, BottomItemDalegate> items) {
        ITEMS.putAll(items);
        return this;
    }

    public final LinkedHashMap<BottomTabBean, BottomItemDalegate> build() {
        return ITEMS;
    }
}

