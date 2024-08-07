package com.yinyang_backend.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yinyang_backend.entity.UserHistory;
import com.yinyang_backend.mapper.UserHistoryMapper;
import com.yinyang_backend.service.UserHistoryService;

@Service
public class UserHistoryServiceImpl extends ServiceImpl<UserHistoryMapper, UserHistory> implements UserHistoryService{
	
}
