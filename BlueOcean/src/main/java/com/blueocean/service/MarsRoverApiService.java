package com.blueocean.service;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blueocean.beans.NasaBean;
import com.blueocean.dao.NasaDao;
import com.blueocean.response.MarsRoverApiResponse;
import com.blueocean.response.PlanetArtApiResponse;

@Service
public class MarsRoverApiService {
	
	@Autowired
	private NasaDao nasaDao;
	
	private String apiKey = "te7D0y8ycuRMsbRupHfZKL4ISLqp1Txm0VzaeNs1";
		
	//화성사진
	public MarsRoverApiResponse getRoverData(Integer marsSol) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol="+marsSol+"&api_key="+apiKey, MarsRoverApiResponse.class);
		return response.getBody();
	}
	
	//APOD 우주사진
	public PlanetArtApiResponse getArtData() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<PlanetArtApiResponse> response = rt.getForEntity("https://api.nasa.gov/planetary/apod?api_key="+apiKey,PlanetArtApiResponse.class );
		return response.getBody();
	}
	
	//APOD 우주사진 저장
	public void addArtData(NasaBean nasaBean) {
		nasaDao.addArtData(nasaBean);
	}
	
	
	
	
	
	//기타 부가적 기능 
	
	//날짜계산
	public long diffDays() {
		Date today = new Date(); 
		Calendar arrivalDays = Calendar.getInstance();
		arrivalDays.set(2012,7,6);
		Date arrival = arrivalDays.getTime();
		long differ = (today.getTime()-arrival.getTime())/86400000;
		return Math.abs(differ);
		

	}
	
	//오늘 날짜 
	public String today() {
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(nowDate);
		return today;
	}
	//어제 날짜 
	public String yesterday() {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		now.add(Calendar.DATE, -1);
		String yesterday = sdf.format(now.getTime());
		return yesterday;
		
	}
	
}
