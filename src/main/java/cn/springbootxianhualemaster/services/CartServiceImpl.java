package cn.springbootxianhualemaster.services;


import cn.springbootxianhualemaster.dao.CartMapper;
import cn.springbootxianhualemaster.pojo.Cart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    @Resource
    private CartMapper cartMapper;
    @Override
    public int getCartItemCount() {
        return cartMapper.selectCartItemCount();
    }

    @Override
    public int addCartItem(Map<String,Object> params) {
        return cartMapper.insertCartItem(params);
    }

    @Override
    public int modifyCartItem(Map<String, Object> params) {
        return cartMapper.updateCartItem(params);
    }

    @Override
    public int removeCartItem(Map<String, Object> params) {
        return cartMapper.deleteCartItem(params);
    }

    @Override
    public List<Cart> getCartItemList(Map<String, Object> params) {
        return cartMapper.selectCartItemList(params);
    }
}
