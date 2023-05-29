package com.blueocean.beans;

import java.sql.Date;

public class CommentBean {
	
	private int comment_idx;
	private int comment_board_idx;
	private String comment_text;
	private String comment_writer;
	private Date comment_date;
	
	public int getComment_idx() {
		return comment_idx;
	}
	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}
	public int getComment_board_idx() {
		return comment_board_idx;
	}
	public void setComment_board_idx(int comment_board_idx) {
		this.comment_board_idx = comment_board_idx;
	}
	public String getComment_text() {
		return comment_text;
	}
	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}
	public String getComment_writer() {
		return comment_writer;
	}
	public void setComment_writer(String comment_writer) {
		this.comment_writer = comment_writer;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	
	

}
