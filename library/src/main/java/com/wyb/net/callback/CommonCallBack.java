package com.wyb.net.callback;

public abstract class CommonCallBack<T> extends CallBack<T> {

    private T t;

    @Override
    public void onStart() {

    }

    @Override
    public void onResponse(T t) {
        this.t = t;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {
        onFinal(t);
    }

    public abstract void onFinal(T t);

}
