package com.zack.staybooking.services;

import com.zack.staybooking.exception.StayNotExistException;
import com.zack.staybooking.models.Stay;
import com.zack.staybooking.models.StayImage;
import com.zack.staybooking.models.User;
import com.zack.staybooking.repos.StayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StayService {
    private StayRepo stayRepo;
    private ImageStorageService imageStorageService;

    @Autowired
    public StayService(StayRepo stayRepo, ImageStorageService imageStorageService) {
        this.stayRepo = stayRepo;
        this.imageStorageService = imageStorageService;
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

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void add(Stay stay, MultipartFile[] images) {
        List<String> mediaLinks = Arrays.stream(images).parallel().map(
                image -> imageStorageService.save(image)
        ).collect(Collectors.toList());
        List<StayImage> stayImages = new ArrayList<>();

        for (String mediaLink : mediaLinks) {
            stayImages.add(new StayImage(mediaLink, stay));
        }
        stay.setImages(stayImages);
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
