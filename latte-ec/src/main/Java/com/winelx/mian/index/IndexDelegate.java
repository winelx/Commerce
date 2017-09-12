package com.winelx.mian.index;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.diabin.latte.delegates.bottom.BottomItemDalegate;
import com.diabin.latte.net.RestClient;
import com.diabin.latte.net.callBack.ISuccess;
import com.diabin.latte.ui.recytcler.MultipleFields;
import com.diabin.latte.ui.recytcler.MultipleItemEntity;
import com.diabin.latte.ui.refresh.RefreshHandler;
import com.example.latteec.ec.R;
import com.example.latteec.ec.R2;
import com.joanzapata.iconify.widget.IconTextView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by 10942 on 2017/9/8 0008.
 */

public class IndexDelegate extends BottomItemDalegate {
    @BindView(R2.id.index_sw)
    SwipeRefreshLayout mswip = null;
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
        mRefreshHandler = new RefreshHandler(mswip);
        RestClient.Builder()
                .url("http://116.196.95.67/RestServer/api/")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String msg) {
                        final IndexDataConverter converter = new IndexDataConverter();
                        converter.setJsonData(msg);
                        final ArrayList<MultipleItemEntity> list = converter.convert();
                        final String image = list.get(1).getFiled(MultipleFields.IMAGE_URL);
                        Toast.makeText(getActivity(), image, Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .get();
    }
    private void initRefreshLayout() {
        mswip.setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_red_dark
        );
        mswip.setProgressViewOffset(true, 80, 150);
    }

    @Override
    public Object setLayout() {
        return R.layout.index_bottom_fragment;

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initRefreshLayout();
        mRefreshHandler.firstpage("http://116.196.95.67/RestServer/api/");

    }
}
