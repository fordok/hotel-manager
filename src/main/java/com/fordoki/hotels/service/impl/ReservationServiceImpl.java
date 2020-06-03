package com.fordoki.hotels.service.impl;

import com.fordoki.hotels.dto.ReservationDto;
import com.fordoki.hotels.service.ReservationService;
import org.springframework.stereotype.Service;

/**
 * @author rustam
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Override
    public ReservationDto getReservationById(Long reservationId) {
        return new ReservationDto("Test", "User");
    }

}