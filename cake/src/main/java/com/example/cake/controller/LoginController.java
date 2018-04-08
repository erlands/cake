package com.example.cake.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cake.entity.User;
import com.example.cake.service.UserService;
import com.example.cake.utils.MD5Utils;

@Controller
public class LoginController {

	@RequestMapping("/list")
	@ResponseBody
	public List<User> list(){
		return this.userService.list();
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(String username,String password,Model model,
						HttpServletRequest request,HttpServletResponse response) {
		User user = userService.findByUsername(username);
		if(user == null) {
			model.addAttribute("errMsg", "用户不存在!");
			return "login";
		}
		
		password =MD5Utils.enCoding(password);
		if(!user.getPassword().equals(password)) {
			model.addAttribute("errMsg", "密码错误!");
			return "login";
		}
		
		request.getSession().setAttribute("user", user);
		
		return "redirect:/admin/index";
	}
	
	@Autowired
	private UserService userService;
}
