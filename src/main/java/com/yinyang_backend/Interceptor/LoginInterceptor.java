package com.yinyang_backend.Interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.yinyang_backend.common.JWTUtil;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		try {
			String token = request.getHeader("Authorization");
			Map<String, Object> payload = JWTUtil.parseToken(token);
	        return true;
	        
		}catch(Exception e) {
			
			response.setStatus(401);
			return false;
		}
		
    }
    
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//            @Nullable ModelAndView modelAndView) throws Exception {
//        
//        System.out.println("MessageInterceptor.postHandle():なに！？");
//    }
//    
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
//            @Nullable Exception ex) throws Exception {
//        
//        System.out.println("MessageInterceptor.afterCompletion:たわば！！");
//    }
}
