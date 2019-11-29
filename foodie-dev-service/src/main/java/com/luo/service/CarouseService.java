package com.luo.service;

import com.luo.pojo.Carousel;
import com.luo.pojo.Users;
import com.luo.pojo.bo.UserBO;

import java.util.List;

public interface CarouseService {
    List<Carousel> queryAll(Integer isShow);

}
