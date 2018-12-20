package com.wyb.net.api;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {

    @GET()
    Observable<ResponseBody> get(@Url String url, @QueryMap Map<String, String> maps);

    @GET()
    Observable<ResponseBody> getObject(@Url String url, @QueryMap Map<String, Object> maps);

    @POST()
    Observable<ResponseBody> postBody(@Url String url, @Body String body);

}
