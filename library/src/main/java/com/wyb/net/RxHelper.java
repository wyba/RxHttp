package com.wyb.net;

import android.util.Log;

import com.wyb.net.api.ApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RxHelper {

    private ApiService apiService;

    private Retrofit retrofit;

    public void init(String baseUrl, long timeOut) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        okHttpClientBuilder.connectTimeout(timeOut, TimeUnit.MILLISECONDS);
        okHttpClientBuilder.readTimeout(timeOut, TimeUnit.MILLISECONDS);
        okHttpClientBuilder.writeTimeout(timeOut, TimeUnit.MILLISECONDS);
        okHttpClientBuilder.addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {  //添加日志拦截器
            @Override
            public void log(String message) {
                Log.e("RxHttp", "log: " + message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY)); //设置打印数据的级别

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        retrofitBuilder.baseUrl(baseUrl);
        retrofitBuilder.client(okHttpClientBuilder.build());
        retrofitBuilder.addConverterFactory(JacksonConverterFactory.create());
        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        retrofit = retrofitBuilder.build();
        apiService = retrofit.create(ApiService.class);
    }


    public ApiService getApiService() {
        return apiService;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
