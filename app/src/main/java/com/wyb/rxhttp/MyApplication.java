package com.wyb.rxhttp;

import android.app.Application;

import com.wyb.net.RxHttp;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RxHttp.init("http://192.168.2.110:8276/IddsApi/V1.0/", 20 * 1000);
    }

}
