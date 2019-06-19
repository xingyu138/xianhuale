package cn.springbootxianhualemaster.dao;



import cn.springbootxianhualemaster.pojo.Ship;
import cn.springbootxianhualemaster.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface ShipMapper {
    //员工登录
    Staff doLogin(String staffCode);
    //获取登录用户收货地址
    List<Ship> selectUserShip(Map<String, Object> params);
    //增加收货地址
    int insertUserShip(Map<String, Object> params);
    //修改收货地址
    int updateUserShip(Map<String, Object> params);
    //删除收货地址
    int deleteUserShip(Map<String, Object> params);
}