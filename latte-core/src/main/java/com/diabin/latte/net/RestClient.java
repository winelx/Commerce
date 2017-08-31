package com.diabin.latte.net;

import android.content.Context;

import com.diabin.latte.net.callBack.IError;
import com.diabin.latte.net.callBack.IFailure;
import com.diabin.latte.net.callBack.IRequest;
import com.diabin.latte.net.callBack.ISuccess;
import com.diabin.latte.net.callBack.RequestCallbacks;
import com.diabin.latte.ui.LattetLoader;
import com.diabin.latte.ui.LoaderStyle;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by 10942 on 2017/8/28 0028.
 */

public class RestClient {
    private final String URL;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure IFAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    private final LoaderStyle LOADER_STYLE;
    public final Context mContext;

    public RestClient(String url, Map<String, Object> parmas, IRequest request,
                      ISuccess success, IFailure failure, IError error, RequestBody body, LoaderStyle loaderStyle, Context context) {
        this.URL = url;
        PARAMS.putAll(parmas);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.IFAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
        this.LOADER_STYLE = loaderStyle;
        this.mContext = context;
    }

    public static RestClientBuilder Builder() {
        return new RestClientBuilder();
    }

    public void request(HttpMethod method) {
        final RestService service = RestCreator.getRestServiice();
        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }
        if (LOADER_STYLE != null) {
            LattetLoader.showLoading(mContext, LOADER_STYLE);
        }
        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case DELETE:
                call = service.detale(URL, PARAMS);
                break;
            default:
                break;
        }
        if (call != null) {
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback() {
        return new
                RequestCallbacks(
                REQUEST,
                SUCCESS, IFAILURE, ERROR, LOADER_STYLE
        );
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }
}
