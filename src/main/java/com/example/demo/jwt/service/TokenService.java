package com.example.demo.jwt.service;

import com.example.demo.dto.User;

/***
 add by xiadongming on 2020/5/4
 **/
public interface TokenService {

    public String getToken(User user);
}
