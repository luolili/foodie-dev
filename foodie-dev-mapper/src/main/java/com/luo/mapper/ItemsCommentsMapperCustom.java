package com.luo.mapper;

import com.luo.my.mapper.MyMapper;
import com.luo.pojo.ItemsComments;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsCommentsMapperCustom extends MyMapper<ItemsComments> {

    public void saveComments(Map<String, Object> map);

    //public List<MyCommentVO> queryMyComments(@Param("paramsMap") Map<String, Object> map);

}