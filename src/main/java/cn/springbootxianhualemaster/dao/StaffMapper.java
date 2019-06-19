package cn.springbootxianhualemaster.dao;


import cn.springbootxianhualemaster.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

@Mapper
public interface StaffMapper {
    //查询员工数量
    int selectStaffNum(Map<String, Object> map);

    //员工登录
    Staff doLogin(String staffCode);


    List<Staff> getStaffByRequire(Map<String, Object> map);



    int insertIntoStaff(Map<String, Object> map);

    int updateStaffById(Map<String, Object> map);

    int delectStaffById(Map<String, Object> map);
}