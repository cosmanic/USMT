package com.ecotech.usmt.cotrollers;

import com.ecotech.usmt.models.User;
import com.ecotech.usmt.services.UserService;
import com.ecotech.usmt.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class LoginController {
    @Autowired
    private UserServiceImpl loginService;
    @GetMapping(value="/login")
    public ResponseEntity<User> getUserEmailAndPassword(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password)
    {
        User user=loginService.loginByEmailAndPassword(email,password);
        return ResponseEntity.ok(user);
    }
}
