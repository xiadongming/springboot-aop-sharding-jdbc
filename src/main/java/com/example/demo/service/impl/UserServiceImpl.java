package com.example.demo.service.impl;

import com.example.demo.dto.User;
import com.example.demo.dao.UserInfoMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 add by xiadongming on 2020/5/3
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<User> queryList() {
        List<User> users = userInfoMapper.queryList();
        System.out.println(users);
        return users;
    }

    @Override
    public User getByName(String userName) {
        userInfoMapper.getByName(userName);
        return userInfoMapper.getByName(userName);
    }

    @Override
    public User getById(String userId) {
        return userInfoMapper.getById(userId);
    }
}
