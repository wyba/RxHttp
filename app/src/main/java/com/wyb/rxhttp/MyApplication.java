package com.wyb.rxhttp;

import android.app.Application;

import com.wyb.net.RxHttp;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RxHttp.getInstance().init("http://192.168.2.112:8081/", 20 * 1000);
    }

}
