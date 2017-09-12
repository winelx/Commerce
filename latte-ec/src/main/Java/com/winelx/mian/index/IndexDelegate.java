package com.winelx.mian.index;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.diabin.latte.delegates.bottom.BottomItemDalegate;
import com.diabin.latte.ui.refresh.RefreshHandler;
import com.example.latteec.ec.R;
import com.example.latteec.ec.R2;
import com.joanzapata.iconify.widget.IconTextView;

import butterknife.BindView;

/**
 * Created by 10942 on 2017/9/8 0008.
 */

public class IndexDelegate extends BottomItemDalegate {
    @BindView(R2.id.index_sw)
    SwipeRefreshLayout mRefreshLayout = null;
    @BindView(R2.id.index_rec)
    RecyclerView mRecyclerView = null;
    @BindView(R2.id.index_toolbar)
    Toolbar mToolbar = null;
    @BindView(R2.id.et_search_view)
    AppCompatEditText search_view = null;
    @BindView(R2.id.icon_index_message)
    IconTextView message = null;

    private RefreshHandler mRefreshHandler = null;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        mRefreshHandler = RefreshHandler.create(mRefreshLayout, mRecyclerView, new IndexDataConverter());

    }

    private void initRefreshLayout() {
        mRefreshLayout.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_red_dark
        );
        mRefreshLayout.setProgressViewOffset(true, 80, 150);
    }

    @Override
    public Object setLayout() {
        return R.layout.index_bottom_fragment;

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        initRecyclerVIew();
        mRefreshHandler.firstpage("http://116.196.95.67/RestServer/api/");

    }

    private  void  initRecyclerVIew(){
        final GridLayoutManager manager=new GridLayoutManager(getContext(),4);
        mRecyclerView.setLayoutManager(manager);
    }
}
