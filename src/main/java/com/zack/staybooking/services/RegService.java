package com.zack.staybooking.services;

import com.zack.staybooking.exception.UserAlreadyExistException;
import com.zack.staybooking.models.Authority;
import com.zack.staybooking.models.User;
import com.zack.staybooking.models.UserRole;
import com.zack.staybooking.repos.AuthRepo;
import com.zack.staybooking.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RegService {
    private UserRepo userRepo;
    private AuthRepo authRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegService(UserRepo userRepo, AuthRepo authRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.authRepo = authRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void add(User user, UserRole role) throws UserAlreadyExistException {
        if (userRepo.existsById(user.getUsername())) {
            throw new UserAlreadyExistException("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepo.save(user);
        authRepo.save(new Authority(user.getUsername(), role.name()));
    }

}

