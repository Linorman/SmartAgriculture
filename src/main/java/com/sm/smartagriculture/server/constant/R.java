package com.sm.smartagriculture.server.constant;

import lombok.Data;

import java.util.HashMap;

/**
 * 返回结果通用类
 * @author linorman
 * @date 2020/7/15 10:45
 */
@Data
public class R<T> {
    private Long code;
    private String msg;
    private T data;
    private HashMap<Object, Object> map = new HashMap<>();

    public static <T> R<T> result(ResultCode resultCode, T data) {
        R<T> r = new R<>();
        r.setCode(resultCode.getCode());
        r.setMsg(resultCode.getMsg());
        r.setData(data);
        return r;
    }

    public R<T> put(Object key, Object value) {
        map.put(key, value);
        return this;
    }
}
