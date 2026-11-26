package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.AssignRoleRequestDTO;
import com.example.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/assign")
    public String assignRole(
       @RequestBody
       AssignRoleRequestDTO dto){

       return roleService.assignRole(dto);
    }
}