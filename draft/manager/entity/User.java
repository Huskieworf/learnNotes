package com.manager.entity;

public class User {

	private int uid;
	
	private String username;
	
	private String password;
	
	private String sex;
	
	private String address;
	
	private String introduce;
	
	private String [] hobbys;

	public User() {
		super();
	}

	public User(int uid, String username, String password, String sex, String address, String introduce,
			String[] hobbys) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.address = address;
		this.introduce = introduce;
		this.hobbys = hobbys;
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

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String[] getHobbys() {
		return hobbys;
	}

	public void setHobbys(String[] hobbys) {
		this.hobbys = hobbys;
	}
	
	
}
