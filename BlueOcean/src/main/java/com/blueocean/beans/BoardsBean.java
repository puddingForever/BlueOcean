package com.blueocean.beans;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public class BoardsBean {
	
	 private int board_idx;
	 @NotBlank
	 private String board_subject;
	 @NotBlank
	 private String board_text;
	 //웹브라우저에서 보내는 파일 데이터를 담음 
	 private MultipartFile upload_file;
	 //서버에 저장되어있는 파일의 이름을 담음 
	 private String board_file;
	 private int board_writer_idx;
	 private String board_date;
	 //작성자
	 private String board_writer_name;
	 
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getBoard_text() {
		return board_text;
	}
	public void setBoard_text(String board_text) {
		this.board_text = board_text;
	}
	public String getBoard_file() {
		return board_file;
	}
	public void setBoard_file(String board_file) {
		this.board_file = board_file;
	}
	public int getBoard_writer_idx() {
		return board_writer_idx;
	}
	public void setBoard_writer_idx(int board_writer_idx) {
		this.board_writer_idx = board_writer_idx;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}
	public MultipartFile getUpload_file() {
		return upload_file;
	}
	public void setUpload_file(MultipartFile upload_file) {
		this.upload_file = upload_file;
	}
	public String getBoard_writer_name() {
		return board_writer_name;
	}
	public void setBoard_writer_name(String board_writer_name) {
		this.board_writer_name = board_writer_name;
	}
	 
	 
}
