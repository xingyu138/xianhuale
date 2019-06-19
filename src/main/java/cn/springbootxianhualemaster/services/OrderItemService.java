package cn.springbootxianhualemaster.services;



import cn.springbootxianhualemaster.pojo.OrderItem;

import java.util.List;
import java.util.Map;

public interface OrderItemService {
     List<OrderItem> getOrderItemList(Map<String, Object> params);
     int addOrderItem(Map<String, Object> params);
     int modifyOrderItem(Map<String, Object> params);
     int removeOrderItem(Map<String, Object> params);
}
