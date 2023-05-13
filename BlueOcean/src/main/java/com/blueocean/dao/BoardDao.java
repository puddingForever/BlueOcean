package com.blueocean.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blueocean.beans.BoardsBean;
import com.blueocean.mapper.BoardMapper;

@Repository
public class BoardDao {

	@Autowired
	private BoardMapper boardMapper;
	
	public void addBoardInfo(BoardsBean writeBoardBean) {
		
		boardMapper.addBoardInfo(writeBoardBean);
		
	}

	public 	List<BoardsBean> getBoardList(RowBounds rowBounds){
		return boardMapper.getBoardList(rowBounds);
	}
	
	public BoardsBean getBoardInfo(int board_idx) {
		return boardMapper.getBoardInfo(board_idx);
	}
	
	public void modifyBoardInfo(BoardsBean modifyBoardBean) {
		 boardMapper.modifyBoardInfo(modifyBoardBean);
	}
	
	public void deleteBoardInfo(int board_idx) {
		boardMapper.deleteBoardInfo(board_idx);
	}
	
	public int getBoardCnt() {
		return boardMapper.getBoardCnt();
	}



}
