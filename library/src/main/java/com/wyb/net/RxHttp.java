package com.wyb.net;

import com.wyb.net.api.ApiService;
import com.wyb.net.callback.CallBack;
import com.wyb.net.request.GetRequest;
import com.wyb.net.request.PostRequest;
import com.wyb.net.util.JSONUtils;

import java.io.File;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;

public class RxHttp {

    private static RxHelper rxHelper = new RxHelper();

    private static GetRequest getRequest = new GetRequest();

    private static PostRequest postRequest = new PostRequest();

    public static void init(String baseUrl, long timeOut) {
        rxHelper.init(baseUrl, timeOut);
    }

    public static ApiService getApiService() {
        return rxHelper.getApiService();
    }

    public static Retrofit getRetrofit() {
        return rxHelper.getRetrofit();
    }

    public static <T> void get(String url, Map<String, String> params, CallBack<T> callBack) {
        getRequest.execute(url, params, callBack);
    }

    public static <T> void get(String url, Object object, CallBack<T> callBack) {
        getRequest.execute(url, JSONUtils.beanToMap(object), callBack);
    }

    public static <T> void post(String url, String content, CallBack<T> callBack) {
        postRequest.execute(url, content, callBack);
    }

    public static <T> void uploadSingleFile(String url, String contentKey, String content, String fileKey, String filePath, final CallBack<T> callBack) {
        postRequest.uploadSingleFile(url, contentKey, content, fileKey, filePath, callBack);
    }
}
