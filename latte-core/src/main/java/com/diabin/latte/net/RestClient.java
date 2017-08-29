package com.diabin.latte.net;

import com.diabin.latte.net.callBack.IError;
import com.diabin.latte.net.callBack.IFailure;
import com.diabin.latte.net.callBack.IRequest;
import com.diabin.latte.net.callBack.ISuccess;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * Created by 10942 on 2017/8/28 0028.
 */

public class RestClient {
    private final String URL;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure IDAILURE;
    private final IError ERROR;
    private final RequestBody BODY;

    public RestClient(String url, Map<String, Object> parmas, IRequest request, ISuccess success,
                      IFailure failure, IError error, RequestBody body) {
        this.URL = url;
        PARAMS.putAll(parmas);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.IDAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
    }

    public static RestClientBuilder Builder() {
        return new RestClientBuilder();
    }
}
