package com.blueocean.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blueocean.beans.UserBean;
import com.blueocean.validator.UserValidator;

@RequestMapping("/user")
@Controller
public class UserController {


	/*회원가입*/
	@GetMapping("/join")
	public String register(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
	}
	
	
	//BindingREsult : 요효성 결과를 담고 있음 
	
	@PostMapping("/join_pro")
	public String join_pro(@Validated @ModelAttribute("joinUserBean") UserBean joinUserBean,BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/join";
		}
		
		return "user/join_success";
	}
	
	/*정보수정*/
	@GetMapping("/modify")
	public String modify() {
		
		return "user/modify";
	}
	
	/*로그인*/
	@GetMapping("/login")
	public String login(Model model) {
		return "user/login";
	}
	
	/*로그아웃*/
	@GetMapping("/logout")
	public String logout() {
		return "user/logout";	
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
		
		
	}
	
	
}
