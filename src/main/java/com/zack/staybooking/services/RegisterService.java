package com.zack.staybooking.services;

import com.zack.staybooking.exception.UserAlreadyExistException;
import com.zack.staybooking.models.Authority;
import com.zack.staybooking.models.User;
import com.zack.staybooking.models.UserRole;
import com.zack.staybooking.repos.AuthorityRepository;
import com.zack.staybooking.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RegisterService {
    private UserRepo userRepo;
    private AuthorityRepository authorityRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(UserRepo userRepo, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.authorityRepository = authorityRepository;
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
        authorityRepository.save(new Authority(user.getUsername(), role.name()));
    }

}

