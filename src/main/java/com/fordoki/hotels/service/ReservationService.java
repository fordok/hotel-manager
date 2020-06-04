package com.fordoki.hotels.service;

import com.fordoki.hotels.dto.ReservationDto;
import com.fordoki.hotels.exception.ResourceNotFoundException;

import java.util.Date;
import java.util.List;

/**
 * @author rustam
 */
public interface ReservationService {

    List<ReservationDto> getAllReservations(Date startDate, Date endDate);

    ReservationDto getReservationById(Long reservationId) throws ResourceNotFoundException;

    ReservationDto createReservation(ReservationDto dto);

    ReservationDto updateReservation(Long reservationId, ReservationDto reservationDto) throws ResourceNotFoundException;

    void deleteReservation(Long reservationId) throws ResourceNotFoundException;

}