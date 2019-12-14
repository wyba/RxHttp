package com.wyb.net.api;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {

    @GET()
    Observable<ResponseBody> get(@Url String url, @QueryMap Map<String, String> maps);

    @GET()
    Observable<ResponseBody> getObject(@Url String url, @QueryMap Map<String, Object> maps);

    @POST()
    Observable<ResponseBody> postBody(@Url String url, @Body RequestBody requestBody);

    @Multipart
    @POST()
    Observable<ResponseBody> uploadSingleFile(@Url String url, @Part List<MultipartBody.Part> list);

}
