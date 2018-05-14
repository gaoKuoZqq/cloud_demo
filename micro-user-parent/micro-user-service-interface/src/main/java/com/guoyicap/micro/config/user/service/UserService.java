package com.guoyicap.micro.config.user.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guoyicap.micro.config.user.model.User;


/**
 * Created on 2016/7/05 11:44.
 */
@FeignClient()
@RequestMapping(value="user")
public interface UserService {

	@RequestMapping("findByUsername")
	User findByUsername(String username);

}