package com.fordoki.hotels.controller;

import com.fordoki.hotels.dto.ReservationDto;
import com.fordoki.hotels.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rustam
 */
@RestController
@RequestMapping("/api/")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations/{id}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable(value = "id") Long reservationId) {
        return ResponseEntity.ok(reservationService.getReservationById(reservationId));
    }

}