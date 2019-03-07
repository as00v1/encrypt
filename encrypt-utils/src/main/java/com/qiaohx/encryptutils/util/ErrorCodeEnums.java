package com.qiaohx.encryptutils.util;

public enum ErrorCodeEnums {

    SUCCESS(0),// 成功
    LOGIN_FAIL(1000),// 1000-1999留作登录
    PARAM_EMPTY(2000),// 2000-2999参数问题
    PARAM_ERROR(2001),
    UNKNOW_ERROR(9999);

    private Integer code;

    ErrorCodeEnums(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

}
