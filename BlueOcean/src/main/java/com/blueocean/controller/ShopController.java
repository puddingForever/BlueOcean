package com.blueocean.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blueocean.beans.OptionBean;
import com.blueocean.beans.RocketBean;
import com.blueocean.beans.UserBean;
import com.blueocean.service.RocketService;

@RequestMapping("/shop")
@Controller
public class ShopController {
	
	@Autowired
	private RocketService rocketService;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	//예약메인 페이지 
	@GetMapping("/reserveMain")
	public String reserveMain(Model model) {
		 List<RocketBean> rocketList =  rocketService.getRocketList();
		 model.addAttribute("rocketList",rocketList);
		 System.out.println(rocketList);
		return "shop/reserveMain";
	}
	
	//예약상세페이지 
	@GetMapping("/rocketReserveInfo")
	public String rocketReserveInfo(@RequestParam("rocket_idx")int rocket_idx,Model model) {
		RocketBean rocketReserveInfo = rocketService.rocketReserveInfo(rocket_idx);
		model.addAttribute("rocketReserveInfo",rocketReserveInfo);
		String user_name = loginUserBean.getUser_name();
		model.addAttribute("user_name",user_name);
		return "shop/rocketReserveInfo";
	}
	
	//예약옵션 페이지
	@GetMapping("/rocketOption")
	public String rocketOption(@ModelAttribute("optionBean")OptionBean optionBean) {
	
		
		return "shop/rocketOption";
	}
	
	//예약옵션 등록
	@PostMapping("/reserveOption")
	public String reserveOption(@RequestParam("rocket_idx")int rocket_idx,@ModelAttribute("OptionBean")OptionBean optionBean,Model model) {
		
		rocketService.reserveOption(optionBean);	
		model.addAttribute("rocket_idx", rocket_idx);
		return "shop/reserve_success";
	}
	
	
	//총 예약 확인
	@GetMapping("confirmTotalInfo")
	public String confirmTotalInfo(@RequestParam("confirmTotalInfo")HashMap<String,Integer> totalPrice,Model model) {
		
		
		model.addAttribute("totalPrice", totalPrice);
		return "shop/confirmTotalInfo";
		
	}
	
	

}
