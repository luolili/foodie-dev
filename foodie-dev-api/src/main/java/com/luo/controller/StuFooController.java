package com.luo.controller;

import com.luo.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuFooController {
    @Autowired
    private StuService stuService;
    @GetMapping("/get")
    public Object halo(int id) {


        return stuService.getStuIfo(id);
    }
}
