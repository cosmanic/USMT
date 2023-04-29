package com.ecotech.usmt.cotrollers;

import com.ecotech.usmt.models.User;
import com.ecotech.usmt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value="/users")
    public ResponseEntity<User> createUser(@RequestBody  User user)
    {
      User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
@GetMapping(value="/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable  long userId)
    {
        User user =userService.getUser(userId);
        return ResponseEntity.ok(user);
    }
    @GetMapping(value="/users")
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> allUser=userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

}
