package com.wyb.net.request;

import android.util.Log;

import com.wyb.net.RxHttp;
import com.wyb.net.callback.CallBack;
import com.wyb.net.util.JSONUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class PostRequest {

    public <T> void execute(String url, String content, final CallBack<T> callBack) {

        CompositeDisposable disposables = new CompositeDisposable();

        callBack.onStart();

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        RequestBody requestBody = RequestBody.create(JSON, content);

        disposables.add(RxHttp.getApiService().postBody(url, requestBody)
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String res = responseBody.string();
                            Log.e("PostRequest", "onNext==" + res);
                            T t = JSONUtils.jsonToBean(res, callBack.getClazz());
                            callBack.onResponse(t);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("PostRequest", "onError==" + e.getMessage());
                        callBack.onError(e);
                        callBack.onComplete();
                    }

                    @Override
                    public void onComplete() {
                        Log.e("PostRequest", "onComplete");
                        callBack.onComplete();
                    }
                }));

    }

    public <T> void uploadSingleFile(String url,String contentKey, String content, String fileKey, String filePath, final CallBack<T> callBack) {

        CompositeDisposable disposables = new CompositeDisposable();

        callBack.onStart();

        File file = new File(filePath);
        // 创建 RequestBody，用于封装构建RequestBody
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part body = MultipartBody.Part.createFormData(fileKey, file.getName(), requestFile);

        // 添加描述
        MultipartBody.Part textBody = MultipartBody.Part.createFormData(contentKey, content);

        List<MultipartBody.Part> list = new ArrayList<>();
        list.add(textBody);
        list.add(body);

        disposables.add(RxHttp.getApiService().uploadSingleFile(url, list)
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String res = responseBody.string();
                            Log.e("PostRequest", "onNext==" + res);
                            T t = JSONUtils.jsonToBean(res, callBack.getClazz());
                            callBack.onResponse(t);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("PostRequest", "onError==" + e.getMessage());
                        callBack.onError(e);
                        callBack.onComplete();
                    }

                    @Override
                    public void onComplete() {
                        Log.e("PostRequest", "onComplete");
                        callBack.onComplete();
                    }
                }));

    }
}
