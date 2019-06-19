package cn.springbootxianhualemaster.services;



import cn.springbootxianhualemaster.pojo.Cart;

import java.util.List;
import java.util.Map;

public interface CartService {
    int getCartItemCount();
    int addCartItem(Map<String, Object> params);
    int modifyCartItem(Map<String, Object> params);
    int removeCartItem(Map<String, Object> params);
    List<Cart> getCartItemList(Map<String, Object> params);
}
