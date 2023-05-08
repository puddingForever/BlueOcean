package com.blueocean.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueocean.beans.UserBean;
import com.blueocean.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	
	public boolean checkuserIdExist(String user_id) {
		String user_name = userDao.checkUserIdExist(user_id);
		
		if(user_name==null) {
			return true;
		}else {
			return false;
		}
	}
	
	//회원가입
	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);
		
	}
	//로그인
	public void getLoginUserInfo(UserBean tempLoginUserBean) {
		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean); //UserBean을 넘겨서 값을 받음 
		
		if(tempLoginUserBean2 != null) {
			//세션스코프에 저장되이는 loginUserBean에 값 셋팅
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUserLogin(true);
		}
		
	}

	
}
