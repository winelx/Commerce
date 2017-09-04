package com.example.a10942.commerce;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.diabin.latte.delegates.LatteDelegate;
import com.diabin.latte.net.RestClient;
import com.diabin.latte.net.callBack.IError;
import com.diabin.latte.net.callBack.IFailure;
import com.diabin.latte.net.callBack.ISuccess;

/**
 * Created by 10942 on 2017/8/26 0026.
 */

public class ExampleDalegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.example_fragment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        text();
    }

    private void text() {

        RestClient.Builder()
                .url("http://127.0.0.1/index")
                .loaderl(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String msg) {
                       Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                    }
                })
                .error(new IError() {
                    @Override
                    public void OnError(int code, String msg) {

                    }
                })

                .failure(new IFailure() {
                    @Override
                    public void onIFailure() {

                    }
                })

                .build()
                .get();
    }
}
