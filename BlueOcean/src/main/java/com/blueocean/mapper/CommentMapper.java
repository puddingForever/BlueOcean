package com.blueocean.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.blueocean.beans.CommentBean;

public interface CommentMapper {
	
	//댓글등록
	@Insert("insert into comments(comment_idx,comment_board_idx,comment_text,comment_writer) "
			+ "values(comment_seq.nextval,#{comment_board_idx},#{comment_text},#{comment_writer})")
	void saveComment(CommentBean commentBean);
	
	@Select("select comment_writer,comment_text,comment_date "
			+ "from comments")
	List<CommentBean> commentList();
	
	
}
