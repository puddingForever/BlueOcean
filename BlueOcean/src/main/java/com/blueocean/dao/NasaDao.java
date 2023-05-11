package com.blueocean.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blueocean.mapper.NasaMapper;

@Repository
public class NasaDao {
	
	@Autowired
	private NasaMapper nasaMapper;
	
	public void addArtData(String url) {
		nasaMapper.addArtData(url);
	}

	public String getArtData(String url) {
		return nasaMapper.getArtData(url);
	}
}
