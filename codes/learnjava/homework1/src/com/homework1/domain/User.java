package com.homework1.domain;

public class User {
    private int uid;

    private String username;

    private String password;

    private String sex;

    private String address;

    private String introduction;

    private String likes;

    public User(int uid, String username, String password, String sex, String likes,String address, String introduction) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.address = address;
        this.introduction = introduction;
        this.likes = likes;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }
}
