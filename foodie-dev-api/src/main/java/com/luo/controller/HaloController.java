package com.luo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HaloController {
    @RequestMapping("/halo")
    public Object halo() {
        return "halo";
    }
}
