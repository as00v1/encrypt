package com.qiaohx.encryptapi.controller;

import com.qiaohx.encryptapi.model.vo.DesEncryptRequestVo;
import com.qiaohx.encryptutils.des.DESUtil;
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
    public String getValue(@RequestBody @Valid DesEncryptRequestVo requestStr, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return bindingResult.getFieldError().getDefaultMessage();
//        }
        JSONObject resultJson = new JSONObject();
        byte[] res = DESUtil.encrypt(requestStr.getContent(), requestStr.getKey());

        resultJson.put("status", 200);
        resultJson.put("message", "SUCCESS");
        JSONObject data = new JSONObject();
        data.put("code", 0);
        data.put("content", new String(Base64.getEncoder().encode(res)));
        resultJson.put("data", data);
        return resultJson.toString();
    }
}
