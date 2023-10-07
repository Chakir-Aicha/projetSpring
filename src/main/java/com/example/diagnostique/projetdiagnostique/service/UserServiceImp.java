package com.example.diagnostique.projetdiagnostique.service;

import com.example.diagnostique.projetdiagnostique.DTO.LoginDTO;
import com.example.diagnostique.projetdiagnostique.DTO.UserDTO;
import com.example.diagnostique.projetdiagnostique.models.User;
import com.example.diagnostique.projetdiagnostique.repository.UserRepository;
import com.example.diagnostique.projetdiagnostique.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImp implements UserService{
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;
    @Override
    public void addUser(UserDTO userDTO) {
         User user=new User(userDTO.getId(),userDTO.getUsername(),this.bCryptPasswordEncoder.encode(userDTO.getPassword()),userDTO.getEmail(),"");
         this.userRepository.save(user);
         //return user.getUsername();
    }
    UserDTO userDTO;
    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepository.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = bCryptPasswordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {
                return new LoginMessage("password Not Match", false);
            }
        }else {
            return new LoginMessage("Email not exits", false);
        }
    }
    }
