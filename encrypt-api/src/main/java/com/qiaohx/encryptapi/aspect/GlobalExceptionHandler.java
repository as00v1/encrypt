package com.qiaohx.encryptapi.aspect;

import com.qiaohx.encryptutils.util.ErrorCodeEnums;
import com.qiaohx.encryptutils.util.ResponseUtil;
import com.qiaohx.encryptutils.util.date.DateFormatRules;
import com.qiaohx.encryptutils.util.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局HTTP请求异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 通用异常处理机制
     * @param e
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<String> commonExceptionHandler(Exception e){
        logger.error("============================" + DateUtil.dateToStr(DateFormatRules.YYYY_MM_DD_HH_MM_SS) + " ERROR ============================");
        logger.error("catch exception:", e);

//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//        headers.set("Content-Type", "application/json;charset=UTF-8");

        ResponseEntity<String> entity = new ResponseEntity(ResponseUtil.error(ErrorCodeEnums.UNKNOW_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);

        return entity;
    }
}
