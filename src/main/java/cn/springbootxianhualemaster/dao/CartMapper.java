package cn.springbootxianhualemaster.dao;




import cn.springbootxianhualemaster.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface CartMapper {
    //查询购物车商品数量
    int selectCartItemCount();
    //添加商品到购物车(用户登录的情况下)
    int insertCartItem(Map<String, Object> params);
    //修改购物车中商品
    int updateCartItem(Map<String, Object> params);
    //删除购物车商品
    int deleteCartItem(Map<String, Object> params);
    //查看购物车
    List<Cart> selectCartItemList(Map<String, Object> params);
}