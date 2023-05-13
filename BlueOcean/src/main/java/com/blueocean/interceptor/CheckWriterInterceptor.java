package com.blueocean.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.blueocean.beans.BoardsBean;
import com.blueocean.beans.UserBean;
import com.blueocean.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{
	
	private UserBean loginUserBean;
	private BoardService boardService;
	
	public CheckWriterInterceptor(UserBean loginUserBean,BoardService boardService) {
		this.loginUserBean = loginUserBean;
		this.boardService = boardService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		String str1 = request.getParameter("board_idx");	
		int board_idx = Integer.parseInt(str1);
		
		BoardsBean currentBoardBean = boardService.getBoardInfo(board_idx);
		
		if(currentBoardBean.getBoard_writer_idx() != loginUserBean.getUser_idx()) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/board/not_writer");
			return false;
		}
		return true; 
		
	}
	
}
