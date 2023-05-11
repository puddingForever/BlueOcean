package com.blueocean.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.blueocean.service.MarsRoverApiService;
import com.blueocean.beans.NasaBean;
import com.blueocean.beans.UserBean;
import com.blueocean.response.MarsRoverApiResponse;
import com.blueocean.response.PlanetArtApiResponse;

@Controller
@RequestMapping("/live")
public class NasaApiController {
	
	@Autowired //bean으로 만들어줌 , new 해줌 
	private MarsRoverApiService roverService;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
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
	
	//우주사진 
	@GetMapping("/live")
	public String getPlanetArt(@ModelAttribute("nasaBean")NasaBean nasaBean ,Model model) {
		
		PlanetArtApiResponse artData = roverService.getArtData();
		model.addAttribute("artData",artData);
		return "nasa/live";
	}
	
	//우주사진 저장 및 보내기 
	@PostMapping("/addArt")
	public String addArtData(,Model model,@RequestParam(value="artPlanet",required=false)String artPlanet) {
		
		roverService.addArtData(artPlanet);
		roverService.getArtData(artPlanet);
		
		String user_id = loginUserBean.getUser_id();
		
		String userName = loginUserBean.getUser_name();
		model.addAttribute("userName",userName);
		model.addAttribute("artPlanet", artPlanet);
	
		return "user/profile";
	}
	
	
	
}
