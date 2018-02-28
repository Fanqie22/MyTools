package org.mytools.entity;

import org.springframework.stereotype.Component;

/** 用户表的实体类 */
@Component
public class Users {
	private String usermail;
	private String username;
	private String userpassword;

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public String toString() {
		return "Users [usermail=" + usermail + ", username=" + username + ", userpassword=" + userpassword + "]";
	}

}
