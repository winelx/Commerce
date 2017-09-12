package com.diabin.latte.ui.Banner;

import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.diabin.latte.ui.recytcler.MultipleRecyclerAdapter;
import com.example.latte.R;

import java.util.ArrayList;

/**
 * Created by 10942 on 2017/9/12 0012.
 */

public class bannerCreator {
    public static void seDefault(
            ConvenientBanner<String> convenientBanner,
            ArrayList<String> banenrs,
            MultipleRecyclerAdapter clickListener) {
        convenientBanner
                .setPages(new HolderCreator(), banenrs)
                .setPageIndicator(new int[]{R.mipmap.img_6, R.mipmap.img_7})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(clickListener)
                .setPageTransformer(new DefaultTransformer())
                .startTurning(3000)
                .setCanLoop(true);
    }
}
