package cn.springbootxianhualemaster.controller;


import cn.springbootxianhualemaster.pojo.Category;
import cn.springbootxianhualemaster.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


	//类别名称

@RestController
@RequestMapping("/xianhuale/page/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    /**
     * 身份
     * @return
     */
    @RequestMapping("/getCategoryList.htm")
    @ResponseBody
    public Object getCategoryList(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Category> list =categoryService.names();
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
