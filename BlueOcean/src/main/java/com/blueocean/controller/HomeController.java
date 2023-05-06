package com.blueocean.controller;


import java.util.Locale;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	
	@Autowired
	ReloadableResourceBundleMessageSource res;

	
	/*메인 페이지*/
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Locale locale) {
		
		
		String live = res.getMessage("label.live", null,locale);
		String login = res.getMessage("label.login", null,locale);
		String join = res.getMessage("label.join", null,locale);
		String modify = res.getMessage("label.board", null,locale);
		String logout = res.getMessage("label.logout", null,locale);
		
		return "redirect:/main";
	}
	
	
}

