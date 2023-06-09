package com.blueocean.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.blueocean.beans.UserBean;
import com.blueocean.service.UserService;
import com.blueocean.validator.UserValidator;

@RequestMapping("/user")
@Controller
public class UserController {


	@Autowired
	private UserService userService;
	
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	/*회원가입*/
	@GetMapping("/join")
	public String register(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
	}
	
	
	//BindingREsult : 요효성 결과를 담고 있음
	@PostMapping("/join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean,BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/join";
		}
		
		userService.addUserInfo(joinUserBean);
		
		return "user/join_success";
	}
	
	
	/*로그인*/
	@GetMapping("/login")
	public String login(@ModelAttribute("tempLoginUserBean")UserBean tempLoginUserBean,
							@RequestParam(value="fail",defaultValue="false")boolean fail,
							Model model) {
		
		model.addAttribute("fail",fail); //fail이라는 파라메터가 true면 로그인실패창 띄우기
		return "user/login";
	}
	
	@PostMapping("/login_pro")
	public String login_pro(@Valid @ModelAttribute("tempLoginUserBean")UserBean tempLoginUserBean,
						BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/login";
		}
		
		userService.getLoginUserInfo(tempLoginUserBean);
		
		if(loginUserBean.isUserLogin()==true) {
			return "user/login_success";
		}else {
			return "user/login_fail";
		}
	}
	
	/*로그아웃*/
	@GetMapping("/logout")
	public String logout() {
		
		loginUserBean.setUserLogin(false);
		
		return "user/logout";	
	}
	
	
	/*회원 프로필*/
	@GetMapping("/profile")
	public String profile() {
		return "user/profile";
	}
	
	/*정보수정*/
	@GetMapping("/modify")
	public String modify(@ModelAttribute("modifyUserBean") UserBean modifyUserBean) {
		
		userService.getModifyUserInfo(modifyUserBean);
		
		return "user/modify";
	}
	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifyUserBean") UserBean modifyUserBean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/modify";
		}
		
	
		
		return "user/modify_success";
	}
	
	
	@GetMapping("/not_login")
	public String not_login() {
		return "user/not_login";
	}
	
	

	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator validator1 = new UserValidator();
		binder.addValidators(validator1);
		
		
	}
	
	
}
