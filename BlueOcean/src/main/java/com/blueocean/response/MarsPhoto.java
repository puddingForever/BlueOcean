package com.blueocean.response;


import com.fasterxml.jackson.annotation.JsonProperty;


public class MarsPhoto {

	 private Long id;
	  private Integer sol;
	  private MarsCamera camera;
	  //@JsonProperty(value="img_src")
	  private String img_src;
	  @JsonProperty(value="earth_date")
	  private String earthDate;
	  private MarsRover rover;
	  
	
	 
	  
	  
	  public String getImg_src() {
		return img_src;
	}
	public void setImg_src(String imgSrc) {
		this.img_src = imgSrc;
	}
	public Long getId() {
	    return id;
	  }
	  public void setId(Long id) {
	    this.id = id;
	  }
	  public Integer getSol() {
	    return sol;
	  }
	  public void setSol(Integer sol) {
	    this.sol = sol;
	  }
	  public MarsCamera getCamera() {
	    return camera;
	  }
	  public void setCamera(MarsCamera camera) {
	    this.camera = camera;
	  }
	
	  public String getEarthDate() {
	    return earthDate;
	  }
	  public void setEarthDate(String earthDate) {
	    this.earthDate = earthDate;
	  }
	  public MarsRover getRover() {
	    return rover;
	  }
	  public void setRover(MarsRover rover) {
	    this.rover = rover;
	  }
	  @Override
	  public String toString() {
	    return "MarsPhoto [id=" + id + ", sol=" + sol + ", camera=" + camera + ", imgSrc=" + img_src + "]";
	  }
}
