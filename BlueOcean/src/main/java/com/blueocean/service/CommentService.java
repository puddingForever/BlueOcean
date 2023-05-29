package com.blueocean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueocean.beans.CommentBean;
import com.blueocean.dao.CommentDao;

@Service
public class CommentService {

	
	@Autowired
	private CommentDao commentDao;
	
	//댓글등록
	public void saveComment(CommentBean commentBean) {
		commentDao.saveComment(commentBean);
	}
	
	//댓글리스트
	public List<CommentBean> commentList(){
		return commentDao.commentList();
	}
		
	
}
