package com.feiyu.data.excel.jxl;

/**
 * Created by xzhou.James on 2020/2/15
 */
public class Person {

    private String userName;
    private String userAge;
    private String userSex;
    private String userStation;

    public Person() {
    }

    public Person(String userName, String userAge, String userSex, String userStation) {
        this.userName = userName;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userStation = userStation;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserStation() {
        return userStation;
    }

    public void setUserStation(String userStation) {
        this.userStation = userStation;
    }
}