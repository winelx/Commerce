package com.diabin.latte.ui.recytcler;

import java.util.LinkedHashMap;

/**
 * Created by 10942 on 2017/9/11 0011.
 */

public class MultipleItemEntityBuilder {
    private static final LinkedHashMap<Object, Object> FIELDS = new LinkedHashMap<>();


    public MultipleItemEntityBuilder() {
        //清除所有的值
        FIELDS.clear();
    }

    public final MultipleItemEntityBuilder getItemType(int itemType) {
        FIELDS.put(MultipleFields.ITEM_TYPE, itemType);
        return this;
    }

    public final MultipleItemEntityBuilder setField(Object key, Object value) {
        FIELDS.put(key, value);
        return this;
    }

    public final MultipleItemEntityBuilder setFields(LinkedHashMap<?, ?> map) {
        FIELDS.putAll(map);
        return this;
    }

    public final MultipleItemEntity build() {
        return new MultipleItemEntity(FIELDS);

    }
}
