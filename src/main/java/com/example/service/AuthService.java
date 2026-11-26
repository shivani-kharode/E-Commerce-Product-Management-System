package com.example.service;



import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RoleName;
import com.example.dto.request.LoginRequestDTO;
import com.example.dto.request.RegisterRequestDTO;
import com.example.dto.response.LoginResponseDTO;
import com.example.entity.Roles;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder encoder;

    private final JwtService jwtService;

    public String register(
            RegisterRequestDTO dto){

        User existing =
                userRepository.findByEmail(
                        dto.getEmail());

        if(existing != null){

            throw new RuntimeException(
                    "Email already exists");
        }

        User user =
                userMapper.toEntity(dto);

        user.setPassword(
                encoder.encode(
                        dto.getPassword()));

        Roles customerRole =
                roleRepository.findByRoleName(
                        RoleName.CUSTOMER);
   

        user.getRoles().add(customerRole);

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public LoginResponseDTO login(
            LoginRequestDTO dto){

        User user =
                userRepository.findByEmail(
                        dto.getEmail());

        if(user == null){

            throw new RuntimeException(
                    "Invalid Email");
        }

        boolean isValid =
                encoder.matches(
                        dto.getPassword(),
                        user.getPassword());

        if(!isValid){

            throw new RuntimeException(
                    "Invalid Password");
        }

        String token =
                jwtService.generateToken(
                        user.getEmail());

        String role =
                user.getRoles()
                .iterator()
                .next()
                .getName()
                .name();

        return new LoginResponseDTO(
                token,
                role);
    }
}