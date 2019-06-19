package cn.springbootxianhualemaster.services;



import cn.springbootxianhualemaster.pojo.Staff;

import java.util.List;
import java.util.Map;


public interface StaffService {
    // 查询所有员工列表信息
    int getStaffNum(Map<String, Object> map);

    // 员工登录
    Staff login(String staffCode);


    /**

     * @Description: 根据条件查询员工信息

     * @Author: Rum

     * @Date: 4/12/2019 5:27 PM

     * @Param: [map]

     * @Return: java.util.List<cn.xianhuale.pojo.Staff>

     */
   List<Staff> getStaffList(Map<String, Object> map);


    /**
     * @param map
     * @return int
     * @author: RUM
     * @date: Mar 31, 2019 5:59:11 PM
     * @Description: 添加员工
     */
    int addStaff(Map<String, Object> map);

    /**
     * @param map
     * @return int
     * @author: RUM
     * @date: Mar 31, 2019 5:52:32 PM
     * @Description: 修改指定员工信息
     */
    int updateStaffById(Map<String, Object> map);

    /**
     * @param map
     * @return int
     * @author: RUM
     * @date: Mar 31, 2019 5:53:38 PM
     * @Description: 更具员工id删除指定员工信息
     */
    int deleteStaffById(Map<String, Object> map);
}
