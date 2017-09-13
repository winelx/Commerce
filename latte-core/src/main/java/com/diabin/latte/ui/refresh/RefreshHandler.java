package com.diabin.latte.ui.refresh;


import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.diabin.latte.app.latte;
import com.diabin.latte.net.RestClient;
import com.diabin.latte.net.callBack.IError;
import com.diabin.latte.net.callBack.ISuccess;
import com.diabin.latte.ui.recytcler.Decoration;
import com.diabin.latte.ui.recytcler.MultipleRecyclerAdapter;
import com.diabin.latte.util.Intent.Connector;

/**
 * Created by 10942 on 2017/9/9 0009.
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.RequestLoadMoreListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;
    private final PagingBean Bean;
    private final RecyclerView RECYCLERVIEW;
    private MultipleRecyclerAdapter mAdapter = null;
    private final Decoration CONVERTER;

    private RefreshHandler(SwipeRefreshLayout swipeRefreshLayout,
                           RecyclerView recyclerView,
                           Decoration converter,
                           PagingBean bean) {
        this.REFRESH_LAYOUT = swipeRefreshLayout;
        this.RECYCLERVIEW = recyclerView;
        this.CONVERTER = converter;
        this.Bean = bean;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    public static RefreshHandler create(SwipeRefreshLayout swipeRefreshLayout,
                                        RecyclerView recyclerView,
                                        Decoration converter
    ) {
        return new RefreshHandler(swipeRefreshLayout, recyclerView, converter, new PagingBean());
    }

    public void firstpage(String url, final Context context) {
        RestClient.Builder()
                .url(url)
                .loaderl(context)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String msg) {
                        final JSONObject object =
                                JSON.parseObject(msg);
                        Log.d("ssss", msg);
                        Bean.setTotal(object.getInteger("total"))
                                .setPageSize(object.getInteger("page_size"));
                        //设置adapter
                        mAdapter = MultipleRecyclerAdapter.create(CONVERTER.setJsonData(msg));
                        mAdapter.setOnLoadMoreListener(RefreshHandler.this, RECYCLERVIEW);
                        RECYCLERVIEW.setAdapter(mAdapter);
                        Bean.addIndex();

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
                RestClient.Builder()
                        .url(Connector.HomePage)
                        .success(new ISuccess() {
                            @Override
                            public void onSuccess(String msg) {
                                final JSONObject object =
                                        JSON.parseObject(msg);
                                Log.d("ssss", msg);
                                Bean.setTotal(object.getInteger("total"))
                                        .setPageSize(object.getInteger("page_size"));
                                //设置adapter
                                mAdapter = MultipleRecyclerAdapter.create(CONVERTER.setJsonData(msg));
                                mAdapter.setOnLoadMoreListener(RefreshHandler.this, RECYCLERVIEW);
                                RECYCLERVIEW.setAdapter(mAdapter);
                                Bean.addIndex();
                            }
                        })
                        .error(new IError() {
                            @Override
                            public void OnError(int code, String msg) {

                            }
                        })
                        .build()
                        .post();
                REFRESH_LAYOUT.setRefreshing(false);
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        refresh();
    }

    @Override
    public void onLoadMoreRequested() {

    }

}
