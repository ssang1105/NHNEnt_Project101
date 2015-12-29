package com.nhnent.repository.entity;

import java.sql.Timestamp;

public class Note {
	
	
	private Long id;
	private String userEmail;
	private String password;
	private String bodyText;
	private Timestamp registeredDate;
	private Timestamp modifiedDate;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBodyText() {
		return bodyText;
	}
	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}
	public Timestamp getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Timestamp registeredDate) {
		this.registeredDate = registeredDate;
	}
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	

}
