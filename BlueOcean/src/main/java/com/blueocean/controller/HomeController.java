package com.blueocean.controller;


import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blueocean.beans.UserBean;


@Controller
public class HomeController {
	

	@Autowired
	ReloadableResourceBundleMessageSource res;

	
	/*메인 페이지*/
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(HttpServletRequest request,Locale locale) {
		
		res.getMessage("label.live", null,locale);
		res.getMessage("label.login", null,locale);
		res.getMessage("label.join", null,locale);
		res.getMessage("label.board", null,locale);
		res.getMessage("label.logout", null,locale);
		res.getMessage("main.title", null,locale);
		res.getMessage("main.name", null,locale);
		res.getMessage("main.one", null,locale);
		res.getMessage("main.two", null,locale);
		
		//System.out.println(request.getServletContext().getRealPath("/"));
		
		return "redirect:/main";
	}
	
	
}

