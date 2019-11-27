package com.luo.controller;

import com.luo.pojo.bo.UserBO;
import com.luo.service.StuService;
import com.luo.service.UserService;
import com.luo.utils.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/usernameExist")
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

    @PostMapping("/regist")
    public JSONResult regist(@RequestBody UserBO userBO) {
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
        userService.createUser(userBO);
        return JSONResult.ok(userBO);
    }


}
