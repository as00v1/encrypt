package com.qiaohx.encryptapi.model.vo;

/**
 * DES加密结果返回
 */
public class DesEncryptResponseVo {

    private int code;
    private String errMsg;
    private String content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "DesEncryptResponseVo{" +
                "code=" + code +
                ", errMsg='" + errMsg + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
