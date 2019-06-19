package cn.springbootxianhualemaster.controller;


import cn.springbootxianhualemaster.pojo.Color;
import cn.springbootxianhualemaster.services.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//颜色名称
@RestController
    @RequestMapping("/xianhuale//page/color")
    public class ColorController {
        @Autowired
        private ColorService colorService;
        /**
         * 身份
         * @return
         */
        @RequestMapping("/getColorList.htm")
        @ResponseBody
        public Object getColorList(){
            Map<String, Object> map = new HashMap<String, Object>();
            try {
                List<Color> list =colorService.names();
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
