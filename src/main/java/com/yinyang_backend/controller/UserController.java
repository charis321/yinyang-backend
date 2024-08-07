package com.yinyang_backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yinyang_backend.common.JWTUtil;
import com.yinyang_backend.common.Result;
import com.yinyang_backend.entity.User;
import com.yinyang_backend.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
@CrossOrigin(value = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	public Result logIn(HttpServletRequest request, @RequestBody User user){
		LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<User>();
		lambdaQueryWrapper.eq(User::getUsername, user.getUsername());
		List<User> res = userService.list(lambdaQueryWrapper);
		
		if(res.size() == 0) return Result.fail("<<"+user.getUsername()+">> "+"doesn't exist.");
		
		if(!res.get(0).getPassword().equals(user.getPassword())) {
			System.out.println(res.get(0).getPassword());
			System.out.println(user.getPassword());
			return Result.fail("Incorrect password");
		}

		Map<String, Object> payload = new HashMap<>();
		payload.put("username", user.getUsername());
		String token = JWTUtil.getToken(payload);
		
		Map<String, Object> userData = new HashMap<>();
		userData.put("user_id", res.get(0).getUserId());
		userData.put("username", res.get(0).getUsername());
		userData.put("token", token);
		
		return Result.success("success login", userData);
	}
	
	@PostMapping("/regist")
	public Result regist(HttpServletRequest request, @RequestBody User user){
		System.out.println(user);
		Boolean res = userService.save(user);
		System.out.println(res?"yes":"no");
		return res? Result.success():Result.fail();
	}
	
	@PostMapping("/listAll")
	public Result list(HttpServletRequest request, @RequestBody User user){
		
		
		List<User> res = userService.list();
		
		return Result.success(res);
	}
	
	
}
