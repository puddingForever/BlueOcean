package com.blueocean.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface NasaMapper {
	
	//사진저장
	@Insert("insert into pudding.art_table (art_idx,art_url) values (art_seq.nextval,#{url})")
	void addArtData(String url);
	
	//사진가져오기 
	@Select("select art_url "
			+ "from pudding.art_table ")
	String getArtData(String url);
	
	

}
