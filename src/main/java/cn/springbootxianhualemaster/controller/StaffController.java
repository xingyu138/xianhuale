package cn.springbootxianhualemaster.controller;


import cn.springbootxianhualemaster.pojo.Staff;
import cn.springbootxianhualemaster.services.StaffService;
import cn.springbootxianhualemaster.util.Constants;
import cn.springbootxianhualemaster.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/page/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;


    @RequestMapping(value = "/getStaffNum.htm", method = RequestMethod.GET)
    @ResponseBody
    public Object getStaffNum(String staffCode) {

        Map<String, Object> params = new HashMap<>();

        Map<String, Object> map = new HashMap<>();

        params.put("staffCode", staffCode);

        try {

            int count = staffService.getStaffNum(params);

            map.put("result", count);

            map.put("message", "查询员工数量成功");

            map.put("success", true);

        } catch (Exception e) {

            map.put("message", "查询员工信息失败" + e);

            map.put("success", false);

        }

        return map;

    }

    /**
     * @Description: 取得所有的员工信息以json数据格式发送
     * @Author: Rum
     * @Date: 4/8/2019 1:05 AM
     * @Param: [pageNum, pageSize]
     * @Return: java.lang.Object
     */
    @RequestMapping(value = "/staffList.htm", method = RequestMethod.GET)
    @ResponseBody
    public Object getStaffList(Integer id, String staffCode, String staffName, Integer pageNum, Integer pageSize) {

        Map<String, Object> map = new HashMap<>(); //存储取得结果

        int start = PageUtil.getPageStart(pageNum, pageSize);//获得分页的起始点

        Map<String, Object> params = new HashMap<>();

        params.put("id", id);

        params.put("staffCode", staffCode);

        params.put("staffName", staffName);

        params.put("start", start);

        params.put("pageSize", pageSize);


        try {

            List<Staff> staffList = staffService.getStaffList(params);//取得所有的员工信息

            map.put("result", staffList);

            map.put("message", "成员列表查询成功");

            map.put("success", true);


        } catch (Exception e) {

            e.printStackTrace();

            map.put("message", "员工列表查询异常" + e);

            map.put("success", false);

        }

        return map;//注解解析成json格式的数据然后发送结果
    }


    /**
     * @Description: 添加成员信息
     * @Author: Rum
     * @Date: 4/9/2019 5:21 PM
     * @Param: [staffCode, staffName]
     * @Return: java.lang.Object
     */
    @RequestMapping(value = "/addStaff.htm", method = RequestMethod.POST)
    @ResponseBody
    public Object addStaff(String staffCode, String staffName, String staffPassword, Integer gender, Date birthday, String phone, String address, Integer staffRole) {

        Map<String, Object> map = new HashMap<>();

        Map<String, Object> params = new HashMap<>();

        params.put("staffCode", staffCode);

        params.put("staffName", staffName);

        params.put("staffPassword", staffPassword);

        params.put("gender", gender);

        params.put("birthday", new SimpleDateFormat("yyyy-MM-dd").format(birthday));

        params.put("phone", phone);

        params.put("address", address);

        params.put("staffRole", staffRole);

        params.put("creationDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        try {

            int count = staffService.addStaff(params);

            map.put("success", true);

            map.put("message", "添加成员信息成功");

        } catch (Exception e) {

            map.put("success", false);

            map.put("message", "添加成员信息失败");

        }

        return map;


    }

    /**
     * @Description: 根据员工id更改指定员工信息
     * @Author: Rum
     * @Date: 4/8/2019 1:48 AM
     * @Param: [staff]
     * @Return: java.lang.Object
     */
    @RequestMapping(value = "/updateStaffById.htm", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStaffById(int id, String staffCode, String staffName, String staffPassword, Integer gender, Date birthday, String phone, String address, Integer staffRole) {

        Map<String, Object> map = new HashMap<>();

        Map<String, Object> params = new HashMap<>();

        params.put("id", id);

        params.put("staffCode", staffCode);

        params.put("staffName", staffName);

        params.put("phone", phone);

        params.put("address", address);

        params.put("staffPassword", staffPassword);

        params.put("gender", gender);

        params.put("birthday", birthday);

        params.put("staffRole", staffRole);


        params.put("modifyDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        try {

            int count = staffService.updateStaffById(params);

            map.put("result",count);
            map.put("success", true);
            map.put("message", "更改成员信息成功");

        } catch (Exception e) {

            e.printStackTrace();

            map.put("success", false);
            map.put("message", "更改成员信息失败" + e);


        }

        return map;

    }


    /**
     * @Description: 更具成员id删除指定成员信息
     * @Author: Rum
     * @Date: 4/9/2019 5:18 PM
     * @Param: [id]
     * @Return: java.lang.Object
     */
    @RequestMapping(value = "/deleteStaff.htm", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteStaffById(Integer id) {

        Map<String, Object> map = new HashMap<>();

        Map<String, Object> params = new HashMap<>();

        params.put("id", id);

        try {

            int conut = staffService.deleteStaffById(params);

            map.put("success", true);

            map.put("message", "删除成员信息成功");

        } catch (Exception e) {

            e.printStackTrace();

            map.put("success", false);

            map.put("message", "删除成员信息失败" + e);
        }

        return map;
    }


    @RequestMapping("/updatePassword.htm")
    @ResponseBody
    public Object updatePassword(HttpSession session) {

        Map<String, Object> map = new HashMap<>();

        Staff staff = (Staff) session.getAttribute(Constants.USER_SESSION);

        String staffCode = staff.getStaffCode();

        try {

            Staff staffPassword = staffService.login(staffCode);

            map.put("result", staffPassword);

            map.put("message", "查询员工密码成功");

            map.put("success", true);

        } catch (Exception e) {

            map.put("message", "查询员工密码失败");

            map.put("success", false);
        }

        return map;

    }

}
