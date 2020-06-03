package com.fordoki.hotels.service;

import com.fordoki.hotels.dto.ReservationDto;

/**
 * @author rustam
 */
public interface ReservationService {

    ReservationDto getReservationById(Long reservationId);

}