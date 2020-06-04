package com.fordoki.hotels.controller;

import com.fordoki.hotels.dto.ReservationDto;
import com.fordoki.hotels.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author rustam
 */
@RestController
@RequestMapping("/api/")
@Validated
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDto>> getAllReservations(
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return ResponseEntity.ok(reservationService.getAllReservations(startDate, endDate));
    }

    @PostMapping("/reservations")
    public ResponseEntity<ReservationDto> createReservation(@Valid @RequestBody ReservationDto reservationDto) {
        ReservationDto createdPerson = reservationService.createReservation(reservationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable(value = "id") Long reservationId) throws Exception {
        return ResponseEntity.ok(reservationService.getReservationById(reservationId));
    }

    @PutMapping("/reservations/{id}")
    public ResponseEntity<ReservationDto> updateReservation(@PathVariable(value = "id") Long reservationId,
                                                            @Valid @RequestBody ReservationDto reservationDto) throws Exception {
        return ResponseEntity.ok(reservationService.updateReservation(reservationId, reservationDto));
    }

    @DeleteMapping("/reservations/{id}")
    public ResponseEntity deletePerson(@PathVariable(value = "id") Long reservationId) throws Exception {
        reservationService.deleteReservation(reservationId);
        return ResponseEntity.ok().build();
    }

}