package com.blueocean.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.blueocean.beans.NasaBean;

public interface NasaMapper {
	
	//사진저장
	@Insert("insert into pudding.art_table (art_idx,art_url) values (nasa_seq.nextval,#{nasa_url})")
	void addArtData(NasaBean nasaBean);
	

	

}
