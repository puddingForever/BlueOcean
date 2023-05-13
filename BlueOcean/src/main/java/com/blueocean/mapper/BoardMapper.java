package com.blueocean.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.blueocean.beans.BoardsBean;

public interface BoardMapper {
	
	@SelectKey(statement = "select board_seq.nextval from dual", keyProperty = "board_idx", before = true, resultType = int.class)	
	
	@Insert("insert into boards(board_idx,board_subject,board_text,"
			+ "board_file,board_writer_idx,board_date)"
			+ "values(#{board_idx},#{board_subject},#{board_text},#{board_file,jdbcType=VARCHAR},"
			+ "#{board_writer_idx},sysdate)")
	void addBoardInfo(BoardsBean writeBoardBean);

	
	@Select("select a1.board_idx, a1.board_subject, a2.user_name as board_writer_name, " + 
			"       to_char(a1.board_date, 'YYYY-MM-DD') as board_date " + 
			"from boards a1, user_table a2 " + 
			"where a1.board_writer_idx = a2.user_idx " + 
			"order by a1.board_idx desc")
	List<BoardsBean> getBoardList(RowBounds rowBounds);
	
	@Select("select a2.user_name as board_writer_name,to_char(a1.board_date,'YYYY-MM-DD')as board_date,a1.board_subject,a1.board_text,a1.board_file,a1.board_writer_idx "
			+ "from boards a1,user_table a2 "
			+ "where a1.board_writer_idx = a2.user_idx "
			+ "        and board_idx = #{board_idx}")
	BoardsBean getBoardInfo(int board_idx);
	
	
	@Update("update boards " +
			"set board_subject = #{board_subject}, board_text = #{board_text}, "+
			"board_file = #{board_file,jdbcType=VARCHAR} "+
			"where board_idx = #{board_idx}")
	void modifyBoardInfo(BoardsBean modifyBoardBean);
	
	@Delete("delete from boards where board_idx=#{board_idx}")
	void deleteBoardInfo(int board_idx);
	
	@Select("select count(*) from boards")
	int getBoardCnt();
	
	
}
