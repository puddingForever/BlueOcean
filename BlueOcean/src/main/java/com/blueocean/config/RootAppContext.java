package com.blueocean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.blueocean.beans.UserBean;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스(데이터를 저장할 목적)
@Configuration
public class RootAppContext {
	
	//다양한 목적으로 써서 따로 정의함.. 
	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
	}

}
