package org.mytools.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mytools.entity.Comments;
import org.mytools.entity.Friends;
import org.mytools.entity.Tidings;
import org.mytools.entity.Users;
import org.mytools.service.LoginService;
import org.mytools.service.MainService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，这样junit在启动时就会加载spring容器 并且告诉junit spring配置文件的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring的配置文件
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class UserDaoTest {
	// 注入Dao实现类依赖
	@Resource
	private UsersDao usersDao;
	@Resource
	private LoginService loginService;
	@Resource
	private MainService mainService;

	// 测试查询评论t
	@Test
	public void queryComments() {
		List<Comments> comments = mainService.queryComments("1");
		System.out.println("-->" + comments);
	}

	// 测试插入评论t
	@Test
	public void insertComment() {
		Comments comments = new Comments();
		comments.setComment("这是测试来的: 你在哪里?");
		comments.setTidingsid("1");
		comments.setUsermail("731856222@qq.com");
		comments.setCommentdate(new Timestamp(System.currentTimeMillis()));
		int bools = mainService.insertComments(comments);
		System.out.println("insertComment :" + bools);
	}

	// 测试查找我的朋友的动态 10条t
	@Test
	public void queryTidingTest() {
		List<String> friends = mainService.queryFriends("1393203396@qq.com");
		List<Tidings> tidings = mainService.queryTidings(friends);
		System.out.println(tidings);
	}

	// 测试查找我的朋友t
	@Test
	public void queryFriends() {
		List<String> friends = new ArrayList<>();
		friends = mainService.queryFriends("1393203396@qq.com");
		for (int i = 0; i < friends.size(); i++) {
			System.out.println("Test myfriends: " + friends.get(i));
		}
	}

	// 测试查询我发布的朋友圈是否成功t
	@Test
	public void queryTidingsTest() {
		List<Tidings> tidings = mainService.queryTidingsById("1393203396@qq.com");
		System.out.println(tidings);
	}

	@Test
	// 测试插入朋友圈是否成功t
	public void TidingsTest() {
		Tidings tidings = new Tidings();
		tidings.setTidingsid("1");
		tidings.setTidings("这是一个测试来的");
		tidings.setUsermail("1393203396@qq.com");
		tidings.setUsername("番茄");
		tidings.setSenddate(new Timestamp(System.currentTimeMillis()));
		System.out.println(tidings.getSenddate());
		int bools = mainService.insertTidings(tidings);
		System.out.println("test : bools---->" + bools);
		System.out.println(tidings);
	}

	@Test
	public void loginQueryTest() {
		Users users = usersDao.loginQuery("1", "123");
		System.out.println("loginQuery test success! " + users);
	}

	@Test
	public void queryAllTestById() {
		Users listusers = usersDao.queryAllById("1");
		System.out.println(listusers);
	}

	@Test
	public void testlogin() {
		String usernumber = "MY";
		String userpassword = "pswss";
		loginService.loginCheck(usernumber, userpassword);
		System.out.println("massage :   username :" + usernumber + "userpassword :" + userpassword);
		// return "login";
	}
}
