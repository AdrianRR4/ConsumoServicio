package com.dev21.test.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4436990693606432962L;

	private Integer id;
	
	private String userName;
	
	private String mail;
	
	private String city;

	public UserResponse() {}
	
	public UserResponse(Integer id, String userName, String mail, String city) {
		super();
		this.id = id;
		this.userName = userName;
		this.mail = mail;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	

}
