package com.yinyang_backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yinyang_backend.Interceptor.CorsInterceptor;
import com.yinyang_backend.Interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	@Autowired
	private CorsInterceptor corsInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(corsInterceptor)
				.order(1);
		
		registry.addInterceptor(loginInterceptor)
				.excludePathPatterns("/api/user/login","/api/user/regist")
				.order(2);
	}

}
