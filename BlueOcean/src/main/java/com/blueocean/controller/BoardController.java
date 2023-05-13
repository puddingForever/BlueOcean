package com.blueocean.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blueocean.beans.BoardsBean;
import com.blueocean.beans.PageBean;
import com.blueocean.beans.UserBean;
import com.blueocean.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	
	@Autowired
	private BoardService boardService;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	@GetMapping("/main")
	public String main(@RequestParam(value="page",defaultValue="1") int page,Model model) {
		
		List<BoardsBean> boardList = boardService.getBoardList(page);
		model.addAttribute("boardList",boardList);
		
		//페이징
		PageBean pageBean = boardService.getBoardCnt(page);
		model.addAttribute("pageBean",pageBean);
		return "board/main";
	}
	//읽기
	@GetMapping("/read")
	public String read(@RequestParam("board_idx")int board_idx,Model model) {
		
		model.addAttribute("board_idx", board_idx);
		
		BoardsBean readBoardBean = boardService.getBoardInfo(board_idx);	
		model.addAttribute("readBoardBean",readBoardBean);
		
		model.addAttribute("loginUserBean",loginUserBean);
		
		return "board/read";
	}
	//쓰기
	@GetMapping("/write")
	public String write(@ModelAttribute("writeBoardBean")BoardsBean writeBoardBean) {
		return "board/write";
	}
	
	@PostMapping("/write_pro")
	public String write_pro(@Valid @ModelAttribute("writeBoardBean")BoardsBean writeBoardBean,BindingResult result) {
		
		if(result.hasErrors()){
			return "board/write";
		}
		
		boardService.addBoardInfo(writeBoardBean);
		return "board/write_success";
	}
	
	@GetMapping("/modify")
	public String modify(@RequestParam("board_idx")int board_idx,Model model,
						@ModelAttribute("modifyBoardBean")BoardsBean modifyBoardBean) {
		
		model.addAttribute("board_idx",board_idx);
		
		BoardsBean tempBoardBean = boardService.getBoardInfo(board_idx);
		
		modifyBoardBean.setBoard_writer_name(tempBoardBean.getBoard_writer_name());
		modifyBoardBean.setBoard_date(tempBoardBean.getBoard_date());
		modifyBoardBean.setBoard_subject(tempBoardBean.getBoard_subject());
		modifyBoardBean.setBoard_text(tempBoardBean.getBoard_text());
		modifyBoardBean.setBoard_file(tempBoardBean.getBoard_file());
		modifyBoardBean.setBoard_writer_idx(tempBoardBean.getBoard_writer_idx());
		modifyBoardBean.setBoard_idx(board_idx);
		
		return "board/modify";
	}
	
	@PostMapping("/modify_pro")
	public String modify_pro(@Valid @ModelAttribute("modifyBoardBean")BoardsBean modifyBoardBean,
					BindingResult result ) {

		if(result.hasErrors()) {
			return "board/modify";
		}
		
		boardService.modifyBoardInfo(modifyBoardBean);
		
		return "board/modify_success";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("board_idx")int board_idx) {
		
		boardService.deleteBoardInfo(board_idx);
		
		
		return "board/delete";
	}
	
	@GetMapping("/not_writer")
	public String not_writer() {
		
		return "board/not_writer";
	}
}
