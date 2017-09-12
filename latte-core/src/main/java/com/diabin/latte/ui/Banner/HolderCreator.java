package com.diabin.latte.ui.Banner;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created by 10942 on 2017/9/12 0012.
 */

public class HolderCreator  implements CBViewHolderCreator<ImageHolder>{
    @Override
    public ImageHolder createHolder() {
        return new ImageHolder();
    }
}
