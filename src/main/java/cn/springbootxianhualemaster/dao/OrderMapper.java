package cn.springbootxianhualemaster.dao;




import cn.springbootxianhualemaster.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface OrderMapper {
    //按条件查询订单数量
   int selectOrderCount(Map<String, Object> params);
   //按条件查看订单信息
   List<Order> selectOrderListPage(Map<String, Object> params);
   //添加订单信息
   int insertOrder(Map<String, Object> params);
   int insertOrder(Order order);
   //修改订单信息
   int updateOrder(Map<String, Object> params);
   //按条件查询订单信息
   Order selectOrderInfo(Map<String, Object> params);
   //删除订单
   int deleteOrder(Map<String, Object> params);
}