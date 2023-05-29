package com.blueocean.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blueocean.beans.OptionBean;
import com.blueocean.beans.RocketBean;
import com.blueocean.mapper.RocketMapper;

@Repository
public class RocketDao {

	@Autowired
	private RocketMapper rocketMapper;
	
	public List<RocketBean> getRocketList(){
		return rocketMapper.getRocketList();
	}
	
	public RocketBean rocketReserveInfo(int rocket_idx) {
		return rocketMapper.rocketReserveInfo(rocket_idx);
	}
	
	
	//옵션등록 
	public void reserveOption(OptionBean optionBean) {
		 rocketMapper.reserveOption(optionBean);
	}
		
}


