package cn.springbootxianhualemaster.services;



import cn.springbootxianhualemaster.dao.StaffMapper;
import cn.springbootxianhualemaster.pojo.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    // 查询所有员工信息
    @Override
    public int getStaffNum(Map<String,Object> map) {

        return staffMapper.selectStaffNum(map);

    }

    /**
    
     * @Description: 用户登入
    
     * @Author: Rum
    
     * @Date: 4/12/2019 12:02 AM
    
     * @Param: [staffCode]
    
     * @Return: cn.xianhuale.pojo.Staff
    
     */
    public Staff login(String staffCode) {

        return staffMapper.doLogin(staffCode);

    }

    /**
     * Title: getStaffByStaffName
     * <p>
     * Description: 根据员工姓名查询员工信息
     *
     * @param map
     * @return List<Staff>
     * @see cn.xianhuale.services.StaffService#getStaffList(Map)
     */
    public List<Staff> getStaffList(Map<String, Object> map) {

        return staffMapper.getStaffByRequire(map);

    }


    /**
     * Title: addStaff
     * <p>
     * Description: 添加员工
     *
     * @param map
     * @return int
     * @see cn.xianhuale.services.StaffService#addStaff(Map)
     */
    public int addStaff(Map<String, Object> map) {

        return staffMapper.insertIntoStaff(map);

    }

    /**
     * Title: updateStaff
     * <p>
     * Description: 更改员工信息
     *
     * @param map
     * @return int
     * @see cn.xianhuale.services.StaffService#updateStaffById(Map)
     */
    public int updateStaffById(Map<String, Object> map) {

        return staffMapper.updateStaffById(map);

    }

    /**
     * Title: deleteStaffById
     * <p>
     * Description: 根据用户id删除指定用户信息
     *
     * @param map
     * @return
     * @see cn.xianhuale.services.StaffService#deleteStaffById(Map)
     */
    public int deleteStaffById(Map<String, Object> map) {

        return staffMapper.delectStaffById(map);

    }

}
