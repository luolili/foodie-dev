package com.luo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class HaloController {
    @RequestMapping("/halo")
    public Object halo() {
        return "halo";
    }
}
