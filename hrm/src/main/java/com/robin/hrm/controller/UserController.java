package com.robin.hrm.controller;

import com.robin.hrm.domain.User;
import com.robin.hrm.service.HrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理用户请求控制器
 */
@Controller
public class UserController {
    @Autowired
    @Qualifier("hrmService")
    private HrmService hrmService;

    /**
     * 处理登录请求
     * @param loginname
     * @param password
     * @return 试图名
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public User login(@RequestParam("loginname") String loginname, @RequestParam("password") String password) throws Exception {
        User user = hrmService.login(loginname, password);
        return user;
    }

    /**
     * 查询所有用户
     */
    @RequestMapping("/user/all")
    @ResponseBody
    public Object userAll() throws Exception{
        Map<String, Object> params = new HashMap<>();
        List<User> userList = new ArrayList<>();
        userList = hrmService.findUserByParam(params);
        return userList;
    }

    /**
     * 根据参数查询用户
     */
    @RequestMapping("/user/search")
    @ResponseBody
    public Object userSearch(@RequestParam("username") String username) throws Exception {
        Map<String, Object> params = new HashMap<>();
        User user = new User();
        user.setUsername(username);
        params.put("user", user);
        List<User> userList = hrmService.findUserByParam(params);
        return userList;
    }

    /**
     * 修改用户
     */
    @RequestMapping("/user/delete")
    @ResponseBody
    public Boolean userDelete(@RequestParam("id") String id) throws Exception {
        boolean flag = hrmService.deleteUserById(Integer.parseInt(id));
        return flag;
    }

    /**
     * 添加用户
     */
    @RequestMapping("/user/add")
    @ResponseBody
    public Boolean userAdd(@RequestBody User user) {
        Boolean flag = hrmService.addUser(user);
        return flag;
    }

    /**
     * 修改用户
     */
    @RequestMapping("/user/modify")
    @ResponseBody
    public Boolean userModify(@RequestBody User user, @RequestParam("id") String id) {
        user.setId(Integer.parseInt(id));
        Boolean flag = hrmService.updateUser(user);
        return flag;
    }
}
