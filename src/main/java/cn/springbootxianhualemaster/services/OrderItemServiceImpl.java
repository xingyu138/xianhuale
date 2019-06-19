package cn.springbootxianhualemaster.services;

import cn.springbootxianhualemaster.dao.OrderItemMapper;
import cn.springbootxianhualemaster.pojo.OrderItem;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Resource
    private OrderItemMapper orderItemMapper;
    @Override
    public List<OrderItem> getOrderItemList(Map<String, Object> params) {
        return orderItemMapper.selectOrderItemList(params);
    }

    @Override
    public int addOrderItem(Map<String, Object> params) {
        return orderItemMapper.insertOrderItem(params);
    }

    @Override
    public int modifyOrderItem(Map<String, Object> params) {
        return orderItemMapper.updateOrderItem(params);
    }

    @Override
    public int removeOrderItem(Map<String, Object> params) {
        return orderItemMapper.deleteOrderItem(params);
    }
}
