package cn.springbootxianhualemaster.services;


import cn.springbootxianhualemaster.dao.OrderMapper;
import cn.springbootxianhualemaster.pojo.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    //查询所有订单数量
    @Override
    public int getOrderCount(Map<String, Object> params) {
        return orderMapper.selectOrderCount(params);
    }
    //按条件查询订单信息
    @Override
    public List<Order> getOrderListPage(Map<String, Object> params) {
        return orderMapper.selectOrderListPage(params);
    }
    //添加订单
    @Override
    public int addOrder(Map<String, Object> params) {
        return orderMapper.insertOrder(params);
    }

    @Override
    public int addOrder(Order order) {
        return orderMapper.insertOrder(order);
    }
    //按条件查询订单信息
    @Override
    public Order getOrderInfo(Map<String, Object> params) {
        return orderMapper.selectOrderInfo(params);
    }
    //修改订单
    @Override
    public int modifyOrder(Map<String, Object> params) {
        return orderMapper.updateOrder(params);
    }
    //删除订单
    @Override
    public int removeOrder(Map<String, Object> params) {
        return orderMapper.deleteOrder(params);
    }
}
