package com.luo.service.impl;

import com.luo.mapper.StuMapper;
import com.luo.pojo.Stu;
import com.luo.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper  stuMapper;
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Stu getStuIfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Override
    public Stu saveStu(Stu stu) {
        return null;
    }

    @Override
    public Stu updateStu(int id) {
        return null;
    }

    @Override
    public Stu deleteStu(int id) {
        return null;
    }
}
