package com.entity;

public class User {
    private Integer userid;
    private String username;
    private String password;
    private String phone;
    
	public User(Integer userid, String username, String password, String phone) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.phone = phone;
	}
	public User(String username, String password, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the userid
	 */
	public Integer getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
    
}
