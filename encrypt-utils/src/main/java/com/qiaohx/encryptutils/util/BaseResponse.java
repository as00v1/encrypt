package com.qiaohx.encryptutils.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 基础的返回值
 * @param <T>
 */
@ApiModel("基本返回参数")
public class BaseResponse<T extends BaseDataResponse> {

    @ApiModelProperty(value = "请求状态码，成功：200", required = true)
    private int status;

    @ApiModelProperty("错误信息")
    private String message;

    @ApiModelProperty("业务参数")
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
