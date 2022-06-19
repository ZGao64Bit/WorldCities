package com.zack.staybooking.repos;

import com.zack.staybooking.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<Authority, String> {

}
