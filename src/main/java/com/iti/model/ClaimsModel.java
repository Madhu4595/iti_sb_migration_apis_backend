package com.iti.model;

public class ClaimsModel {
	
	
	private String username;
	private String roleId;
	private String insCode;
	public ClaimsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClaimsModel(String username, String roleId, String insCode) {
		super();
		this.username = username;
		this.roleId = roleId;
		this.insCode = insCode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getInsCode() {
		return insCode;
	}
	public void setInsCode(String insCode) {
		this.insCode = insCode;
	}
	@Override
	public String toString() {
		return "ClaimsModel [username=" + username + ", roleId=" + roleId + ", insCode=" + insCode + "]";
	}
	
	
	
}
