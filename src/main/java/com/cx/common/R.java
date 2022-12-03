package com.cx.common;

import cn.hutool.http.HttpStatus;

import java.util.HashMap;

public class R extends HashMap<String, Object> {

    private static int OK_CODE = HttpStatus.HTTP_OK;

    private static int ERROR_CODE = HttpStatus.HTTP_INTERNAL_ERROR;

    public static R ok(){
        R r = new R();
        r.put("code", OK_CODE);
        r.put("msg", "success");
        return r;
    }

    public static R ok(Object res){
        R r = new R();
        r.put("data", res);
        r.put("code", OK_CODE);
        r.put("msg", "success");
        return r;
    }

    public static R error(){
        R r = new R();
        r.put("code", ERROR_CODE);
        r.put("msg", "error");
        return r;
    }
    @Override
    public R put(String key, Object value){
        super.put(key, value);
        return this;
    }
}
