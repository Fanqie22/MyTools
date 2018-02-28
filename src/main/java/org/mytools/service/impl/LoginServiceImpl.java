package org.mytools.service.impl;

import org.mytools.dao.UsersDao;
import org.mytools.entity.Users;
import org.mytools.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component @Service @Respon @Controller
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UsersDao usersDao;

	// 日志对象
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public Users loginCheck(String usernumber, String userpassword) {
		// TODO Auto-generated method stub
		// System.out.println("service: " + usernumber);
		return usersDao.loginQuery(usernumber, userpassword);
	}

	@Override
	public int registerInert(Users users) {
		// TODO Auto-generated method stub
		int bools = usersDao.registerInsert(users);
		if (bools != 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String queryMailById(String usermail) {
		// TODO Auto-generated method stub
		String bools = usersDao.queryMailById(usermail);
		// System.out.println("serviceimpl : bools = "+bools);
		if (bools != null) {
			return "0";
		} else {
			return "1";
		}
	}

	@Override
	public Users queryAllById(String usermail) {
		return usersDao.queryAllById(usermail);
	}

}
