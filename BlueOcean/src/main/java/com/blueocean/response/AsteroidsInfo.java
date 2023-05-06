package com.blueocean.response;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;



public class AsteroidsInfo {

	@JsonProperty("2015-09-07")
	ArrayList<Today> today = new ArrayList<>();

	public ArrayList<Today> getToday() {
		return today;
	}

	public void setToday(ArrayList<Today> today) {
		this.today = today;
	}
	
	
}
