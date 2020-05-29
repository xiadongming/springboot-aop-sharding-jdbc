package com.example.demo.dao;

import com.example.demo.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
 add by xiadongming on 2020/5/3
 **/
import org.apache.ibatis.annotations.Mapper;
@Repository
public interface UserInfoMapper {

    List<User> queryList();

    User getByName(@Param(value = "userName")String userName);

    User getById(String userId);
}
