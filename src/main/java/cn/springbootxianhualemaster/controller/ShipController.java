package cn.springbootxianhualemaster.controller;


import cn.springbootxianhualemaster.pojo.Ship;
import cn.springbootxianhualemaster.services.ShipService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "ship")
public class ShipController {

    @Resource
    private ShipService shipService;

    //获取登录用户收货地址
    @RequestMapping(value = "getUserShip.htm")
    @ResponseBody
    public Object getUserShip(HttpSession session){
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        /*User user=(User)session.getAttribute(Constants.USER_SESSION);
        params.put("user_id",user.getUserid());*/
        params.put("user_id", 2);//测试使用
        try {
            List<Ship> list=shipService.getUserShip(params);
            map.put("result",list);
            map.put("success",true);
            map.put("message","查询成功");
        }catch (Exception e){
            map.put("success",false);
            map.put("message","查询失败");
        }
        return map;
    }
    //增加收货地址
    @RequestMapping(value = "addUserShip.htm")
    @ResponseBody
    public Object addUserShip(HttpSession session, String receiver_name, String receiver_phone,
                              String receiver_mobile, String receiver_province, String receiver_city,
                              String receiver_district, String receiver_address, String receiver_zip){
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        /*User user=(User)session.getAttribute(Constants.USER_SESSION);
        params.put("user_id",user.getUserid());*/
        params.put("user_id", 2);//测试使用
        params.put("receiver_name",receiver_name);
        params.put("receiver_phone",receiver_phone);
        params.put("receiver_mobile",receiver_mobile);
        params.put("receiver_province",receiver_province);
        params.put("receiver_city",receiver_city);
        params.put("receiver_district",receiver_district);
        params.put("receiver_address",receiver_address);
        params.put("receiver_zip",receiver_zip);
        params.put("creationDate",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        try {
            int count=shipService.addUserShip(params);
            if (count>0){
                map.put("success",true);
                map.put("message","新增成功");
            }else {
                map.put("success",false);
                map.put("message","新增失败");
            }
        }catch (Exception e){
            map.put("success",false);
            map.put("message","新增异常");
        }
        return map;
    }
    //修改地址
    @RequestMapping(value = "modifyUserShip.htm")
    @ResponseBody
    public Object modifyUserShip(HttpSession session, String receiver_name, String receiver_phone,
                                 String receiver_mobile, String receiver_province, String receiver_city,
                                 String receiver_district, String receiver_address, String receiver_zip, Integer id){
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        /*User user=(User)session.getAttribute(Constants.USER_SESSION);
        params.put("user_id",user.getUserid());*/
        params.put("user_id", 2);//测试使用
        params.put("receiver_name",receiver_name);
        params.put("receiver_phone",receiver_phone);
        params.put("receiver_mobile",receiver_mobile);
        params.put("receiver_province",receiver_province);
        params.put("receiver_city",receiver_city);
        params.put("receiver_district",receiver_district);
        params.put("receiver_address",receiver_address);
        params.put("receiver_zip",receiver_zip);
        params.put("modifyDate",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        params.put("id",id);
        try {
            int count=shipService.modifyUserShip(params);
            if (count>0){
                map.put("success",true);
                map.put("message","修改成功");
            }else {
                map.put("success",false);
                map.put("message","修改失败");
            }
        }catch (Exception e){
            map.put("success",false);
            map.put("message","修改异常");
        }
        return map;
    }
    //删除地址
    @RequestMapping(value = "removeUserShip.htm")
    @ResponseBody
    public Object removeUserShip(HttpSession session, Integer id){
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        /*User user=(User)session.getAttribute(Constants.USER_SESSION);
        params.put("user_id",user.getUserid());*/
        params.put("user_id", 2);//测试使用
        params.put("id",id);
        try {
            int count=shipService.removeUserShip(params);
            if (count>0){
                map.put("success",true);
                map.put("message","删除成功");
            }else {
                map.put("success",false);
                map.put("message","删除失败");
            }
        }catch (Exception e){
            map.put("success",false);
            map.put("message","删除异常");
        }
        return map;
    }
}
