
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
	
	//회원 아이디 체크 
	public  String checkuserIdExist(String user_id) {
		String result = userDao.checkUserIdExist(user_id);
		
		return result;
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
	
	//정보수정
	public void getModifyUserInfo(UserBean modifyUserBean) {
		UserBean tempModifyUserBean = userDao.getModifyUserInfo(loginUserBean.getUser_idx());
		modifyUserBean.setUser_id(tempModifyUserBean.getUser_id());
		modifyUserBean.setUser_name(tempModifyUserBean.getUser_name());
		modifyUserBean.setUser_idx(tempModifyUserBean.getUser_idx());
	}

	
}
