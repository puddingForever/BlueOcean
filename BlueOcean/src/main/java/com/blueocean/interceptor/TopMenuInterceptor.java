package com.blueocean.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.blueocean.beans.TopMenuInfoBean;
import com.blueocean.beans.UserBean;

public class TopMenuInterceptor implements HandlerInterceptor {
	
	private UserBean loginUserBean;
	
	
	public TopMenuInterceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}

	@Override //컨트롤러 호출 전 실행 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
	request.setAttribute("loginUserBean", loginUserBean);
		
		return true;
	}
}
