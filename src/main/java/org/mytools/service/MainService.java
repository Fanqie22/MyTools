package org.mytools.service;

import java.util.List;
import org.mytools.entity.Comments;
import org.mytools.entity.Friends;
import org.mytools.entity.Tidings;
import org.mytools.entity.Weather;
import org.mytools.entity.Zan;

public interface MainService {
	// 用户发布动态,插入数据库
	int insertTidings(Tidings tidings);

	// 查询我发布的动态
	List<Tidings> queryTidingsById(String usermail);

	// 查询出我的所有好友
	List<String> queryFriends(String usermail);

	// 查询最新的10条朋友动态
	List<Tidings> queryTidings(List<String> friends);

	// 插入朋友的评论
	int insertComments(Comments comments);

	// 查询这条动态的所有评论
	List<Comments> queryComments(String tidingsid);

	// 查询天气
	Weather queryWeather();

	// 插入点赞记录
	int insertZan(String usermail, String zantimes, String tidingsid);

	// 是否点赞了
	List<Zan> zan(String usermail);

	// 点赞数量
	int updateSupport(String tidingsid);
}
