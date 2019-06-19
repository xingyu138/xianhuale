package cn.springbootxianhualemaster.controller;


import cn.springbootxianhualemaster.pojo.Order;
import cn.springbootxianhualemaster.services.OrderItemService;
import cn.springbootxianhualemaster.services.OrderService;
import cn.springbootxianhualemaster.util.PageUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "order")
public class orderController {
    @Resource
    private OrderService orderService;
    @Resource
    private OrderItemService orderItemService;
    //按条件查询订单数量
    @RequestMapping(value = "getOrderCount.htm",method = RequestMethod.GET)
    @ResponseBody
    public Object getOrderCount(String username, String order_no, String create_time,String status){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            Map<String,Object> params=new HashMap<String,Object>();
            params.put("username",username);
            params.put("order_no",order_no);
            params.put("create_time",create_time);
            params.put("status",status);
            int count = orderService.getOrderCount(params);
            map.put("result",count);
            map.put("success",true);
            map.put("message","订单数量查询成功");
        } catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","订单数量查询失败");
        }
        return map;
    }
    //按条件查询订单信息(分页)
    @RequestMapping(value = "getOrderListPage.htm",method = RequestMethod.GET)
    @ResponseBody
    public Object getOrderListPage(String username, String order_no, String create_time,String status
                                   ,Integer pageNum,Integer pageSize){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            Map<String,Object> params=new HashMap<String,Object>();
            if (pageNum!=null&&pageSize!=null) {
            	Integer start= PageUtil.getPageStart(pageNum,pageSize);
            	params.put("start",start);
                params.put("pageSize",pageSize);
			}
            params.put("username",username);
            params.put("order_no",order_no);
            params.put("create_time",create_time);
            params.put("status",status);
            List<Order> list=orderService.getOrderListPage(params);
            map.put("result",list);
            map.put("success",true);
            map.put("message","订单列表查询成功");
        } catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","订单列表查询失败"+e);
        }
        return map;
    }
    //添加订单
    @RequestMapping(value = "addOrder.htm")
    @ResponseBody
    public Object addOrder(Integer shipping_id,Double payment,Integer payment_type,Integer postage,
                           String address,String phone,String username,String wxnum,
                           String message,String orderNo){
        System.out.println("订单控制层"+orderNo);
    	Map<String, Object> params=new HashMap<>();
        Map<String, Object> map=new HashMap<>();
        params.put("order_no",orderNo);
        params.put("shipping_id",shipping_id);
        params.put("payment",payment);
        params.put("payment_type",payment_type);
        params.put("postage",postage);
        params.put("status",10);
        params.put("address",address);
        params.put("phone",phone);
        params.put("username",username);
        params.put("wxnum",wxnum);
        params.put("message",message);
        params.put("create_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        params.put("user_id",2);
        int count=orderService.addOrder(params);
        if (count>0){
            map.put("success", true);
            map.put("message", "添加订单成功");
        }else {
            map.put("success", false);
            map.put("message", "添加订单失败");
        }
        return map;
    }

    //修改订单
    @RequestMapping(value = "modifyOrder.htm")
    @ResponseBody
    public Object modifyOrder(Integer shipping_id,Double payment,Integer payment_type,Integer postage,
                              Integer status,String address,String phone,String username,String wxnum,
                              String message,Integer id,String orderNo){
        System.out.println("====>"+orderNo);
        Map<String, Object> params=new HashMap<>();
        Map<String, Object> map=new HashMap<>();
        params.put("shipping_id",shipping_id);
        params.put("payment",payment);
        params.put("payment_type",payment_type);
        params.put("postage",postage);
        params.put("status",status);
        params.put("address",address);
        params.put("phone",phone);
        params.put("username",username);
        params.put("wxnum",wxnum);
        params.put("message",message);
        params.put("update_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        params.put("user_id",2);
        params.put("id",id);
        params.put("order_no",orderNo);
        if (status==20){
            params.put("payment_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }else if (status==40){
            params.put("send_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }else if (status==50){
            params.put("end_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }else if (status==60){
            params.put("close_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
        try {
            int count=orderService.modifyOrder(params);
            if (count>0){
                map.put("success",true);
                map.put("message","修改订单信息成功");
            }else {
                map.put("success",false);
                map.put("message","修改订单信息失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success",false);
            map.put("message","修改订单信息异常"+e);
        }
        return map;
    }
    //查看订单信息
    @RequestMapping(value = "getOrderInfo.htm")
    @ResponseBody
    public Object getOrderInfo(String orderNo){
        Map<String, Object> params=new HashMap<>();
        Map<String, Object> map=new HashMap<>();
        params.put("order_no",orderNo);
        try {
        	Order order=orderService.getOrderInfo(params);
            if (order!=null){
                map.put("result",order);
                map.put("success",true);
                map.put("message","查询订单信息成功");
            }else {
                map.put("success",false);
                map.put("message","查询订单信息失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","查询订单信息异常"+e);
        }
        return map;
    }
    //删除订单
    @RequestMapping(value = "removeOrder.htm")
    @ResponseBody
    public Object removeOrder(Integer id,String order_no){
        Map<String, Object> params=new HashMap<>();
        Map<String, Object> map=new HashMap<>();
        
        //params.put("order_no",order_no);
        if (order_no!=null){
            //params.put("id",id);
            params.put("order_no",order_no);
        }else {
            map.put("message","订单id异常");
        }
        try {
            int count=orderService.removeOrder(params);
            if (count>0){
                map.put("success",true);
                map.put("message","删除订单信息成功");
            }else {
                map.put("success",false);
                map.put("message","删除订单信息失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("message","删除订单信息异常"+e);
        }
        return map;
    }

}
