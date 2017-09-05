package com.winelx.launcher;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.diabin.latte.delegates.LatteDelegate;
import com.diabin.latte.ui.scanner.LauncherHolderCreator;
import com.diabin.latte.ui.scanner.ScrollLauncherTag;
import com.diabin.latte.util.storage.LattePreference;
import com.example.latteec.ec.R;

import java.util.ArrayList;

/**
 * Created by 10942 on 2017/9/4 0004.
 */

public class LauncherScrollDelegate extends LatteDelegate implements OnItemClickListener {
    private ConvenientBanner<Integer> mIntegerConvenientBanner = null;
    private static final ArrayList<Integer> INTEGERS = new ArrayList<>();

    public void initBanner() {
        //启动页的轮播图片
        INTEGERS.add(R.mipmap.img_6);
        INTEGERS.add(R.mipmap.img_7);
        INTEGERS.add(R.mipmap.img_8);
        //设置Banner数据
        mIntegerConvenientBanner
                .setPages(new LauncherHolderCreator(), INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(false);
    }

    @Override
    public Object setLayout() {
        mIntegerConvenientBanner = new ConvenientBanner<Integer>(getContext());
        return mIntegerConvenientBanner;

    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        initBanner();
    }

    @Override
    public void onItemClick(int position) {
        if (position == INTEGERS.size() - 1) {
            LattePreference.setAppFlag(ScrollLauncherTag.HAS_FIRST_LAUNCHER_APP.name(), true);
            //检查用户是否登陆
        }
    }
}
