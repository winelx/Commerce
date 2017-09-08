package com.winelx.mian;

import android.graphics.Color;

import com.diabin.latte.delegates.bottom.BaseBottomDelegate;
import com.diabin.latte.delegates.bottom.BottomItemDalegate;
import com.diabin.latte.delegates.bottom.BottomTabBean;
import com.diabin.latte.delegates.bottom.ItemBuilder;
import com.winelx.mian.compass.compassDelegate;
import com.winelx.mian.index.IndexDelegate;
import com.winelx.mian.shopping.shoppingDetegale;
import com.winelx.mian.sort.sortDelegate;
import com.winelx.mian.user.userDelegate;

import java.util.LinkedHashMap;

/**
 * Created by 10942 on 2017/9/8 0008.
 */

public class EcBottomDelegate extends BaseBottomDelegate {

    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDalegate> setItem(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDalegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new sortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new compassDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new shoppingDetegale());
        items.put(new BottomTabBean("{fa-user}", "我的"), new userDelegate());
        return builder.addItems(items).build();
    }


    @Override
    public int setIndexDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        return Color.parseColor("#ffff8800");
    }
}
