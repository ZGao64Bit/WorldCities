package com.zack.staybooking.services;

import com.zack.staybooking.exceptions.StayNotExistException;
import com.zack.staybooking.models.*;

import com.zack.staybooking.repositories.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StayService {
    private StayRepository stayRepository;

    @Autowired
    public StayService(StayRepository stayRepository) {
        this.stayRepository = stayRepository;
    }

    public Stay findStayById(Long id) throws StayNotExistException {
        Stay stay = stayRepository.findStayById(id);
        if (stay == null) {
            throw new StayNotExistException("Stay doesn't exist");
        }
        return stay;
    }

}
