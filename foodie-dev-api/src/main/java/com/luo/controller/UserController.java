package com.luo.controller;

import com.luo.pojo.Users;
import com.luo.pojo.bo.UserBO;
import com.luo.service.UserService;
import com.luo.utils.CookieUtils;
import com.luo.utils.JSONResult;
import com.luo.utils.JsonUtils;
import com.luo.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = {"注册api"}, value = "注册")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "验证用户名是否存在", notes = "验证用户名是否存在n", httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public JSONResult usernameIsExist(@RequestParam String username) {
        if (StringUtils.isBlank(username)) {
            return JSONResult.errorMsg("用户名 不能为空");
        }
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return JSONResult.errorMsg("用户名 已存在");
        }
        return JSONResult.ok();
    }

    @ApiOperation(value = "用户注册", notes = "用户注册n", httpMethod = "POST")
    @PostMapping("/regist")
    public JSONResult regist(@RequestBody UserBO userBO, HttpServletRequest req, HttpServletResponse resp) {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();
        //用户名，密码不可谓空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(confirmPassword)) {
            return JSONResult.errorMsg("用户名 /密码不能为空");
        }
        //用户名是否存在
        boolean isExist = userService.queryUsernameIsExist(username);
        if (isExist) {
            return JSONResult.errorMsg("用户名 已存在");
        }
        //密码长度
        if (password.length() < 6) {
            return JSONResult.errorMsg("密码长度 小于6");
        }
        //2次密码是否一样
        if (!password.equals(confirmPassword)) {
            return JSONResult.errorMsg("2次密码否一样");
        }
        Users userResult = userService.createUser(userBO);

        setNullProperty(userResult);
        CookieUtils.setCookie(req, resp, "user",
                JsonUtils.objectToJson(userResult), true);

        return JSONResult.ok(userBO);
    }

    @ApiOperation(value = "用户登陆", notes = "用户登陆", httpMethod = "POST")
    @PostMapping("/login")
    public JSONResult login(@RequestBody UserBO userBO, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        //用户名，密码不可谓空
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return JSONResult.errorMsg("用户名 /密码不能为空");
        }
        Users userResult = userService.queryUserForLogin(username, MD5Utils.getMD5Str(password));
        if (userResult == null) {
            return JSONResult.errorMsg("用户名 /密码错误");
        }
        setNullProperty(userResult);
        CookieUtils.setCookie(req, resp, "user",
                JsonUtils.objectToJson(userResult), true);

        return JSONResult.ok(userResult);


    }

    @ApiOperation(value = "用户退出登陆", notes = "用户退出登陆", httpMethod = "POST")
    @PostMapping("/logout")
    public JSONResult logout(@RequestParam String userId, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        CookieUtils.deleteCookie(req, resp, "user");

        return JSONResult.ok();


    }

    private Users setNullProperty(Users userResult) {
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        return userResult;
    }

}
