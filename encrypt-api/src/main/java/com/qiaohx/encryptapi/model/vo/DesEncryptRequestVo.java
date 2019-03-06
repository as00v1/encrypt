package com.qiaohx.encryptapi.model.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class DesEncryptRequestVo implements Serializable {

    @NotBlank(message="秘钥不能为空！")
//    @Size(min = 8, message = "秘钥长度必须为8的倍数！")
    private String key;

    @NotNull
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
