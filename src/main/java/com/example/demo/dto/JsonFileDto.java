package com.example.demo.dto;

public class JsonFileDto {

    private String key7;
    private String key8;
    private String key9;

    public String getKey7() {
        return key7;
    }

    public String getKey8() {
        return key8;
    }

    public String getKey9() {
        return key9;
    }

    public void setKey7(String key7) {
        this.key7 = key7;
    }

    public void setKey8(String key8) {
        this.key8 = key8;
    }

    public void setKey9(String key9) {
        this.key9 = key9;
    }

    @Override
    public String toString() {
        return "JsonFileDto{" +
                "key7='" + key7 + '\'' +
                ", key8='" + key8 + '\'' +
                ", key9='" + key9 + '\'' +
                '}';
    }
}
