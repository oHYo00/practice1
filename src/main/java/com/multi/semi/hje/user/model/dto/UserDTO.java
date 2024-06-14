package com.multi.semi.hje.user.model.dto;

import java.sql.Date;

public class UserDTO {

	private String userId;
	private String pw;
	private String name;
	private String phone;
	private Date createdDate;
	private String isDeleted;
	private Date delDate;

	public UserDTO() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getDelDate() {
		return delDate;
	}

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", createdDate="
				+ createdDate + ", isDeleted=" + isDeleted + ", delDate=" + delDate + "]";
	}

}
