package com.diabin.latte.ui;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.diabin.latte.util.dimen.DimenUtil;
import com.example.latte.R;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Created by 10942 on 2017/8/31 0031.
 */


public class LattetLoader {
    private static final int LOADER_SIZE_SCALE = 10;
    private static final int LOADER_OFFSET_SCALE = 10;

    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<>();
    private static final String DEFEAULT_lOADER = com.diabin.latte.ui.LoaderStyle.BallGridPulseIndicator.name();

    public static void showLoading(Context context, Enum<com.diabin.latte.ui.LoaderStyle> type) {
        showLoading(context, type.name());
    }

    public static void showLoading(Context context, String args) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
        final AVLoadingIndicatorView avLoadingIndicatorView = com.diabin.latte.ui.LoaderCreator.crreate(args, context);
        dialog.setContentView(avLoadingIndicatorView);
        //获取屏幕的宽高
        int deviceWidth = DimenUtil.getScreenWidth();
        int deviceHegth = DimenUtil.getScreenHeight();
        final Window dialogWindow = dialog.getWindow();
        if (dialogWindow != null) {
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth / LOADER_SIZE_SCALE;
            lp.height = deviceHegth / LOADER_SIZE_SCALE;
            //小米手机会等待图标置顶
            //  lp.height = lp.height * deviceHegth / LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    public static void showding(Context context) {
        showLoading(context, DEFEAULT_lOADER);
    }

    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                }
            }
        }
    }
}
