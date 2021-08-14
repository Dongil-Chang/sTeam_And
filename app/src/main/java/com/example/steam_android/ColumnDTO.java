package com.example.steam_android;

public class ColumnDTO {
    String name , phonenum;
    int age, resid;

    public ColumnDTO(String name, String phonenum, int age, int resid) {
        this.name = name;
        this.phonenum = phonenum;
        this.age = age;
        this.resid = resid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }
}//class

