package com.yinyang_backend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yinyang_backend.common.Result;
import com.yinyang_backend.entity.UserHistory;
import com.yinyang_backend.service.UserHistoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user/history")
//@CrossOrigin(value = "http://localhost:3000")
public class UserHistoryController {
	
	@Autowired
	private UserHistoryService userHistoryService;
	
	@PostMapping("/add")
	public Result add(HttpServletRequest request, @RequestBody UserHistory userHistory) {
		userHistoryService.save(userHistory);
		return Result.success("新增成功");
	}
	
	@PostMapping("/delete")
	public Result delete(HttpServletRequest request, @RequestBody UserHistory userHistory) {
		return userHistoryService.removeById(userHistory.getHistoryId())?Result.success():Result.fail();
	}
	
	@PostMapping("/list")
	public Result list(HttpServletRequest request, @RequestBody UserHistory userHistory) {
		
		LambdaQueryWrapper<UserHistory> lambdaQueryWrapper = new LambdaQueryWrapper<UserHistory>();
		lambdaQueryWrapper.eq(UserHistory::getUserId, userHistory.getUserId());
		
		return Result.success(userHistoryService.list(lambdaQueryWrapper));
		
	}
	
}
