package cn.springbootxianhualemaster.controller;

import cn.springbootxianhualemaster.pojo.OrderItem;
import cn.springbootxianhualemaster.services.OrderItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "orderItem")
public class OrderItemController {
    @Resource
    private OrderItemService orderItemService;
    //查询订单商品信息
    @RequestMapping(value = "getOrderItemList.htm")
    @ResponseBody
    public Object getOrderItemList(String order_no){
        Map<String,Object> params=new HashMap<>();
        Map<String,Object> map=new HashMap<>();
        //params.put("user_id",1);
        params.put("order_no",order_no);
        try {
        List<OrderItem> list=orderItemService.getOrderItemList(params);
            map.put("result",list);
            map.put("success",true);
            map.put("message","订单商品查询成功");
        } catch (Exception e){
            map.put("success",false);
            map.put("message","订单商品查询失败");
        }
        return map;
    }
    //添加订单商品信息
    @RequestMapping(value = "addOrderItem.htm")
    @ResponseBody
    public Object addOrderItem(Integer product_id,Integer quantity,Double total_price,String address,
                               String productName,String product_PIC,Double price,String orderNo){
        Map<String,Object> params=new HashMap<>();
        Map<String,Object> map=new HashMap<>();
        System.out.println("订单商品控制层"+orderNo);
        params.put("product_id",product_id);
        params.put("quantity",quantity);
        params.put("total_price",total_price);
        params.put("address",address);
        params.put("create_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        params.put("user_id", 2);
        params.put("order_no", orderNo);
        params.put("product_name",productName);
        params.put("product_image",product_PIC);
        params.put("current_unit_price",price);
        try {
            int count=orderItemService.addOrderItem(params);
            if (count>0){
                map.put("success",true);
                map.put("message","订单商品添加成功");
            }else {
                map.put("success",false);
                map.put("message","订单商品添加失败");
            }
        }catch (Exception e){
            map.put("success",false);
            map.put("message","订单商品添加异常"+e);
        }
        return map;
    }


   /* @RequestMapping(value = "addOrderItem.htm")
    @ResponseBody
    public Object addOrderItem(List<OrderItem> orderItem){
        Map<String,Object> params=new HashMap<>();
        Map<String,Object> map=new HashMap<>();
        int count=0;
        for (OrderItem product:orderItem) {
            params.put("product_id", product.getProductId());
            params.put("quantity", product.getQuantity());
            params.put("total_price", product.getTotalPrice());
            params.put("address", product.getAddress());
            params.put("create_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            params.put("user_id", product.getUserId());

            count = orderItemService.addOrderItem(params);

        }
        try {

            if (count>0){
                map.put("success",true);
                map.put("message","订单商品添加成功");
            }else {
                map.put("success",false);
                map.put("message","订单商品添加失败");
            }
        }catch (Exception e){
            map.put("success",false);
            map.put("message","订单商品添加异常"+e);
        }
        return map;
    }*/
    //修改订单商品信息
    @RequestMapping(value = "modifyOrderItem.htm")
    @ResponseBody
    public Object modifyOrderItem(Integer product_id,Integer quantity,Double total_price,String address,
                                  Integer id,String orderNo){
        Map<String,Object> params=new HashMap<>();
        Map<String,Object> map=new HashMap<>();
        params.put("product_id",product_id);
        params.put("quantity",quantity);
        params.put("total_price",total_price);
        params.put("address",address);
        params.put("update_time",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        params.put("user_id", 2);
        params.put("order_no",orderNo);
        params.put("id",id);
        try {
            int count=orderItemService.modifyOrderItem(params);
            if (count>0){
                map.put("success",true);
                map.put("message","订单商品修改成功");
            }else {
                map.put("success",false);
                map.put("message","订单商品修改失败");
            }
        }catch (Exception e){
            map.put("success",false);
            map.put("message","订单商品修改异常"+e);
        }
        return map;
    }
    //删除订单商品信息
    @RequestMapping(value = "removeOrderItem.htm")
    @ResponseBody
    public Object removeOrderItem(String order_no){
        Map<String,Object> params=new HashMap<>();
        Map<String,Object> map=new HashMap<>();
        params.put("order_no",order_no);
        try {
            int count=orderItemService.removeOrderItem(params);
            if (count>0){
                map.put("success",true);
                map.put("message","订单商品删除成功");
            }else {
                map.put("success",false);
                map.put("message","订单商品删除失败");
            }
        }catch (Exception e){
            map.put("success",false);
            map.put("message","订单商品删除异常"+e);
        }
        return map;
    }

}
