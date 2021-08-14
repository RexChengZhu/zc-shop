/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 * <p>
 * https://www.renren.io
 * <p>
 * 版权所有，侵权必究！
 */

package com.zc.eshop.common.utils;


import com.zc.eshop.common.exception.BizCodeException;
import lombok.Data;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
public class R<T> {
    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    private T data;

    public static <T> R<T> ok(T t) {
        R<T> r = new R<>();
        r.code = 200;
        r.msg = "请求成功";
        r.put(t);
        return r;
    }

    public static <T> R<T> error(BizCodeException e, T t){
        R<T> r = new R<>();
        r.code = e.getCode();
        r.msg = e.getMsg();
        r.put(t);
        return r;
    }

    public R<T> put(T t) {
        this.data = t;
        return this;
    }


}
