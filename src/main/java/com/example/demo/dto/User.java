package com.example.demo.dto;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;
    private String passWord;
    private String userName;
    private String phNum;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhNum() {
        return phNum;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", passWord='" + passWord + '\'' +
                ", userName='" + userName + '\'' +
                ", phNum='" + phNum + '\'' +
                '}';
    }
}
