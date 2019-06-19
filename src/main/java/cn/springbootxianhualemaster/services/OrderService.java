package cn.springbootxianhualemaster.services;


import cn.springbootxianhualemaster.pojo.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    //查询所有订单数量
    int getOrderCount(Map<String, Object> params);
    //按条件查询订单列表信息
    List<Order> getOrderListPage(Map<String, Object> params);
    //添加订单
    int addOrder(Map<String, Object> params);
    int addOrder(Order order);
    //按条件查询订单信息
    Order getOrderInfo(Map<String, Object> params);
    //修改订单信息
    int modifyOrder(Map<String, Object> params);
    //删除订单
    int removeOrder(Map<String, Object> params);
}
