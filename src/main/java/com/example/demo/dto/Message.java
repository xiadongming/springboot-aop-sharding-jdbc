package com.example.demo.dto;

import java.io.Serializable;

public class Message implements Serializable {

    private  String name;

    private String MessageValue;


    public String getName() {
        return name;
    }

    public String getMessageValue() {
        return MessageValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessageValue(String messageValue) {
        MessageValue = messageValue;
    }
}
