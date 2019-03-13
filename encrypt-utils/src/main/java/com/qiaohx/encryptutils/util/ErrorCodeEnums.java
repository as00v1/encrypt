package com.qiaohx.encryptutils.util;

public enum ErrorCodeEnums {

    SUCCESS(0, ResponseUtil.SUCCESS),// 成功
    LOGIN_FAIL(1000),// 1000-1999留作登录
    PARAM_EMPTY(2000, "请检查必传参数！"),// 2000-2999参数问题
    PARAM_ERROR(2001, "请检查参数！"),
    UNKNOW_ERROR(9999, "服务器开小差啦~");

    private Integer code;
    private String message;

    ErrorCodeEnums(Integer code) {
        this.code = code;
    }

    ErrorCodeEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
