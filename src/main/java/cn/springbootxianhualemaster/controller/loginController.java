package cn.springbootxianhualemaster.controller;



import cn.springbootxianhualemaster.pojo.Staff;
import cn.springbootxianhualemaster.services.StaffService;
import cn.springbootxianhualemaster.util.Constants;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@RestController
public class loginController {
	private Logger logger=Logger.getLogger(loginController.class);
	@Resource
    private StaffService staffService;
    //员工登录
    @RequestMapping(value = "login.htm",method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpSession session, String staffCode, String staffPassword){
        Map<String, Object > map=new HashMap<String, Object>();
        try {
        	Staff staff=staffService.login(staffCode);
            if (staff!=null&&staffPassword.equals(staff.getStaffPassword())) {
                session.setAttribute(Constants.USER_SESSION, staff);
                map.put("result", true);
                map.put("message", "用户编号和密码正确，登录成功");
                map.put("success", true);
            }else if(staff!=null&&!staffPassword.equals(staff.getStaffPassword())) {
                map.put("result", false);
                map.put("message", "密码不正确，请重新输入");
                map.put("success", false);
            }else {
                map.put("result", false);
                map.put("message", "用户编号不存在");
                map.put("success", false);
            }
        } catch (Exception e) {
            map.put("result", false);
            map.put("message", "系统繁忙，请稍后再试");
            map.put("success", false);
        }
        return map;
    }
    //退出登录
    @RequestMapping(value = "logout.htm")
    @ResponseBody
    public Object logout(HttpSession session){
        Map<String,Object> map=new HashMap<String, Object>();
        try {
        	if (session!=null) {
        		session.invalidate();
    			map.put("success", true);
    			map.put("message", "退出正常");
			}else {
				map.put("success", false);
    			map.put("message", "非法退出");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("success", false);
			map.put("message", "退出异常");
		}
        return map;
    }
    //获取登录用户信息
    @RequestMapping(value = "loginInfo.htm")
    @ResponseBody
    public Object loginInfo(HttpSession session){
        Map<String,Object> map=new HashMap<String, Object>();
        try {
            if (session!=null){
                Staff staff=(Staff)session.getAttribute(Constants.USER_SESSION);
                map.put("result",staff);
                map.put("success",true);
                map.put("message","获取用户信息成功");
            }else {
                map.put("success", false);
                map.put("message", "获取用户信息失败");
            }
        }catch (Exception e){
                e.printStackTrace();
                map.put("success", false);
                map.put("message", "服务器繁忙，请稍后再试"+e);
        }
        return map;
    }
}
