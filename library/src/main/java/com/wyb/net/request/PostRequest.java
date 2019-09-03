package com.wyb.net.request;

import android.util.Log;

import com.wyb.net.RxHttp;
import com.wyb.net.callback.CallBack;
import com.wyb.net.util.JSONUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class PostRequest {

    public <T> void execute(String url, String content,final CallBack<T> callBack) {

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
}
