package cn.springbootxianhualemaster.services;



import cn.springbootxianhualemaster.pojo.Ship;

import java.util.List;
import java.util.Map;

public interface ShipService {
    List<Ship> getUserShip(Map<String, Object> params);
    int addUserShip(Map<String, Object> params);
    int modifyUserShip(Map<String, Object> params);
    int removeUserShip(Map<String, Object> params);
}
