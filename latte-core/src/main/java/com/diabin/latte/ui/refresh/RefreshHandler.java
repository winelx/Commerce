package com.diabin.latte.ui.refresh;


import android.support.v4.widget.SwipeRefreshLayout;

import com.diabin.latte.app.latte;
import com.diabin.latte.net.RestClient;
import com.diabin.latte.net.callBack.IError;
import com.diabin.latte.net.callBack.ISuccess;

/**
 * Created by 10942 on 2017/9/9 0009.
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;

    public RefreshHandler(SwipeRefreshLayout swipeRefreshLayout) {
        this.REFRESH_LAYOUT = swipeRefreshLayout;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    public static RefreshHandler create(SwipeRefreshLayout swipeRefreshLayout) {
        return new RefreshHandler(swipeRefreshLayout);
    }

    public void firstpage(String url) {
        RestClient.Builder()
                .url(url)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String msg) {

                    }
                })
                .error(new IError() {
                    @Override
                    public void OnError(int code, String msg) {

                    }
                })
                .build()
                .post();
    }

    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);
        latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                REFRESH_LAYOUT.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
