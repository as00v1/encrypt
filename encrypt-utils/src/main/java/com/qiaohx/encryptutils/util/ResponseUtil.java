package com.qiaohx.encryptutils.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * 通用的返回编码
 */
public class ResponseUtil {

    /**
     * 请求成功
     * @param o 数据
     * @return
     */
    public static BaseResponse success(BaseDataResponse o){
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

    public static BaseResponse fail(BindingResult bindingResult){
        String code = bindingResult.getFieldError().getCode();
//        LOGGER.debug("validator error code: {}", code);
        switch (code) {
            case "NotEmpty":
                return fail(ErrorCodeEnums.PARAM_EMPTY, bindingResult.getFieldError().getDefaultMessage());
            case "NotBlank":
                return fail(ErrorCodeEnums.PARAM_EMPTY, bindingResult.getFieldError().getDefaultMessage());
            case "NotNull":
                return fail(ErrorCodeEnums.PARAM_EMPTY, bindingResult.getFieldError().getDefaultMessage());
            case "Pattern":
                return fail(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
            case "Min":
                return fail(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
            case "Max":
                return fail(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
            case "Length":
                return fail(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
            case "Range":
                return fail(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
            case "Email":
                return fail(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
            case "DecimalMin":
                return fail(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
            case "DecimalMax":
                return fail(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
            case "Size":
                return fail(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
            case "Digits":
                return fail(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
            case "Past":
                return fail(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
            case "Future":
                return fail(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
            default:
                return fail(ErrorCodeEnums.UNKNOW_ERROR, bindingResult.getFieldError().getDefaultMessage());
        }
    }

    /**
     * 返回业务错误信息
     * @param errorCode
     * @param message
     * @return
     */
    public static BaseResponse fail(ErrorCodeEnums errorCode, String message){
        BaseResponse baseResponse = success();// 请求成功
        BaseDataResponse baseDataResponse = new BaseDataResponse();
        baseDataResponse.setCode(errorCode.getCode());
        baseDataResponse.setErrMsg(message);
        baseResponse.setData(baseDataResponse);
        return baseResponse;
    }
}
