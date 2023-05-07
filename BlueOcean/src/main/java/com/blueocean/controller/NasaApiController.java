package com.blueocean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.blueocean.service.MarsRoverApiService;
import com.blueocean.response.AsteroidsApiResponse;
import com.blueocean.response.MarsRoverApiResponse;

@Controller
@RequestMapping("/live")
public class NasaApiController {
	
	@Autowired //bean으로 만들어줌 , new 해줌 
	private MarsRoverApiService roverService;
	
	//화성사진
	@GetMapping("/mars")
	public String getMarsRover(Model model,@RequestParam(required=false)Integer marsSol){
		if(marsSol==null || marsSol == 0) {
			marsSol = 50;
		}
		MarsRoverApiResponse roverData = roverService.getRoverData(marsSol);
		long diff = roverService.diffDays();	
		int arrSize = roverData.getPhotos().size();
		model.addAttribute("roverData",roverData);
		model.addAttribute("arrSize",arrSize);
		model.addAttribute("diff",diff);		
		return "nasa/marsPhotos";
	}
	
	//접근 소행성 및 기타 뉴스 
	@GetMapping("/live")
	public String getAsteroids(Model model) {
		
		AsteroidsApiResponse asteroidsData = roverService.getAsteroids();
		String today = roverService.today();
		model.addAttribute("asteroidsData",asteroidsData);
		model.addAttribute("today",today);
		String yesterday = roverService.yesterday();
		model.addAttribute("yesterday",yesterday);
		return "nasa/live";
	}
	

	
	
}
