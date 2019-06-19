package cn.springbootxianhualemaster.services;


import cn.springbootxianhualemaster.dao.ShipMapper;
import cn.springbootxianhualemaster.pojo.Ship;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ShipServiceImpl implements ShipService{
    @Resource
    private ShipMapper shipMapper;
    @Override
    public List<Ship> getUserShip(Map<String, Object> params) {
        return shipMapper.selectUserShip(params);
    }

    @Override
    public int addUserShip(Map<String, Object> params) {
        return shipMapper.insertUserShip(params);
    }

    @Override
    public int modifyUserShip(Map<String, Object> params) {
        return shipMapper.updateUserShip(params);
    }

    @Override
    public int removeUserShip(Map<String, Object> params) {
        return shipMapper.deleteUserShip(params);
    }
}
