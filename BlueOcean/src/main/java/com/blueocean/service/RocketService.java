package com.blueocean.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueocean.beans.OptionBean;
import com.blueocean.beans.RocketBean;
import com.blueocean.dao.RocketDao;


@Service
public class RocketService {

	HashMap<String, Integer> totalPrice = null;
	
	@Autowired
	private RocketDao rocketDao;
	
	//로켓리스트
	public List<RocketBean> getRocketList(){	
		return rocketDao.getRocketList();
	}
	
	//로켓정보
	public RocketBean rocketReserveInfo(int rocket_idx) {
		return rocketDao.rocketReserveInfo(rocket_idx);
	}
	
	//옵션등록 
	public void reserveOption(OptionBean optionBean) {
		
		/*보험사 가격*/
		int ins_price = 0;
		//보험
		switch(optionBean.getOption_insurance()) {
		case "axa" : ins_price = 10000;
						break;
		case "sky" : ins_price = 20000;
						break;
		case "sea" : ins_price = 30000;
						break;
		case "spacetrip" : ins_price = 40000;
						break;
		case "spaceforever" : ins_price = 50000;
						break;
		default : ins_price = 0;
				break;
		}
		
		/*가이드*/
		int guide_price = 0;
		
		switch(optionBean.getOption_guide()) {
		case "hire" : guide_price = 20000;
						break;
		case "notUse" : guide_price=0;
						break;
		default : guide_price = 0;
					break;
		}
		
		/*식사*/
		int food_price = 0;		
		switch(optionBean.getOption_food()) {
		case "korean" : food_price = 10000;
						break;
		case "western" : food_price = 20000;
						break;
		case "vege" : food_price = 30000;
						break;
		case "notUse" : food_price = 0;
		default : food_price = 0;
					break;
		}
		
		//HashMap에 담아서 보냄 
		totalPrice = new HashMap<>();
		totalPrice.put("insurance", ins_price);
		totalPrice.put("guide",guide_price);
		totalPrice.put("food", food_price);	
		
		//옵션저장
		rocketDao.reserveOption(optionBean);

	}
	
	
	

	
}
