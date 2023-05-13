package com.blueocean.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blueocean.beans.BoardsBean;
import com.blueocean.beans.PageBean;
import com.blueocean.beans.UserBean;
import com.blueocean.dao.BoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {
	
	 @Value("${path.upload}")
	 private String path_upload;
	 
	 @Value("${page.listcnt}")
		private int page_listcnt;
		
		@Value("${page.paginationcnt}")
		private int page_paginationcnt;
	 
	@Autowired
	private BoardDao boardDao;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	 
	 //파일 저장 
	 public String saveUploadFile(MultipartFile upload_file) {
		 String file_name = System.currentTimeMillis()+"_"+upload_file.getOriginalFilename();
		 
		 try {
			 upload_file.transferTo(new File(path_upload+"/"+file_name));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 return file_name;
	 }
	 
	 public void addBoardInfo(BoardsBean writeBoardBean) {
		 	
		 MultipartFile upload_file = writeBoardBean.getUpload_file();
		 
		 if(upload_file.getSize()>0) {
			 String file_name = saveUploadFile(upload_file);
			 writeBoardBean.setBoard_file(file_name);
		 }
		 
		 writeBoardBean.setBoard_writer_idx(loginUserBean.getUser_idx());
		 boardDao.addBoardInfo(writeBoardBean);
	 }
	 //게시글 리스트 
		public 	List<BoardsBean> getBoardList(int page){
			/*
			 * 1 페이지 -> 0
			 * 2 페이지 -> 10
			 * 3 페이지 -> 20
			 * 
			 * RowBounds(시작인덱스 , 개수) 
			 * */
			
			int start = (page-1) * page_listcnt;
			RowBounds rowBounds = new RowBounds(start,page_listcnt);
			

			return boardDao.getBoardList(rowBounds);
			
			
			
			
		}
		
	//게시글 읽기 (게시글 한개의 정보를 가져옴) 
		public 	BoardsBean getBoardInfo(int board_idx) {
			return boardDao.getBoardInfo(board_idx);
		}

		public void modifyBoardInfo(BoardsBean modifyBoardBean) {
			//업르도된 파일 가져옴 
			MultipartFile upload_file = modifyBoardBean.getUpload_file();
			if(upload_file.getSize()>0) {
				String file_name = saveUploadFile(upload_file);
				modifyBoardBean.setBoard_file(file_name);
			}
			
			boardDao.modifyBoardInfo(modifyBoardBean);
		}

		
		public void deleteBoardInfo(int board_idx) {
			boardDao.deleteBoardInfo(board_idx);
		}
		
		
		public PageBean getBoardCnt(int currentPage) {
			
			int board_cnt = boardDao.getBoardCnt();
			
			PageBean pageBean = new PageBean(board_cnt,currentPage,page_listcnt,page_paginationcnt);
			
			return pageBean;
		}
		
		
		
}
