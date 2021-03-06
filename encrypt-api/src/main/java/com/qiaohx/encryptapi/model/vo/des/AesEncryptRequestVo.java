package com.qiaohx.encryptapi.model.vo.des;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@ApiModel("AES加解密请求参数")
public class AesEncryptRequestVo implements Serializable {

    @NotBlank(message="秘钥不能为空！")
    @Size(min = 16, max = 16, message = "秘钥长度必须为16位！")
    @ApiModelProperty(value = "秘钥", required = true)
    private String key;

    @ApiModelProperty("偏移量")
    private String iv;

    @NotNull
    @ApiModelProperty("加密/解密字符串")
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

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }
}
