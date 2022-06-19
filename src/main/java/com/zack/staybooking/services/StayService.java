package com.zack.staybooking.services;

import com.zack.staybooking.exception.StayNotExistException;
import com.zack.staybooking.models.Stay;
import com.zack.staybooking.models.User;
import com.zack.staybooking.repos.StayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StayService {
    private StayRepo stayRepo;

    @Autowired
    public StayService(StayRepo stayRepo) {
        this.stayRepo = stayRepo;
    }

    public List<Stay> listByUser(String username) {
        return stayRepo.findByHost(new User.Builder().setUsername(username).build());
    }

    public Stay findByIdAndHost(Long stayId, String username) throws StayNotExistException {
        Stay stay = stayRepo.findByIdAndHost(stayId, new User.Builder().setUsername(username).build());
        if (stay == null) {
            throw new StayNotExistException("Stay doesn't exist");
        }
        return stay;
    }

    public void add(Stay stay) {
        stayRepo.save(stay);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(Long stayId, String username) throws StayNotExistException {
        Stay stay = stayRepo.findByIdAndHost(stayId, new User.Builder().setUsername(username).build());
        if (stay == null) {
            throw new StayNotExistException("Stay doesn't exist");
        }
        stayRepo.deleteById(stayId);
    }
}
