package org.mytools.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mytools.entity.Comments;
import org.mytools.entity.Tidings;
import org.mytools.entity.Users;
import org.mytools.entity.Weather;
import org.mytools.entity.Zan;
import org.mytools.service.LoginService;
import org.mytools.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
@RequestMapping("/MyTools")
public class MainController {
	@Autowired
	private MainService mainService;
	@Autowired
	private LoginService loginService;

	// private static String umail = null;

	// 这是登陆之后的我的首页的服务
	@RequestMapping(value = "/main")
	public String mains(HttpSession httpSession, HttpServletRequest request, Model model) {// @ModelAttribute("usermails")
		Users users = (Users) httpSession.getAttribute("users");
		// String usermails) {
		// System.out.println("转发到main服务!" + usermails);
		// String usermail = request.getParameter("usermail");
		// if (usermail != null)
		// umail = usermail;

		System.out.println("这里是main服务!" + users.getUsermail() + "---");
		// if (umail != null) {
		// usermail = umail;
		// }
		if (users.getUsermail() == null) {
			System.out.println("用户未登录 ,直接请求无效!");
			return "login";
		} else {
			// if (usermail == null || usermail.length() == 0) {
			// usermail = usermails;
			// } else {
			// usermails = usermail;
			// }
			// users.setUsermail(usermail);
			Users user = loginService.queryAllById(users.getUsermail());
			System.out.println("user /////////////>" + user);

			// model.addAttribute("users", users);
			List<String> friends = mainService.queryFriends(users.getUsermail());
			friends.add(users.getUsermail());
			List<Tidings> tidings = mainService.queryTidings(friends);
			List<Comments> comment = new ArrayList<Comments>();
			List<Comments> comments = new ArrayList<Comments>();
			Weather weather = mainService.queryWeather();
			List<Zan> zan = mainService.zan(users.getUsermail());
			for (Tidings tid : tidings) {
				comment = (mainService.queryComments(tid.getTidingsid()));
				comments.addAll(comment);
			}
			model.addAttribute("comments", comments);
			model.addAttribute("tidings", tidings);
			model.addAttribute("weather", weather);
			model.addAttribute("users", user);
			model.addAttribute("zan", zan);
			//System.out.println("tiddddddddddddddddddd---->"+tidings);
			return "main";

		}

	}

	// 这里的服务用语用户发布动态
	@RequestMapping(value = "/sendTidings")
	public String mailnumcheck(HttpServletRequest request, RedirectAttributes model) {
		// Users users = (Users) httpSession.getAttribute("users");
		String usermail = request.getParameter("usermail");
		String tiding = request.getParameter("tiding");
		String username = request.getParameter("username");
		System.out.println("这里是sengtiding 服务 :" + usermail + tiding + username);
		Tidings tidings = new Tidings();
		tidings.setUsermail(usermail);
		tidings.setUsername(username);// TODO 用户详细表
		tidings.setUsericon("");// TODO

		tidings.setSenddate(new Timestamp(System.currentTimeMillis()));
		tidings.setTidings(tiding);
		String[] mails = tidings.getUsermail().split("@");
		int randint = new Random().nextInt(99);
		String days = new SimpleDateFormat("mmss").format(Calendar.getInstance().getTime());

		String ran = String.valueOf(randint);
		String ids = mails[0] + days + ran;
		// tidings.setTidingsid(mails[0] + tidings.getSenddate());//
		tidings.setTidingsid(ids);
		int bools = mainService.insertTidings(tidings);
		model.addFlashAttribute("usermails", usermail);

		if (bools != 0)
			return "redirect:main";
		else
			return "redirect:main";
	}

	@RequestMapping(value = "/zan")
	public String zan(String usermail, Double tidingsidd) {
		BigDecimal bd = new BigDecimal(tidingsidd);
		String tidingsid = bd.toPlainString();
		if (usermail == null || tidingsid == null || usermail == "" || tidingsid == "" || usermail.length() == 0) {
			System.out.println("/zan : 为空!");
			return "forward:main";
		} else {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String zantimes = df.format(System.currentTimeMillis());
			mainService.insertZan(usermail, zantimes, tidingsid);
			mainService.updateSupport(tidingsid);
			return "forward:main";
		}
	}

	@RequestMapping(value = "/sendComments")
	public String Comments(String usermail,String mycomments,String username,String tidingsid) {
		//String usermail = request.getParameter("usermail");
		//String mycomments = request.getParameter("mycomments");
		//String username = request.getParameter("username");
		//String tidingsid = request.getParameter("comment-tid");
		System.out.println("这里是mycomments 服务 :" + usermail + mycomments + username+"tidingid: "+tidingsid);
		Comments comments = new Comments();
		comments.setComment(mycomments);
		comments.setCommentdate(new Timestamp(System.currentTimeMillis()));
		comments.setTidingsid(tidingsid);
		comments.setUsermail(usermail);
		comments.setUsername(username);
		mainService.insertComments(comments);
		return "redirect:main";
	}

}
