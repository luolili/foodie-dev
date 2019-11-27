package com.luo.controller;

import com.luo.service.StuService;
import com.luo.service.UserService;
import com.luo.utils.JSONResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/get")
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
}
