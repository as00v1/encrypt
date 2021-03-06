package com.qiaohx.encryptutils.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 通用的数据包
 */
@ApiModel("基本业务参数")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDataResponse implements Serializable {

    public BaseDataResponse(int code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    @ApiModelProperty(value = "业务编码", required = true)
    private int code;
    @ApiModelProperty("错误信息")
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
