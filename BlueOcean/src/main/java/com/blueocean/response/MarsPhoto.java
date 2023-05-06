package com.blueocean.response;


public class MarsPhoto {

	private String img_src;

	public String getImg_src() {
		return img_src;
	}

	public void setImg_src(String imgSrc) {
		this.img_src = imgSrc;
	}

	@Override
	public String toString() {
		return "MarsPhoto [img_src=" + img_src + "]";
	}

}
