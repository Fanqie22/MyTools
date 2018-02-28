package org.mytools.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mytools.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao {
	// 用于登录查询
	Users loginQuery(@Param("usermail") String usermail, @Param("userpassword") String userpassword);

	// 用于查询所有符合条件的用户的信息
	Users queryAllById(@Param("usermail") String usermail);

	String queryMailById(@Param("usermail") String usermail);

	// 用于用户注册
	int registerInsert(Users users);
}
