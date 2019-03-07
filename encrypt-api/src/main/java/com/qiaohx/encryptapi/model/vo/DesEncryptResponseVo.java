package com.qiaohx.encryptapi.model.vo;

import com.qiaohx.encryptutils.util.BaseDataResponse;

/**
 * DES加密结果返回
 */
public class DesEncryptResponseVo extends BaseDataResponse {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DesEncryptResponseVo{" +
                "content='" + content + '\'' +
                '}';
    }
}
