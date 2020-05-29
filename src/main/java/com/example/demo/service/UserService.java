package com.example.demo.service;

import com.example.demo.dto.User;

import java.util.List;

/***
 add by xiadongming on 2020/5/3
 **/
public interface UserService {

    List<User> queryList();

    User getByName(String userName);

    User getById(String userId);
}
