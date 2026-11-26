package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.request.LoginRequestDTO;
import com.example.dto.request.RegisterRequestDTO;
import com.example.dto.response.LoginResponseDTO;
import com.example.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String>
    register(
            @RequestBody
            RegisterRequestDTO dto){

        return ResponseEntity.ok(
                authService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO>
    login(
            @RequestBody
            LoginRequestDTO dto){

        return ResponseEntity.ok(
                authService.login(dto));
    }
}

