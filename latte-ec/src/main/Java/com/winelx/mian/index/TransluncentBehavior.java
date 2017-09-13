package com.winelx.mian.index;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.diabin.latte.ui.recytcler.RgbVlue;
import com.example.latteec.ec.R;

/**
 * Created by 10942 on 2017/9/13 0013.
 */
@SuppressWarnings("unused")
public class TransluncentBehavior extends CoordinatorLayout.Behavior<Toolbar> {
    //顶部距离
    private int mDistanceY = 0;
    //颜色变化速度
    private static final int SHOW_SPEED = 3;
    //定义变化的颜色
    private final RgbVlue RGB_VALUE = RgbVlue.create(135, 206, 250);

    public TransluncentBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Toolbar child, View dependency) {
        return dependency.getId() == R.id.index_toolbar;
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, Toolbar child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        //增加滑动距离
        mDistanceY += dy;
        //toolbar的高度
        final int targetHeight = child.getBottom();

        //当滑动时，并且距离小于 toolbar 高度的时候，调整渐变色
        if (mDistanceY > 0 && mDistanceY <= targetHeight) {
            final float scale = (float) mDistanceY / targetHeight;
            final float alpha = scale * 100;
            child.setBackgroundColor(Color.argb((int) alpha, RGB_VALUE.red(), RGB_VALUE.green(), RGB_VALUE.blue()));
        } else if (mDistanceY > targetHeight) {
            child.setBackgroundColor(Color.rgb(RGB_VALUE.red(), RGB_VALUE.green(), RGB_VALUE.blue()));
        }
    }
}
