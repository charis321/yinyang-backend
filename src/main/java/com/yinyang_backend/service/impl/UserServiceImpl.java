package com.yinyang_backend.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yinyang_backend.entity.User;
import com.yinyang_backend.mapper.UserMapper;
import com.yinyang_backend.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
