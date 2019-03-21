package com.qiaohx.encryptapi.model.vo.des;

import com.qiaohx.encryptutils.util.BaseDataResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * DES加密结果返回
 */
@ApiModel("MD5摘要结果")
public class Md5ResponseVo extends BaseDataResponse {

    @ApiModelProperty("摘要结果")
    private String content;

    public Md5ResponseVo(int code, String errMsg) {
        super(code, errMsg);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Md5ResponseVo{" +
                "content='" + content + '\'' +
                '}';
    }
}
