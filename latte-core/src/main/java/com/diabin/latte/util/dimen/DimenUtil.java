package com.diabin.latte.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.diabin.latte.app.latte;

/**
 * Created by 10942 on 2017/8/31 0031.
 */

public final class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = latte.geteApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = latte.geteApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
