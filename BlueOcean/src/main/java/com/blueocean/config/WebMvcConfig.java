package com.blueocean.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.blueocean.beans.UserBean;
import com.blueocean.interceptor.CheckLoginInterceptor;
import com.blueocean.interceptor.CheckWriterInterceptor;
import com.blueocean.interceptor.TopMenuInterceptor;
import com.blueocean.mapper.BoardMapper;
import com.blueocean.mapper.CommentMapper;
import com.blueocean.mapper.NasaMapper;
import com.blueocean.mapper.RocketMapper;
import com.blueocean.mapper.UserMapper;
import com.blueocean.service.BoardService;

@Configuration
@EnableWebMvc
@ComponentScan("com.blueocean.controller")
@ComponentScan("com.blueocean.dao")
@ComponentScan("com.blueocean.service")
@PropertySource("/WEB-INF/properties/db.properties")
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Value("${db.classname}")
	private String db_classname;
	
	@Value("${db.url}")
	private String db_url;
	
	@Value("${db.username}")
	private String db_username;
	
	@Value("${db.password}")
	private String db_password;
	
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	@Autowired
	private BoardService boardService;
	
	// Controller의 메서드가 반환하는 jsp의 이름 앞뒤에 경로와 확장자를 붙혀주도록 설정한다.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/",".jsp");
	}
	
	// 정적 파일의 경로를 매핑한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
	}
	
	
	//데이터베이스 접속 정보 관리
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(db_classname);
		source.setUrl(db_url);
		source.setUsername(db_username);
		source.setPassword(db_password);
		return source;
	}	
	
	//쿼리문과 접속 관리하는 객체 
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		return factory;
	}
	
	//쿼리문 실행을 위한 객체 (mapper관리)
	@Bean
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	@Bean
	public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<UserMapper>(UserMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	@Bean
	public MapperFactoryBean<NasaMapper> getNasaMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<NasaMapper> factoryBean = new MapperFactoryBean<NasaMapper>(NasaMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	
	@Bean
	public MapperFactoryBean<RocketMapper> getRocketMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<RocketMapper> factoryBean = new MapperFactoryBean<RocketMapper>(RocketMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	@Bean
	public MapperFactoryBean<CommentMapper> getCommentMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<CommentMapper> factoryBean = new MapperFactoryBean<CommentMapper>(CommentMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
		
		TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(loginUserBean);
		
		InterceptorRegistration reg1 = registry.addInterceptor(topMenuInterceptor);
		reg1.addPathPatterns("/**");
		
		CheckLoginInterceptor checkLoginInterceptor = new CheckLoginInterceptor(loginUserBean);
		
		InterceptorRegistration reg2 = registry.addInterceptor(checkLoginInterceptor);
		reg2.addPathPatterns("/user/modify","/user/logout","/board/*","/user/profile");
		reg2.excludePathPatterns("/board/main");
		
		CheckWriterInterceptor checkWriterInterCeptor = new CheckWriterInterceptor(loginUserBean, boardService);
		InterceptorRegistration reg3 = registry.addInterceptor(checkWriterInterCeptor);
		reg3.addPathPatterns("/board/modify","/board/delete");
		
	}
	
	
	//properties파일을 message로 등록 
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasenames("/WEB-INF/properties/error_message","/WEB-INF/properties/message");
		
		return res;
	}
	
	//이미지 파일을 서버에 전달할떄 viewResolver를 multipartResolver로 설정 
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
}










