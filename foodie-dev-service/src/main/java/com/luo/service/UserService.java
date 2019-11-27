package com.luo.service;

import com.luo.pojo.Stu;
import com.luo.pojo.Users;
import com.luo.pojo.bo.UserBO;

public interface UserService {
    boolean queryUsernameIsExist(String username);

    Users createUser(UserBO userBO);
}
