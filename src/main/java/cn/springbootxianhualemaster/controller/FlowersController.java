package cn.springbootxianhualemaster.controller;


import cn.springbootxianhualemaster.pojo.Flowers;
import cn.springbootxianhualemaster.services.FlowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//花材名称

@RestController
@RequestMapping("/xianhuale//page/flowers")
public class FlowersController {
    @Autowired
    private FlowersService flowersService;
    /**
     * 身份
     * @return
     */
    @RequestMapping("/getFlowersList.htm")
    @ResponseBody
    public Object getFlowersList(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Flowers> list =flowersService.names();
            map.put("result", list);
            map.put("message", "供应商列表查询成功");
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("message", "供应商列表查询异常："+e);
        }
        return map;}
}
