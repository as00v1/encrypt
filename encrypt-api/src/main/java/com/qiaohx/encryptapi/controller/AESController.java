package com.qiaohx.encryptapi.controller;

import com.qiaohx.encryptapi.model.vo.des.AesEncryptRequestVo;
import com.qiaohx.encryptapi.model.vo.des.DesEncryptResponseVo;
import com.qiaohx.encryptutils.aes.AESUtil;
import com.qiaohx.encryptutils.util.ErrorCodeEnums;
import com.qiaohx.encryptutils.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Base64;

@RestController
@RequestMapping(value = "/aes")
@Api(description = "AES加密接口")
public class AESController {

    private static Logger logger = LoggerFactory.getLogger(AESController.class);

    @PostMapping(value = "/encrypt")
    @ApiOperation("使用秘钥加密字符串")
    public DesEncryptResponseVo encrypt(@RequestBody @Valid AesEncryptRequestVo aesEncryptRequestVo, BindingResult bindingResult) throws Exception {
        logger.info("收到请求:" + aesEncryptRequestVo);
        if(bindingResult.hasErrors()){
            return ResponseUtil.fail(bindingResult, DesEncryptResponseVo.class);
        }

        if (aesEncryptRequestVo.getIv() != null && aesEncryptRequestVo.getIv().length() != 16){
            if("".equals(aesEncryptRequestVo.getIv()))
                aesEncryptRequestVo.setIv(null);
            else
                return ResponseUtil.result(ErrorCodeEnums.PARAM_ERROR, "IV偏移量必须为16位！", DesEncryptResponseVo.class);
        }

        String res = AESUtil.encrypt(aesEncryptRequestVo.getContent(), aesEncryptRequestVo.getKey(), aesEncryptRequestVo.getIv());

        DesEncryptResponseVo desEncryptResponseVo = ResponseUtil.success(DesEncryptResponseVo.class);
        desEncryptResponseVo.setContent(res);
        return desEncryptResponseVo;
    }


    @PostMapping(value = "/decrypt")
    @ApiOperation("使用秘钥解密字符串")
    public DesEncryptResponseVo decrypt(@RequestBody @Valid AesEncryptRequestVo aesEncryptRequestVo, BindingResult bindingResult) throws Exception {
        logger.info("收到请求:" + aesEncryptRequestVo);
        if(bindingResult.hasErrors()){
            return ResponseUtil.fail(bindingResult, DesEncryptResponseVo.class);
        }

        if (aesEncryptRequestVo.getIv() != null && aesEncryptRequestVo.getIv().length() != 16){
            if("".equals(aesEncryptRequestVo.getIv()))
                aesEncryptRequestVo.setIv(null);
            else
                return ResponseUtil.result(ErrorCodeEnums.PARAM_ERROR, "IV偏移量必须为16位！", DesEncryptResponseVo.class);
        }

        String res = AESUtil.decrypt(aesEncryptRequestVo.getContent(), aesEncryptRequestVo.getKey(), aesEncryptRequestVo.getIv());

        DesEncryptResponseVo desEncryptResponseVo = ResponseUtil.success(DesEncryptResponseVo.class);
        desEncryptResponseVo.setContent(res);

        return desEncryptResponseVo;
    }
}
