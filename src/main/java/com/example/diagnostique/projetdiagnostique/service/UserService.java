package com.example.diagnostique.projetdiagnostique.service;

import com.example.diagnostique.projetdiagnostique.DTO.LoginDTO;
import com.example.diagnostique.projetdiagnostique.DTO.UserDTO;
import com.example.diagnostique.projetdiagnostique.models.User;
import com.example.diagnostique.projetdiagnostique.response.LoginMessage;

import java.util.List;

public interface UserService {
    void addUser(UserDTO userDTO);
    LoginMessage loginUser(LoginDTO loginDTO);
    User getUserById(Integer userId);
}
