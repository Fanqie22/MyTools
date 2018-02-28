package org.mytools.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mytools.entity.Comments;
import org.mytools.entity.Friends;
import org.mytools.entity.Tidings;
import org.mytools.entity.Weather;
import org.mytools.entity.Zan;
import org.springframework.stereotype.Repository;

@Repository
public interface mainDao {
	// 用户发布动态,插入数据库
	int insertTidings(Tidings tidings);

	// 查询我发布的动态
	List<Tidings> queryTidingsById(@Param("usermail") String usermail);

	// 查询出我的所有好友
	List<String> queryFriends(@Param("usermail") String usermail);

	// 查询最新的10条朋友动态
	List<Tidings> queryTidings(@Param("friends") List<String> friends);

	// 插入朋友的评论
	int insertComments(Comments comments);

	// 查询这条动态的所有评论
	List<Comments> queryComments(@Param("tidingsid") String tidingsid);

	// 查询天气
	Weather queryWeather();

	// 插入点赞记录
	int insertZan(@Param("usermail") String usermail, @Param("tidingsid") String tidingsid);

	// 查询用户赞了的所有的动态的id
	List<Zan> zan(@Param("usermail") String usermail);

	// 点赞数量
	int updateSupport(@Param("tidingsid") String tidings);
}
