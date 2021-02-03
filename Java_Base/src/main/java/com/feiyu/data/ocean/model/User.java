package com.feiyu.data.ocean.model;

/**
 * @Author xzhou.James
 * @Date 2020/2/14  9:23
 */
public class User {
    private String user_name;
    private String user_password;
    private String user_sex;

    public User() {

    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }
}
