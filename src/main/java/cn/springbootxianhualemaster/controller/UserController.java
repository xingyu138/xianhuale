package cn.springbootxianhualemaster.controller;


import cn.springbootxianhualemaster.pojo.User;
import cn.springbootxianhualemaster.services.UserService;
import cn.springbootxianhualemaster.util.Constants;
import cn.springbootxianhualemaster.util.PageUtil;
import cn.springbootxianhualemaster.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/page/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("userLogin.htm")
    public Object userLogin(HttpSession session, String userCode, String password) {

        Map<String, Object> map = new HashMap();
        HashMap<String, Object> params = new HashMap<>();
        params.put("userCode", userCode);
        params.put("password", password);

        User user = userService.userLogin(params);

        try {

            if (user != null) {

                session.setAttribute(Constants.USER_SESSION, user);
                map.put("message", "登入成功");
                map.put("success", true);
            } else {
                map.put("message", "登入失败,用户名或验证码不正确");
                map.put("success", false);
            }

        } catch (Exception e) {

            e.printStackTrace();
            map.put("message", "系统正忙");
            map.put("success", false);

        }

        return map;

    }


    /**
     * @Description: 更具条件查询用户信息数量
     * @Author: Rum
     * @Date: 4/15/2019 4:41 PM
     * @Param: [userId, userCode, userName]
     * @Return: java.lang.Object
     */
    @RequestMapping("/getUserListNum.htm")
    @ResponseBody
    public Object getUserListNum(String userId, String userCode, String userName) {

        Map<String, Object> map = new HashMap<>();

        Map<String, Object> params = new HashMap<>();

        params.put("userId", userId);

        params.put("userCode", userCode);

        params.put("userName", userName);

        try {


            int count = userService.getUserNum(params);

            map.put("result", count);

            map.put("message", "查询数量成功");

            map.put("success", true);

        } catch (Exception e) {

            map.put("message", "查询数量失败" + e);

            map.put("success", false);
        }

        return map;

    }

    /**
     * @Description: 查询所有的用户信息
     * @Author: Rum
     * @Date: 5:36 PM
     * @Param: [pageNum, pageSize]
     * @Return: java.lang.Object
     */
    @RequestMapping("/getUserList.htm")
    @ResponseBody
    public Object getUserList(Integer userId, String userCode, String userName, int pageNum, int pageSize) {

        Map<String, Object> params = new HashMap<>(); //存储取得结果

        Map<String, Object> map = new HashMap<>();

        int start = PageUtil.getPageStart(pageNum, pageSize);//获得分页的起始点

        params.put("userId", userId);

        params.put("userName", userName);

        params.put("userCode", userCode);

        params.put("start", start);

        params.put("pageSize", pageSize);

        try {

            List<User> userList = userService.getUserList(params);

            map.put("result", userList);

            map.put("message", "用户列表查询成功");

            map.put("success", true);

        } catch (Exception e) {

            map.put("message", "用户列表查询成功" + e);

            map.put("success", false);

        }

        return map;
    }


    /**
     * @Description: 添加用户
     * @Author: Rum
     * @Date: 4/10/2019 2:17 AM
     * @Param: [userCode, userName, nickName, password, headPic, birthday, age, address, phone, gender, qq, email, paymentPassword, orderUId, creationgDate]
     * @Return: java.lang.Object
     */
    @RequestMapping("addUser.htm")
    @ResponseBody
    public Object addUser(String userCode, String password, String phone, String code) {


        Logger logger=Logger.getLogger("UserController.class");

        Map<String, Object> map = new HashMap<>();

        Map<String, Object> params = new HashMap<>();

        params.put("userCode", userCode);

        params.put("nickName", userCode);

        params.put("password", password);

        params.put("phone", phone);

        params.put("creationgDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));


        try {

            //获取redis中存放的验证码
            String redisCode = redisUtil.get("SMS" + phone);

            logger.info(redisCode);

            if (redisCode != null) {

                if (code.equals(redisCode)) {


                    redisUtil.del("SMS" + phone);
                    redisUtil.del("error_" + phone);

                    int count = userService.addUser(params);

                    map.put("message", "添加用户成功");
                    map.put("success", true);

                    return map;

                } else {

                    Long incr = redisUtil.incr("error_" + phone);

                    if (incr > 3) {  //如果用户错误的次数大于三次
                        //清除旧的验证码
                        redisUtil.del("SMS" + phone);
                        //清除redis中存放的用户输入验证码的错误次数
                        redisUtil.del("error_" + phone);

                        map.put("success", true);
                        map.put("message", "超过验证码错误次数，请重新获取验证码！");

                        return map;
                    } else { //如果用户输入错误且错误小于3次 则刷新一次页面用户继续输入
                        map.put("success", true);
                        map.put("message", "验证码输入错误,请重新输入验证码");

                        return map;
                    }

                }

            }

            map.put("success", true);
            map.put("message", "请先进行验证");

            return map;

        } catch (Exception e) {

            map.put("message", "添加用户失败");

            map.put("success", false);

        }


        return map;

    }

    /**
     * @Description: 修改用户成功
     * @Author: Rum
     * @Date: 4/10/2019 2:17 AM
     * @Param: [userCode, userName, nickName, password, headPic, birthday, age, address, phone, gender, qq, email, paymentPassword, orderUId, creationgDate]
     * @Return: java.lang.Object
     */
    @RequestMapping("updateUser.htm")
    @ResponseBody
    public Object updateUserByuserId(int userId, String userCode, String userName, String nickName, String password, String headPic, Date birthday, Integer age, String address, String phone, String gender, Integer qq, String email, String paymentPassword, Integer orderId) {


        Map<String, Object> map = new HashMap<>();

        Map<String, Object> params = new HashMap<>();

        params.put("userId", userId);

        params.put("userCode", userCode);

        params.put("userName", userName);

        params.put("nickName", nickName);

        params.put("password", password);

        params.put("headPic", headPic);

        params.put("birthday", birthday);

        params.put("address", address);

        params.put("age", age);


        params.put("phone", phone);

        params.put("gender", gender);

        params.put("qq", qq);

        params.put("email", email);

        params.put("paymentPassword", paymentPassword);

        params.put("orderId", orderId);

        params.put("modifyDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        try {

            int count = userService.updateUserByuserId(params);

            map.put("message", "修改成功");

            map.put("success", true);

        } catch (Exception e) {

            map.put("message", "修改失败");

            map.put("success", false);

        }


        return map;

    }


    /**
     * @Description: 根据指定用户id删除指定用户的信息
     * @Author: Rum
     * @Date: 4/10/2019 2:28 AM
     * @Param: [userId]
     * @Return: java.lang.Object
     */
    @RequestMapping("deleteUserByuserId.htm")
    @ResponseBody
    public Object deleteUserByuserId(int userId) {

        Map<String, Object> map = new HashMap<>();

        Map<String, Object> params = new HashMap<>();

        params.put("userId", userId);


        try {

            int count = userService.deleteUserbyuserId(params);

            map.put("message", "删除成功");

            map.put("success", true);


        } catch (Exception e) {


            map.put("message", "删除失败");

            map.put("success", false);


        }

        return map;

    }

}
