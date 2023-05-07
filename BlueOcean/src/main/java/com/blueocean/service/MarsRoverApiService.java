package com.blueocean.service;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blueocean.response.AsteroidsApiResponse;
import com.blueocean.response.MarsRoverApiResponse;

//컨트롤러가 똑같은 기능을 해야한다면 , service로 그 동작들을 뺄 수 있음 
@Service
public class MarsRoverApiService {
	
	private String apiKey = "te7D0y8ycuRMsbRupHfZKL4ISLqp1Txm0VzaeNs1";
	
	//rover api
	public MarsRoverApiResponse getRoverData(Integer marsSol) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol="+marsSol+"&api_key="+apiKey, MarsRoverApiResponse.class);
		return response.getBody();
	}
	
	//날짜계산
	public long diffDays() {
		Date today = new Date(); 
		Calendar arrivalDays = Calendar.getInstance();
		arrivalDays.set(2012,7,6);
		Date arrival = arrivalDays.getTime();
		long differ = (today.getTime()-arrival.getTime())/86400000;
		return Math.abs(differ);
		

	}
		
	//소행성 
	public AsteroidsApiResponse getAsteroids() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<AsteroidsApiResponse> response= rt.getForEntity("https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key="+apiKey, AsteroidsApiResponse.class);
		
		return response.getBody();
		
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
