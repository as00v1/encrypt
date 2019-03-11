package com.qiaohx.encryptutils.util;

import org.springframework.validation.BindingResult;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通用的返回编码
 */
public class ResponseUtil {

    public static final String SUCCESS = "success";
    /**
     * 请求成功
     * @param o 数据
     * @return
     */
    public static <T extends BaseDataResponse> T success(Class<T> o){
        return result(ErrorCodeEnums.SUCCESS, SUCCESS, o);
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

    public static <T extends BaseDataResponse> T fail(BindingResult bindingResult, Class<T> o){
        String code = bindingResult.getFieldError().getCode();
//        LOGGER.debug("validator error code: {}", code);
        switch (code) {
            case "NotEmpty":
                return result(ErrorCodeEnums.PARAM_EMPTY, bindingResult.getFieldError().getDefaultMessage(), o);
            case "NotBlank":
                return result(ErrorCodeEnums.PARAM_EMPTY, bindingResult.getFieldError().getDefaultMessage(), o);
            case "NotNull":
                return result(ErrorCodeEnums.PARAM_EMPTY, bindingResult.getFieldError().getDefaultMessage(), o);
            case "Pattern":
                return result(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
            case "Min":
                return result(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
            case "Max":
                return result(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
            case "Length":
                return result(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
            case "Range":
                return result(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
            case "Email":
                return result(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
            case "DecimalMin":
                return result(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
            case "DecimalMax":
                return result(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
            case "Size":
                return result(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
            case "Digits":
                return result(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
            case "Past":
                return result(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
            case "Future":
                return result(ErrorCodeEnums.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
            default:
                return result(ErrorCodeEnums.UNKNOW_ERROR, bindingResult.getFieldError().getDefaultMessage(), o);
        }
    }

    /**
     * 返回业务错误信息
     * @param errorCode
     * @param message
     * @return
     */
    public static <T extends BaseDataResponse> T result(ErrorCodeEnums errorCode, String message, Class<T> o){
        T t = null;
        try {
            Constructor c = o.getDeclaredConstructor(new Class[]{int.class,String.class});
            c.setAccessible(true);
            t = (T) c.newInstance(new Object[]{errorCode.getCode(), message});
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }
}
