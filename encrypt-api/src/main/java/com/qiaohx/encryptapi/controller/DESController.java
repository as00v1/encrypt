package com.qiaohx.encryptapi.controller;

import com.qiaohx.encryptapi.model.vo.DesEncryptRequestVo;
import com.qiaohx.encryptapi.model.vo.DesEncryptResponseVo;
import com.qiaohx.encryptutils.des.DESUtil;
import com.qiaohx.encryptutils.util.BaseResponse;
import com.qiaohx.encryptutils.util.ResponseUtil;
import net.sf.json.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Base64;

@RestController
@RequestMapping(value = "/des")
public class DESController {

    @PostMapping(value = "/getValue")
    public BaseResponse getValue(@RequestBody @Valid DesEncryptRequestVo requestStr, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            bindingResult.getFieldError().getDefaultMessage();
        }
        byte[] res = DESUtil.encrypt(requestStr.getContent(), requestStr.getKey());

        DesEncryptResponseVo desEncryptResponseVo = new DesEncryptResponseVo();
        desEncryptResponseVo.setCode(0);
        desEncryptResponseVo.setContent(new String(Base64.getEncoder().encode(res)));
        BaseResponse baseResponse = ResponseUtil.success(desEncryptResponseVo);

        return baseResponse;
    }
}
