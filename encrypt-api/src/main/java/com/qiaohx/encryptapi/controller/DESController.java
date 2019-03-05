package com.qiaohx.encryptapi.controller;

import com.qiaohx.encryptutils.des.DESUtil;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping(value = "/des")
public class DESController {

    @RequestMapping(value = "/getValue")
    public String getValue(@RequestBody String requestStr){
        JSONObject json = JSONObject.fromObject(requestStr);
        JSONObject resultJson = new JSONObject();
        String key = json.containsKey("key") ? json.getString("key") : "";
        String content = json.containsKey("content") ? json.getString("content") : "";

        byte[] res = DESUtil.encrypt(content, key);

        resultJson.put("code", 200);
        resultJson.put("message", "SUCCESS");
        JSONObject data = new JSONObject();
        data.put("state", 0);
        data.put("content", new String(Base64.getEncoder().encode(res)));
        resultJson.put("data", data);
        return resultJson.toString();
    }
}
