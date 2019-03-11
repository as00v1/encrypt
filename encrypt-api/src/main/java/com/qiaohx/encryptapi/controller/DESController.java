package com.qiaohx.encryptapi.controller;

import com.qiaohx.encryptapi.model.vo.DesEncryptRequestVo;
import com.qiaohx.encryptapi.model.vo.DesEncryptResponseVo;
import com.qiaohx.encryptutils.des.DESUtil;
import com.qiaohx.encryptutils.util.BaseResponse;
import com.qiaohx.encryptutils.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Base64;

@RestController
@RequestMapping(value = "/des")
@Api(description = "DES加密接口")
public class DESController {

    private static Logger logger = LoggerFactory.getLogger(DESController.class);

    @PostMapping(value = "/getValue")
    @ApiOperation("使用秘钥加密字符串")
    public DesEncryptResponseVo getValue(@RequestBody @Valid DesEncryptRequestVo desEncryptRequestVo, BindingResult bindingResult){

        logger.info("收到请求:" + desEncryptRequestVo);
        if(bindingResult.hasErrors()){
            return ResponseUtil.fail(bindingResult, DesEncryptResponseVo.class);
        }
        byte[] res = DESUtil.encrypt(desEncryptRequestVo.getContent(), desEncryptRequestVo.getKey());

        DesEncryptResponseVo desEncryptResponseVo = ResponseUtil.success(DesEncryptResponseVo.class);
        desEncryptResponseVo.setContent(new String(Base64.getEncoder().encode(res)));

        return desEncryptResponseVo;
    }
}
