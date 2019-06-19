package cn.springbootxianhualemaster.dao;




import cn.springbootxianhualemaster.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface OrderItemMapper {
    //查看订单商品列表信息
    List<OrderItem> selectOrderItemList(Map<String, Object> params);
    //增加订单商品信息
    int insertOrderItem(Map<String, Object> params);
    //修改订单商品信息
    int updateOrderItem(Map<String, Object> params);
    //删除订单商品信息
    int deleteOrderItem(Map<String, Object> params);
}