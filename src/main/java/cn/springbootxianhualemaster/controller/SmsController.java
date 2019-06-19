package cn.springbootxianhualemaster.controller;

import cn.springbootxianhualemaster.util.RandowUtil;
import cn.springbootxianhualemaster.util.RedisUtil;
import cn.springbootxianhualemaster.util.SendSmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SmsController {

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/sendSms")
    public Object sendSms(String phone) {

        Map<String, Object> map = new HashMap<>();

        //Get randow message
        String messageCode = RandowUtil.createRandowUtil();
        //Send SMS by phone
        SendSmsUtil.sendSms(phone, messageCode);
        //将验证码放入redis缓存中
        redisUtil.set("SMS" + phone, messageCode, 120);

        map.put("success", true);
        map.put("message", "发送验证码成功,请尽快验证");

        return map;

    }

}
