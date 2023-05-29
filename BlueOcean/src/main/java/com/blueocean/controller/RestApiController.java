package com.blueocean.controller;

import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blueocean.beans.CommentBean;
import com.blueocean.service.CommentService;
import com.blueocean.service.UserService;

//view가 아니라 데이터를 전달할 때 씀
@RestController
public class RestApiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentService commentService;
	
	//아이디 중복 
	@GetMapping("/user/checkUserIdExist/{user_id}")
	public String checkUserIdExist(@PathVariable String user_id) {
		String result  = userService.checkuserIdExist(user_id);
		
		return result;
	}
	
	
	//댓글 등록
	@PostMapping("/saveComment") //String 객체 타입으로 받겠다..
	public  void saveComment(@RequestBody CommentBean commentBean ){
			commentService.saveComment(commentBean);
	}
	
	//댓글리스트 
	@SuppressWarnings("unchecked")
	@GetMapping("/commentList")
	public HashMap<String,List<CommentBean>> commentList() {
		
		//리스트 방식으로 전달 받음 
		List<CommentBean> commentList = commentService.commentList();
		//해쉬맵에 넣음 
		HashMap<String, List<CommentBean>> resultMap = new HashMap<>();
		
		resultMap.put("commentList", commentList);
	
		JSONObject jsonComments = new JSONObject(resultMap);
	
		return jsonComments;
	}
	
	
}
