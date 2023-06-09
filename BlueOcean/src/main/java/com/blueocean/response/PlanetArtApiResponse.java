package com.blueocean.response;


public class PlanetArtApiResponse {

	private String copyright;
	private String date;
	private String explanation;
	private String title;
	private String url;
	
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "PlanetArtApiResponse [copyright=" + copyright + ", date=" + date + ", explanation=" + explanation
				+ ", title=" + title + ", url=" + url + "]";
	}
	
	
	
	
}
