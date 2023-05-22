package com.zack.staybooking.controllers;

import com.zack.staybooking.models.Stay;
import com.zack.staybooking.services.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StayController {
    private StayService stayService;

    @Autowired
    public StayController(StayService stayService) {
        this.stayService = stayService;
    }

    @GetMapping(value = "/stays/{id}")
    public Stay getStay(@PathVariable Long id) {
        return stayService.findStayById(id);
    }
}
