package com.blueocean.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.blueocean.beans.OptionBean;
import com.blueocean.beans.RocketBean;

public interface RocketMapper {
	
	@Select("select rocket_idx,rocket_name,rocket_img from rockets")
	List<RocketBean> getRocketList();
	
	
	@Select("select rocket_idx,rocket_name,rocket_price,rocket_usepeople,rocket_company,"
			+ "rocket_nation,rocket_img,rocket_info "
			+ "from rockets " 
			+ "where rocket_idx = #{rocket_idx}")
	public RocketBean rocketReserveInfo(int rocket_idx);
	

	
	
	//옵션등록 
	@Insert("insert into options_table(option_idx,option_insurance,option_guide,option_food,option_req) "
			+ "values(option_seq.nextval,#{option_insurance,jdbcType=VARCHAR},#{option_guide},#{option_food},#{option_req})")
	public void reserveOption(OptionBean optionBean);
	
}
