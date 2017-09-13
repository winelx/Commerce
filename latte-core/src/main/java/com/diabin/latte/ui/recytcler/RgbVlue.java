package com.diabin.latte.ui.recytcler;

import com.google.auto.value.AutoValue;

/**
 * Created by 10942 on 2017/9/13 0013.
 */
@AutoValue
public abstract class RgbVlue {
    public abstract int red();

    public abstract int green();

    public abstract int blue();

    public static RgbVlue create(int red, int green, int blue) {
        return new AutoValue_RgbVlue(red, green, blue);
    }
}
