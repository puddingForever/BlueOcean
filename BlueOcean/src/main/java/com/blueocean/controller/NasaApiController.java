package com.blueocean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.blueocean.nasa.service.MarsRoverApiService;
import com.blueocean.response.MarsRoverApiResponse;

@Controller
@RequestMapping("/live")
public class NasaApiController {
	
	@Autowired //bean으로 만들어줌 , new 해줌 
	private MarsRoverApiService roverSerivce;
	
	//화성사진
	@GetMapping("/mars")
	public String getMarsRover(Model model) {
		MarsRoverApiResponse roverData = roverSerivce.getRoverData();
		long diff = roverSerivce.diffDays();
		
		int arrSize = roverData.getPhotos().size();
		model.addAttribute("roverData",roverData);
		model.addAttribute("arrSize",arrSize);
		model.addAttribute("diff",diff);
		
		return "nasa/marsPhotos";
	}
	
	//접근 소행성
	@GetMapping("/asteroid")
	public String getAsteroids(Model model) {
		return "nasa/asteroid";
	}
	
	
	//현재 우주에 있는 사람들
	@GetMapping("/astronaut")
	public String getAstronautNum(Model model) {
		RestTemplate rs = new RestTemplate();
		ResponseEntity<String> response = rs.getForEntity("http://api.open-notify.org/astros.json", String.class);	
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		return "nasa/astronaut";
	}
	
	
}
