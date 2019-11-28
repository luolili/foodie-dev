package com.luo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ApiIgnore
@RestController
public class HaloController {
    private static final Logger logger = LoggerFactory.getLogger(HaloController.class);
    @RequestMapping("/halo")
    public Object halo() {
        logger.debug("d halo-");
        logger.info("i halo-");
        logger.warn(" w halo-");
        logger.error("e halo-");
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
