package com.fordoki.hotels.dao;

import com.fordoki.hotels.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author rustam
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query(value = "SELECT r from Reservation r where r.startDate >= :startDate AND r.endDate <= :endDate")
    List<Reservation> getAllBetweenDates(@Param("startDate")Date startDate, @Param("endDate")Date endDate);

}