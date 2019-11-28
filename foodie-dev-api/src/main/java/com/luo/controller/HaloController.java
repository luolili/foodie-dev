package com.luo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ApiIgnore
@RestController
public class HaloController {
    @RequestMapping("/halo")
    public Object halo() {
        return "halo";
    }

    @RequestMapping("/setSession")
    public Object setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userIfo", "new user");

        session.setMaxInactiveInterval(3600);//过期时间，0 不过期

        return "halo";
    }


}
