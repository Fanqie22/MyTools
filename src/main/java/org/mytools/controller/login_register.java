package org.mytools.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mytools.entity.Comments;
import org.mytools.entity.Tidings;
import org.mytools.entity.Users;
import org.mytools.javas.SendMail;
import org.mytools.service.LoginService;
import org.mytools.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("/MyTools")
public class login_register {

	@Autowired
	private LoginService loginService;
	@Autowired
	private MainService mainService;

	// 处理未登录/已登录用户的登录注册请求
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, Model model) {
		System.out.println("用户请求已传到后台!");
		String usermail = request.getParameter("usermail");
		String userpassword = request.getParameter("userpassword");
		System.out.println("用户信息 :" + usermail + userpassword);
		if (usermail == null || userpassword == null) {
			System.out.println("用户尚未登录");
			return "login";
		} else {
			System.out.println("用户尝试登录");
			Users users = loginService.loginCheck(usermail, userpassword);
			if (users == null) {
				return "login";
			} else {
				model.addAttribute("users",users);
				request.getSession().setAttribute("users", users);
				return "forward:main";
			}

		}
	}

	// 处理用户注册
	@RequestMapping(value = "/register")
	public String register(HttpServletRequest request, Model model) {
		System.out.println("用户注册请求已传到后台!");
		Users users = new Users();
		users.setUsermail(request.getParameter("usermail"));
		users.setUserpassword(request.getParameter("userpassword"));
		users.setUsername("Username");
		String code = request.getParameter("code");
		int bools = loginService.registerInert(users);
		if (bools == 1) {
			return "login";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "/mailcheck")
	@ResponseBody
	public String mailcheck(String mail) {
		System.out.println("这里是邮箱验证!   " + mail);
		SendMail sendMail = new SendMail();
		int randNum = 1 + (int) (Math.random() * ((999999 - 1) + 1));
		String codes = String.valueOf(randNum);
		boolean bool = sendMail.sendmail(codes, mail);
		// model.addAttribute("codes", codes);
		System.out.println("邮件已经成功发送!");
		return codes;
	}

	// 验证邮箱是否已经注册
	@RequestMapping(value = "/mailnumcheck")
	@ResponseBody
	public String mailnumcheck(String mail) {
		System.out.println("这里是查询邮箱是否已经注册!   " + mail);
		String bools = loginService.queryMailById(mail);
		if (bools == "1")
			return "1";
		else
			return "0";
	}
}
