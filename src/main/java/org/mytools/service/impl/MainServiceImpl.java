package org.mytools.service.impl;

import java.util.List;
import org.mytools.dao.mainDao;
import org.mytools.entity.Comments;
import org.mytools.entity.Friends;
import org.mytools.entity.Tidings;
import org.mytools.entity.Weather;
import org.mytools.entity.Zan;
import org.mytools.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	mainDao mainDao;

	@Override
	public int insertTidings(Tidings tidings) {
		return mainDao.insertTidings(tidings);
	}

	@Override
	public List<Tidings> queryTidingsById(String usermail) {
		return mainDao.queryTidingsById(usermail);
	}

	@Override
	public List<String> queryFriends(String usermail) {
		return mainDao.queryFriends(usermail);
	}

	@Override
	public List<Tidings> queryTidings(List<String> friends) {
		return mainDao.queryTidings(friends);
	}

	@Override
	public int insertComments(Comments comments) {
		return mainDao.insertComments(comments);
	}

	@Override
	public List<Comments> queryComments(String tidingsid) {
		return mainDao.queryComments(tidingsid);
	}

	@Override
	public Weather queryWeather() {
		return mainDao.queryWeather();
	}

	@Override
	public List<Zan> zan(String usermail) {
		return mainDao.zan(usermail);
	}

	@Override
	public int insertZan(String usermail, String zantimes, String tidingsid) {
		return mainDao.insertZan(usermail, zantimes, tidingsid);
	}

	@Override
	public int updateSupport(String tidingsid) {
		return mainDao.updateSupport(tidingsid);
	}

}
