package com.diabin.latte.net;

import com.diabin.latte.app.ConfigType;
import com.diabin.latte.app.latte;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by 10942 on 2017/8/29 0029.
 * 建造者模式
 */

public class RestCreator {
    private static final class ParamsHolder {
        public static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }

    public static RestService getRestService() {
        return RestServiceHolder.REST_SREVICE;
    }

    private static final class RetrofitHolder {
        private static final String BASZEZ_URl = (String) latte.getCOnfigurations()
                .get(ConfigType.API_HOST.name());
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASZEZ_URl)
                .client(OKHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
    }

    private static final class OKHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();

    }

    private static final class RestServiceHolder {
        private static final RestService REST_SREVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }


}
