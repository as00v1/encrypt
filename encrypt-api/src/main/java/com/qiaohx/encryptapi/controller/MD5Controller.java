package com.qiaohx.encryptapi.controller;


import com.qiaohx.encryptapi.model.vo.des.Md5RequestVo;
import com.qiaohx.encryptapi.model.vo.des.Md5ResponseVo;
import com.qiaohx.encryptutils.md5.MD5Util;
import com.qiaohx.encryptutils.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/md5")
@Api(description = "MD5摘要接口")
public class MD5Controller {

    private static Logger logger = LoggerFactory.getLogger(MD5Controller.class);

    @RequestMapping(value = "/getMd5", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation("使用秘钥加密字符串")
    public Md5ResponseVo encrypt(@RequestBody @Valid Md5RequestVo md5RequestVo, BindingResult bindingResult) {
        logger.info("收到请求:" + md5RequestVo);
        if(bindingResult.hasErrors()){
            return ResponseUtil.fail(bindingResult, Md5ResponseVo.class);
        }

        String res = MD5Util.getMD5(md5RequestVo.getContent());

        Md5ResponseVo md5ResponseVo = ResponseUtil.success(Md5ResponseVo.class);
        md5ResponseVo.setContent(res);
        return md5ResponseVo;
    }

}
