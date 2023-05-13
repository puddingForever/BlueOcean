package com.blueocean.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blueocean.beans.NasaBean;
import com.blueocean.mapper.NasaMapper;

@Repository
public class NasaDao {
	
	@Autowired
	private NasaMapper nasaMapper;
	
	public void addArtData(NasaBean nasaBean) {
		nasaMapper.addArtData(nasaBean);
	}

}
