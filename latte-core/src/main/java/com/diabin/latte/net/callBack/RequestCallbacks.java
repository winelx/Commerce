package com.diabin.latte.net.callBack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 10942 on 2017/8/30 0030.
 */

public class RequestCallbacks implements Callback<String> {
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure IFAILURE;
    private final IError ERROR;

    public RequestCallbacks(IRequest REQUEST, ISuccess SUCCESS, IFailure IFAILURE, IError ERROR) {
        this.REQUEST = REQUEST;
        this.SUCCESS = SUCCESS;
        this.IFAILURE = IFAILURE;
        this.ERROR = ERROR;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> responsed) {
        if (responsed.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(responsed.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.OnError(responsed.code(), responsed.message());
            }
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (IFAILURE != null) {
            IFAILURE.onIFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }
    }
}
