package com.qiaohx.encryptutils.util;

/**
 * 通用的返回编码
 */
public class ResponseUtil {

    /**
     * 请求成功
     * @param o 数据
     * @return
     */
    public static BaseResponse success(Object o){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(200);
        baseResponse.setMessage("success");
        baseResponse.setData(o);
        return baseResponse;
    }

    /**
     * 请求成功
     * @return
     */
    public static BaseResponse success(){
        return success(null);
    }

    /**
     * 请求失败
     * @param status 状态码
     * @param message 错误信息
     * @return
     */
    public static BaseResponse error(int status, String message){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus(status);
        baseResponse.setMessage(message);
        return baseResponse;
    }
}
