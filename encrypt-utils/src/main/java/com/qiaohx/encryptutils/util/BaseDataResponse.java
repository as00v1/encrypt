package com.qiaohx.encryptutils.util;

/**
 * 通用的数据包
 */
public class BaseDataResponse {

    private int code;
    private String errMsg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "BaseDataResponse{" +
                "code=" + code +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
