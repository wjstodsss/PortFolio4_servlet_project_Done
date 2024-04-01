package com.blacksmith.banchan.admin.dto;


public class AdminVO {
	private Integer code;
	private String adminName;
	private String adminId;
	private String adminPassword;
	private String adminEmail;
	private String adminPhone;
	private Integer admin;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "AdminVO [code=" + code + ", adminName=" + adminName + ", adminId=" + adminId + ", adminPassword="
				+ adminPassword + ", adminEmail=" + adminEmail + ", adminPhone=" + adminPhone + ", admin=" + admin
				+ "]";
	}
	

}
