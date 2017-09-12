package com.diabin.latte.ui.recytcler;

import java.util.ArrayList;

/**
 * Created by 10942 on 2017/9/11 0011.
 */

public abstract class Decoration {
    protected final ArrayList<MultipleItemEntity> ENTITIES =
            new ArrayList<>();
    private String mJsonData = null;

    public abstract ArrayList<MultipleItemEntity> convert();

    public Decoration setJsonData(String json) {
        this.mJsonData = json;
        return this;
    }

    protected String getJsonData() {
        if (mJsonData == null || mJsonData.isEmpty()) {
            throw new NullPointerException("data is null");
        }
        return mJsonData;
    }
}
