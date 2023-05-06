package com.blueocean.mapper;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	@Select("select user_name "
			+ "from pudding.user_table "
			+ "where user_id = #{user_id}")
	String checkUserIdExist(String user_id);
	
}
