package com.luo.service.impl;

import com.luo.enums.Sex;
import com.luo.mapper.UsersMapper;
import com.luo.pojo.Users;
import com.luo.pojo.bo.UserBO;
import com.luo.service.UserService;
import com.luo.utils.DateUtil;
import com.luo.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", username);

        Users result = usersMapper.selectOneByExample(userExample);

        return !(result==null);
    }

    @Override
    @Transactional
    public Users createUser(UserBO userBO) {
        Users user = new Users();
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //默认
        user.setNickname(userBO.getUsername());
        user.setFace("");
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
user.setSex(Sex.secret.type);
        return user;
    }
}
