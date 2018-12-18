package com.wyb.net.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;
import java.util.Map;

public class JSONUtils {


    public static <T> T jsonToBean(String json, Class<T> t){
       return JSONObject.parseObject(json,t);
    }

    public static <T> T jsonToBean(String json, Type type){
        return JSONObject.parseObject(json,type);
    }

    /**
     * 方法说明：将bean转化为另一种bean实体
     *
     * @param object
     * @param entityClass
     * @return
     */
    public static <T> T convertBean(Object object, Class<T> entityClass) {
        return JSON.parseObject(JSON.toJSONString(object), entityClass);
    }

    public static Map<String,String> beanToMap(Object object){
        return (Map<String, String>) JSON.parse(JSON.toJSONString(object));
    }

}
