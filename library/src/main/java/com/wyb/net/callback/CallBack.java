package com.wyb.net.callback;

import java.lang.reflect.ParameterizedType;

public abstract class CallBack<T> {

    public abstract void onStart();

    public abstract void onResponse(T t);

    public abstract void onError(Throwable e);

    public abstract void onComplete();

    private Class<T> clazz;

    @SuppressWarnings("unchecked")
    public CallBack() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    public Class<T> getClazz() {
        return clazz;
    }

}
