package com.example.demo.dto;

/***
 add by xiadongming on 2020/5/6
 **/
public class ExcelDTO {

    private String pathology;

    private String sex;
    private String age;
    private String pathologyResult;
    private String finalResult;

    public void setPathology(String pathology) {
        this.pathology = pathology;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPathologyResult(String pathologyResult) {
        this.pathologyResult = pathologyResult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }

    public String getPathology() {
        return pathology;
    }

    public String getSex() {
        return sex;
    }

    public String getAge() {
        return age;
    }

    public String getPathologyResult() {
        return pathologyResult;
    }

    public String getFinalResult() {
        return finalResult;
    }

    @Override
    public String toString() {
        return "ExcelDTO{" +
                "pathology='" + pathology + '\'' +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", pathologyResult='" + pathologyResult + '\'' +
                ", finalResult='" + finalResult + '\'' +
                '}';
    }
}
