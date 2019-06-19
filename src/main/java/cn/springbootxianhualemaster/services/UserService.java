package cn.springbootxianhualemaster.services;


import cn.springbootxianhualemaster.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * user login
     * @return User
     */
    User userLogin(Map<String,Object> params);
    /**
     * @Description: 取得更具条件取得用户数量
     * @Author: Rum
     * @Date: 4/15/2019 3:48 PM
     * @Param: [map]
     * @Return: int
     */
    int getUserNum(Map<String, Object> map);

    /**
     * @Description: 取得所有的用户
     * @Author: Rum
     * @Date: 4/4/2019 4:45 PM
     * @Param: [map]
     * @Return: java.util.List<cn.xianhuale.pojo.User>
     */
    List<User> getUserList(Map<String, Object> map);


    /**
     * @Description: 添加用户信息
     * @Author: Rum
     * @Date: 4/7/2019 12:40 PM
     * @Param: [map]
     * @Return: int
     */
    int addUser(Map<String, Object> map);

    /**
     * @Description: 更具用户id修改用户信息
     * @Author: Rum
     * @Date: 4/7/2019 12:37 PM
     * @Param: [map]
     * @Return: int
     */
    int updateUserByuserId(Map<String, Object> map);


    /**
     * @Description: 根据用户id删除用户信息
     * @Author: Rum
     * @Date: 4/7/2019 12:42 PM
     * @Param: [map]
     * @Return: int
     */
    int deleteUserbyuserId(Map<String, Object> map);
}
