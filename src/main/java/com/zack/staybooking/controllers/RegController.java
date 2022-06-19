package com.zack.staybooking.controllers;

import com.zack.staybooking.models.User;
import com.zack.staybooking.models.UserRole;
import com.zack.staybooking.services.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegController {
    private RegService regService;

    @Autowired
    public RegController(RegService regService) {
        this.regService = regService;
    }

    @PostMapping("/register/guest")
    public void addGuest(@RequestBody User user) {
        regService.add(user, UserRole.ROLE_GUEST);
    }
    @PostMapping("/register/host")
    public void addHost(@RequestBody User user) {
        regService.add(user, UserRole.ROLE_HOST);
    }
}
