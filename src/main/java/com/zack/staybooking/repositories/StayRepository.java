package com.zack.staybooking.repositories;

import com.zack.staybooking.models.Stay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StayRepository extends JpaRepository<Stay, Long> {
    Stay findStayById(Long id);

}
