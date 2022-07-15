package com.zack.staybooking.repos;

import com.zack.staybooking.models.Reservation;
import com.zack.staybooking.models.Stay;
import com.zack.staybooking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByGuest(User guest);

    List<Reservation> findByStay(Stay stay);

    Reservation findByIdAndGuest(Long id, User guest);
    List<Reservation> findByStayAndCheckoutDateAfter(Stay stay, LocalDate date);
}
