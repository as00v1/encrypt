package com.qiaohx.encryptapi.model.vo.des;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel("MD5摘要请求参数")
public class Md5RequestVo implements Serializable {

    @NotNull
    @NotBlank(message="待摘要字符串不能为空！")
    @ApiModelProperty("待摘要字符串")
    private String content;

    @Override
    public String toString() {
        return "Md5RequestVo{" +
                "content='" + content + '\'' +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
