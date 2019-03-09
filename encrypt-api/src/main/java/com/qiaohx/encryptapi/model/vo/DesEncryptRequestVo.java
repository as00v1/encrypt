package com.qiaohx.encryptapi.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@ApiModel("DES加密请求参数")
public class DesEncryptRequestVo implements Serializable {

    @NotBlank(message="秘钥不能为空！")
    @Size(min = 8, max = 8, message = "秘钥长度应为8位！")
    @ApiModelProperty(value = "秘钥", required = true)
    private String key;

    @NotNull
    @ApiModelProperty("待加密字符串")
    private String content;

    @Override
    public String toString() {
        return "DesEncryptRequestVo{" +
                "key='" + key + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
