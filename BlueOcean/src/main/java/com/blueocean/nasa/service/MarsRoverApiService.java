package com.blueocean.nasa.service;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blueocean.response.MarsRoverApiResponse;

//컨트롤러가 똑같은 기능을 해야한다면 , service로 그 동작들을 뺄 수 있음 
@Service
public class MarsRoverApiService {
	
	private String apiKey = "te7D0y8ycuRMsbRupHfZKL4ISLqp1Txm0VzaeNs1";
	
	public MarsRoverApiResponse getRoverData() {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key="+apiKey, MarsRoverApiResponse.class);
		return response.getBody();
	}
	
	
	public long diffDays() {
		Date today = new Date(); 
		Calendar arrivalDays = Calendar.getInstance();
		arrivalDays.set(2012,7,6);
		Date arrival = arrivalDays.getTime();
		long differ = (today.getTime()-arrival.getTime())/86400000;
		return Math.abs(differ);
		

	}
		
	
}
