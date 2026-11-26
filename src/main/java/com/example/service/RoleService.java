package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RoleName;
import com.example.dto.request.AssignRoleRequestDTO;
import com.example.entity.Roles;
import com.example.entity.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
@Service
public class RoleService {
	
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  RoleRepository roleRepository;

    public String assignRole(
            AssignRoleRequestDTO dto){

        User user =
                userRepository
                .findById(dto.getUserId());
        
        if(user == null){

            throw new RuntimeException(
                    "User Not Found");
        }

        Roles role =
                roleRepository
                .findByRoleName(
                        RoleName.valueOf(
                                dto.getRole()));
        
        if(role == null){

            throw new RuntimeException(
                    "Role Not Found");
        }
       
        user.getRoles().clear();

        user.getRoles().add(role);

        userRepository.update(user);

        return "Role Assigned Successfully";
    }

}
