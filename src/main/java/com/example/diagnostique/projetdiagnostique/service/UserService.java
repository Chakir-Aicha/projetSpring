package com.example.diagnostique.projetdiagnostique.service;

import com.example.diagnostique.projetdiagnostique.DTO.LoginDTO;
import com.example.diagnostique.projetdiagnostique.DTO.UserDTO;
import com.example.diagnostique.projetdiagnostique.response.LoginMessage;

public interface UserService {
    void addUser(UserDTO userDTO);
    LoginMessage loginUser(LoginDTO loginDTO);
}
