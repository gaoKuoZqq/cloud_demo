package com.guoyicap.micro.config.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.guoyicap.micro.config.user.mapper.UserMapper;
import com.guoyicap.micro.config.user.model.User;
import com.guoyicap.micro.config.user.service.UserService;

@Service()
@RestController
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Override
	public User findByUsername(@RequestBody String username) {
		User user = userMapper.findByUsername(username);
		return user;
	}}