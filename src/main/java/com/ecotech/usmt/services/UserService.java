package com.ecotech.usmt.services;

import com.ecotech.usmt.models.User;;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(long userid);
}
