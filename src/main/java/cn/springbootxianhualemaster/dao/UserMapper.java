package cn.springbootxianhualemaster.dao;


import cn.springbootxianhualemaster.pojo.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    User userLogin(Map<String,Object> params);


    int getUserNum(Map<String, Object> map);

    /**
     * @Description: 更具条件查询
     * @Author: Rum
     * @Date: 4/7/2019 11:52 AM
     * @Param: [userid]
     * @Return: java.util.List<cn.xianhuale.pojo.User>
     */
    List<User> selectByField(Map<String, Object> map);

    /**
     * @Description: 根据主键修改用户信息
     * @Author: Rum
     * @Date: 4/7/2019 12:31 PM
     * @Param: [map]
     * @Return: int
     */
    int updateByPrimaryKey(Map<String, Object> map);

    /**
     * @Description: 添加用户信息
     * @Author: Rum
     * @Date: 4/7/2019 12:32 PM
     * @Param: [map]
     * @Return: int
     */
    int insertData(Map<String, Object> map);

    /**
     * @Description: 根据主键删除用户信息
     * @Author: Rum
     * @Date: 4/7/2019 12:32 PM
     * @Param: [map]
     * @Return: int
     */
    int deleteByPrimaryKey(Map<String, Object> map);
}