package com.example.mapper;

import org.springframework.stereotype.Component;

import com.example.dto.request.RegisterRequestDTO;
import com.example.entity.User;
@Component
public class UserMapper {
	
	public User toEntity(
            RegisterRequestDTO dto) {

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return user;
    }

}
