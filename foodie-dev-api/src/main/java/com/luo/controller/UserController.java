package com.luo.controller;

import com.luo.service.StuService;
import com.luo.service.UserService;
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
    public int userameIsExist(@RequestParam String username) {

        if (StringUtils.isBlank(username)) {
            return 500;
        }
        boolean isExist = userService.queryUsernameIsExist(username);

        if (isExist) {
            return 500;
        }
        return 200;
    }
}
