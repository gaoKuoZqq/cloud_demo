package com.guoyicap.micro.config.user.mapper;

import com.guoyicap.micro.config.user.model.User;

public interface UserMapper {

	User findByUsername(String username);

}
