package com.example.diagnostique.projetdiagnostique.controllers;

import com.example.diagnostique.projetdiagnostique.DTO.LoginDTO;
import com.example.diagnostique.projetdiagnostique.DTO.UserDTO;
import com.example.diagnostique.projetdiagnostique.response.LoginMessage;
import com.example.diagnostique.projetdiagnostique.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping( "/add")
    public void addUser(@RequestBody UserDTO userDTO)
    {
          userService.addUser(userDTO);
        //return id;
    }
    @PostMapping( "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginMessage loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
