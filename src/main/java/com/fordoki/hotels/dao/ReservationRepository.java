package com.fordoki.hotels.dao;

import com.fordoki.hotels.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author rustam
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByStartDateBeforeAndEndDateAfter(Date startDate, Date endDate);

}