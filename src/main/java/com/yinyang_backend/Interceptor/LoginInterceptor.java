package com.yinyang_backend.Interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;

import com.yinyang_backend.common.JWTUtil;

//@Order(1)
@Component
public class LoginInterceptor implements HandlerInterceptor{
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {		
		String token = request.getHeader("Authorization");
	
		try{

			Map<String, Object> payload = JWTUtil.parseToken(token);
			System.out.println(payload.toString());
			System.out.println("Auth success");
			return true;
		}catch(Exception e) {
			
			response.setStatus(401);
			System.out.println("Auth fail");
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
