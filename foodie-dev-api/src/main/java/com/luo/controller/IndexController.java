package com.luo.controller;

import com.luo.enums.YesOrNo;
import com.luo.pojo.Carousel;
import com.luo.pojo.Category;
import com.luo.service.CarouseService;
import com.luo.service.CategoryService;
import com.luo.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Api(tags = {"首页api"}, value = "首页")
@RestController
@RequestMapping("index")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private CarouseService carouseService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图", httpMethod = "GET")
    @GetMapping("/carousel")
    public JSONResult queryAll() {
        List<Carousel> carousels = carouseService.queryAll(YesOrNo.YES.type);
        return JSONResult.ok(carousels);
    }

    @ApiOperation(value = "获取一级分类", notes = "获取一级分类", httpMethod = "GET")
    @GetMapping("/cats")
    public JSONResult queryRootLevelCat() {
        List<Category> categoryList = categoryService.queryAllRootLevelCat();
        return JSONResult.ok(categoryList);
    }


}
