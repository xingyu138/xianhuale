package cn.springbootxianhualemaster.controller;


import cn.springbootxianhualemaster.pojo.Cart;
import cn.springbootxianhualemaster.services.CartService;

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
@RequestMapping(value = "cart")
public class CartController {
    @Resource
    private CartService cartService;

    @RequestMapping(value = "getCartItemCount.htm")
    @ResponseBody
    public Object getCartItemCount() {
        Map<String, Object> map = new HashMap<>();

        try {
            int count = cartService.getCartItemCount();
            if (count > 0) {
                map.put("result", count);
                map.put("success", true);
                map.put("message", "查询成功");
            } else {
                map.put("success", false);
                map.put("message", "查询失败");
            }
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "查询异常");

        }
        return map;
    }

    //购物车添加商品(已登录用户)
    @RequestMapping(value = "addCartItem.htm")
    @ResponseBody
    public Object addCartItem(HttpSession session, String productId, Integer quantity, Integer checked) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        /*User user=(User)session.getAttribute(Constants.USER_SESSION);
        params.put("user_id",user.getUserid());*/
        params.put("user_id", 2);//测试使用
        params.put("product_id", productId);
        params.put("quantity", quantity);
        params.put("checked", checked);
        params.put("create_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        try {
            int count = cartService.addCartItem(params);
            if (count > 0) {
                map.put("success", true);
                map.put("message", "插入数据成功");
            } else {
                map.put("success", false);
                map.put("message", "插入数据失败");
            }
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "插入数据异常");
        }

        return map;
    }

    //修改购物车
    @RequestMapping(value = "modifyCartItem.htm")
    @ResponseBody
    public Object modifyCartItem(HttpSession session, String productId, Integer quantity, Integer checked, Integer id) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        /*User user=(User)session.getAttribute(Constants.USER_SESSION);
        params.put("user_id",user.getUserid());*/
        params.put("user_id", 2);//测试使用
        params.put("product_id", productId);
        params.put("quantity", quantity);
        params.put("checked", checked);
        params.put("update_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        params.put("id", id);
        try {
            int count = cartService.modifyCartItem(params);
            if (count > 0) {
                map.put("success", true);
                map.put("message", "修改数据成功");
            } else {
                map.put("success", false);
                map.put("message", "修改数据失败");
            }
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "修改数据异常");
        }
        return map;
    }

    //删除购物车中的商品
    @RequestMapping(value = "removeCartItem.htm")
    @ResponseBody
    public Object removeCartItem(HttpSession session, Integer id) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        params.put("id", id);
         /*User user=(User)session.getAttribute(Constants.USER_SESSION);
        params.put("user_id",user.getUserid());*/
        params.put("user_id", 2);//测试使用
        try {
            int count = cartService.removeCartItem(params);
            if (count > 0) {
                map.put("success", true);
                map.put("message", "删除数据成功");
            } else {
                map.put("success", false);
                map.put("message", "删除数据失败");
            }
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "删除数据异常");
        }
        return map;
    }
    //获取购物车中的商品（登录用户）
    @RequestMapping(value = "getCartItemList.htm")
    @ResponseBody
    public Object getCartItemList(HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> map = new HashMap<>();

         /*User user=(User)session.getAttribute(Constants.USER_SESSION);
        params.put("user_id",user.getUserid());*/
        params.put("user_id", 2);//测试使用
        try {
            List<Cart> list = cartService.getCartItemList(params);
                map.put("result",list);
                map.put("success", true);
                map.put("message", "查询列表数据成功");
        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "查询列表数据异常");
        }
        return map;
    }
}
