package org.mytools.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
@RequestMapping("/MyTools")
public class MainController {
	@Autowired
	private MainService mainService;
	@Autowired
	private LoginService loginService;

	// 这是登陆之后的我的首页的服务
	@RequestMapping(value = "/main")
	public String mains(HttpServletRequest request, Model model, @ModelAttribute("usermails") String usermails) {
		System.out.println("这是是main服务!" + usermails);
		String usermail = request.getParameter("usermail");
		if (usermail == null && usermails == null) {
			System.out.println("用户未登录 ,直接请求无效!");
			return "login";
		} else {
			if (usermail == null)
				usermail = usermails;
			else
				usermails = usermail;
			Users users = loginService.queryAllById(usermail);
			if (users == null) {
				return "login";
			} else {
				// model.addAttribute("users", users);
				List<String> friends = mainService.queryFriends(users.getUsermail());
				friends.add(users.getUsermail());
				List<Tidings> tidings = mainService.queryTidings(friends);
				List<Comments> comment = new ArrayList<Comments>();
				List<Comments> comments = new ArrayList<Comments>();
				Weather weather = mainService.queryWeather();
				List<Zan> zan = mainService.zan(usermail);
				for (Tidings tid : tidings) {
					comment = (mainService.queryComments(tid.getTidingsid()));
					comments.addAll(comment);
				}
				model.addAttribute("comments", comments);
				model.addAttribute("tidings", tidings);
				model.addAttribute("weather", weather);
				model.addAttribute("users", users);
				model.addAttribute("zan", zan);
				// System.out.println("zan----->"+zan);
				return "main";
			}

		}

	}

	// 这里的服务用语用户发布动态
	@RequestMapping(value = "/sendTidings")
	public String mailnumcheck(HttpServletRequest request, RedirectAttributes model) {
		String usermail = request.getParameter("usermail");
		String tiding = request.getParameter("tiding");
		String username = request.getParameter("username");
		System.out.println("这是是sengtiding 服务 :" + usermail + tiding + username);
		Tidings tidings = new Tidings();
		tidings.setUsermail(usermail);
		tidings.setUsername(username);// TODO 用户详细表
		tidings.setUsericon("");// TODO
		tidings.setSenddate(new Timestamp(System.currentTimeMillis()));
		tidings.setTidings(tiding);
		String[] mails = tidings.getUsermail().split("@");
		tidings.setTidingsid(mails[0] + tidings.getSenddate());//
		int bools = mainService.insertTidings(tidings);
		model.addFlashAttribute("usermails", usermail);
		// System.out.println("bools ---->" + bools);
		if (bools != 0)
			return "redirect:main";
		else
			return "redirect:main";
	}

	@RequestMapping(value = "/zan")
	public String zan(String usermail, String tidingsid) {
		// System.out.println(" zan : ---->" + usermail + tidingsid);
		if (usermail == null || tidingsid == null) {
			return "forward:main";
		} else {
			mainService.insertZan(usermail, tidingsid);
			mainService.updateSupport(tidingsid);
			return "forward:main";
		}
	}

}
