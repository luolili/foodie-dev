package com.luo.service;

import com.luo.pojo.Stu;

public interface StuService {
    Stu getStuIfo(int id);
    Stu saveStu(Stu stu);
    Stu updateStu(int id);
    Stu deleteStu(int id);
}
