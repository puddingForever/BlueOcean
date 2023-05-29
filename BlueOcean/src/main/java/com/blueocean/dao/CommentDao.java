package com.blueocean.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blueocean.beans.CommentBean;
import com.blueocean.mapper.CommentMapper;

@Repository
public class CommentDao {

	@Autowired
	private CommentMapper commentMapper;

	//댓글등록
	public void saveComment(CommentBean commentBean) {
		commentMapper.saveComment(commentBean);
	};
	
	//댓글리스트
	public List<CommentBean> commentList(){
		return commentMapper.commentList();
	}
		
	
}
