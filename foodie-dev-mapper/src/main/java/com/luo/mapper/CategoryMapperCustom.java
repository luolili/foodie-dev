package com.luo.mapper;

import com.luo.pojo.vo.CategoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom {

    public List<CategoryVO> getSubCatList(Integer rootCatId);

    //public List<NewItemsVO> getSixNewItemsLazy(@Param("paramsMap") Map<String, Object> map);
}