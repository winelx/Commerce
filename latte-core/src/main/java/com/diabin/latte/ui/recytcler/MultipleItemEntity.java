package com.diabin.latte.ui.recytcler;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/**
 * Created by 10942 on 2017/9/11 0011.
 */

public class MultipleItemEntity implements MultiItemEntity {

    private final ReferenceQueue<LinkedHashMap<Object, Object>> ITEM_QUEUE
            = new ReferenceQueue<>();
    private final LinkedHashMap<Object, Object> MOLTIPLE_FIELDS =
            new LinkedHashMap<>();
    private final SoftReference<LinkedHashMap<Object, Object>> FIELDS_REFERENCE =
            new SoftReference<LinkedHashMap<Object, Object>>(MOLTIPLE_FIELDS, ITEM_QUEUE);

    MultipleItemEntity(LinkedHashMap<Object, Object> fields) {
        FIELDS_REFERENCE.get().putAll(fields);
    }

    public static MultipleItemEntityBuilder builder() {
        return new MultipleItemEntityBuilder();
    }

    @Override
    public int getItemType() {
        return (int) FIELDS_REFERENCE.get().get(MultipleFields.ITEM_TYPE);
    }

    public final <T> T getFiled(Object key) {
        return (T) FIELDS_REFERENCE.get().get(key);
    }


    public final LinkedHashMap<?,?> getFields(){
        return FIELDS_REFERENCE.get();
    }

    public final MultiItemEntity setField(Object key, Object Value) {
        FIELDS_REFERENCE.get().put(key, Value);
        return this;
    }


}
