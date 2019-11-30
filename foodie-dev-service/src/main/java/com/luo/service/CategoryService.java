package com.luo.service;

import com.luo.pojo.Carousel;
import com.luo.pojo.Category;
import com.luo.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryService {
    List<Category> queryAllRootLevelCat();

    List<CategoryVO> getSubCatList(Integer rootCatId);

    List getSixNewItemsLazy(Integer rootCatId);

}
