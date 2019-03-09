package com.qiaohx.encryptapi.model.vo;

import com.qiaohx.encryptutils.util.BaseDataResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * DES加密结果返回
 */
@ApiModel("DES加密结果")
public class DesEncryptResponseVo extends BaseDataResponse {

    @ApiModelProperty("加密结果")
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
