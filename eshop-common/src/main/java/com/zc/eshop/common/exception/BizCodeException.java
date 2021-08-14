package com.zc.eshop.common.exception;

/**
 * 错误码和错误信息定义
 * 错误码规定为5位，前两位为业务字段，后3位为具体错误类型
 * 10: 通用
 *      001: 参数格式校验错误
 * 11: 商品
 * 12: 订单
 * 13: 购物车
 * 14: 物流
 */
public enum BizCodeException {
    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    VALID_EXCEPTION(10001,"参数格式校验失败");

    private Integer code;
    private String msg;

    BizCodeException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
