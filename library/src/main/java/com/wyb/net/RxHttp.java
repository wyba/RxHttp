package com.wyb.net;

import android.util.Log;

import com.wyb.net.api.ApiService;
import com.wyb.net.request.GetRequest;
import com.wyb.net.request.PostRequest;
import com.wyb.net.util.JSONUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RxHttp {

    private ApiService apiService;

    private Retrofit retrofit;

    public static RxHttp getInstance() {
        return RxHttp.SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static RxHttp instance = new RxHttp();
    }

    private RxHttp() {

    }

    /**
     * 需要在Application中初始化
     *
     * @param baseUrl 以“/”结尾，例如"http://192.168.0.107:8080/"
     * @param timeOut 超时时间
     */
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

    public GetRequest get(String url, Map<String, String> params) {
        return new GetRequest(url, params);
    }

    public GetRequest get(String url, Object object) {
        return new GetRequest(url, JSONUtils.beanToMap(object));
    }

    public PostRequest post(String url, String content) {
        return new PostRequest(url, content);
    }
}
