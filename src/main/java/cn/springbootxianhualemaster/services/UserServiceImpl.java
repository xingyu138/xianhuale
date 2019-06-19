package cn.springbootxianhualemaster.services;


import cn.springbootxianhualemaster.dao.UserMapper;
import cn.springbootxianhualemaster.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    /**
     * @Description: user login
     * @Author: Rum
     * @Date: 4/15/2019 3:49 PM
     * @Param: [map]
     * @Return: int
     */
    public User userLogin(Map<String,Object> params) {
        return userMapper.userLogin(params);
    }

    /**
     * @Description: 更具条件取得用户条数
     * @Author: Rum
     * @Date: 4/15/2019 3:49 PM
     * @Param: [map]
     * @Return: int
     */
    public int getUserNum(Map<String, Object> map) {

        return userMapper.getUserNum(map);

    }

    /**
     * @Description: 取得所有的用户
     * @Author: Rum
     * @Date: 4/7/2019 12:29 PM
     * @Param: [map]
     * @Return: java.util.List<cn.xianhuale.pojo.User>
     */
    public List<User> getUserList(Map<String, Object> map) {

        return userMapper.selectByField(map);

    }


    /**
     * @Description: 添加用户信息
     * @Author: Rum
     * @Date: 4/7/2019 12:45 PM
     * @Param: [map]
     * @Return: int
     */
    public int addUser(Map<String, Object> map) {

        return userMapper.insertData(map);

    }

    /**
     * @Description: 根据用户id修改用户信息
     * @Author: Rum
     * @Date: 4/7/2019 12:45 PM
     * @Param: [map]
     * @Return: int
     */
    public int updateUserByuserId(Map<String, Object> map) {

        return userMapper.updateByPrimaryKey(map);

    }

    /**
     * @Description: 根据用户id删除删除用户信息
     * @Author: Rum
     * @Date: 4/7/2019 12:44 PM
     * @Param: [map]
     * @Return: int
     */
    public int deleteUserbyuserId(Map<String, Object> map) {

        return userMapper.deleteByPrimaryKey(map);

    }
}
