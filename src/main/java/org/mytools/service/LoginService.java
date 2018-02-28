package org.mytools.service;

import org.apache.ibatis.annotations.Param;
import org.mytools.entity.Users;

public interface LoginService {
	// 登录校验
	Users loginCheck(String usernumber, String userpassword);

	// 注册
	int registerInert(Users users);

	// 查询邮箱是否已经注册
	String queryMailById(String usermail);

	// 查询用户信息
	Users queryAllById(String usermail);
}
