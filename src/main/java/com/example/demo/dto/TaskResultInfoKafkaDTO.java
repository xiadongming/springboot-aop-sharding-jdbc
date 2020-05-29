package com.example.demo.dto;

import java.io.Serializable;

public class TaskResultInfoKafkaDTO implements Serializable {

    private String volumn;

    private String  diameter;

    private String semidiameter;

    private String name;

    public void setVolumn(String volumn) {
        this.volumn = volumn;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public void setSemidiameter(String semidiameter) {
        this.semidiameter = semidiameter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVolumn() {
        return volumn;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getSemidiameter() {
        return semidiameter;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TaskResultInfoKafkaDTO{" +
                "volumn='" + volumn + '\'' +
                ", diameter='" + diameter + '\'' +
                ", semidiameter='" + semidiameter + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
