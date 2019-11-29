package com.luo.service.impl;

import com.luo.mapper.CategoryMapper;
import com.luo.pojo.Carousel;
import com.luo.pojo.Category;
import com.luo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", 1);
        List<Category> categoryList = categoryMapper.selectByExample(example);

        return categoryList;
    }
}
