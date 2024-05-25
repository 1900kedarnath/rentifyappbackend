package com.rentify.app.model;

public class SignInResponse {

	
private String userType;

private int UserId;
private String msg;



public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

public String getUserType() {
	return userType;
}

public void setUserType(String userType) {
	this.userType = userType;
}

public int getUserId() {
	return UserId;
}

public void setUserId(int userId) {
	UserId = userId;
}


	
}
