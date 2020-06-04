package com.fordoki.hotels.service.impl;

import com.fordoki.hotels.dao.ReservationRepository;
import com.fordoki.hotels.dto.ReservationDto;
import com.fordoki.hotels.exception.ResourceNotFoundException;
import com.fordoki.hotels.mappers.ReservationMapper;
import com.fordoki.hotels.model.Reservation;
import com.fordoki.hotels.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author rustam
 */
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository repository;

    @Autowired
    private ReservationMapper mapper;

    // TODO implement filtering
    @Override
    public List<ReservationDto> getAllReservations(Date startDate, Date endDate) {
        if (startDate != null && endDate != null) {
            return mapper.toDtos(repository.getAllBetweenDates(startDate, endDate));
        } else {
            return mapper.toDtos(repository.findAll());
        }
    }

    @Override
    public ReservationDto getReservationById(Long reservationId) throws ResourceNotFoundException {
        return mapper.toDto(repository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", reservationId)));
    }

    @Override
    public ReservationDto createReservation(ReservationDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public ReservationDto updateReservation(Long reservationId, ReservationDto reservationDto) throws ResourceNotFoundException {
        Reservation reservation = repository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", reservationId));
        reservation.setFirstName(reservationDto.getFirstName());
        reservation.setLastName(reservationDto.getLastName());
        reservation.setRoomNumber(reservationDto.getRoomNumber());
        reservation.setStartDate(reservationDto.getStartDate());
        reservation.setEndDate(reservationDto.getEndDate());
        return mapper.toDto(repository.save(reservation));
    }

    @Override
    public void deleteReservation(Long reservationId) throws ResourceNotFoundException {
        Reservation reservation = repository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", reservationId));
        repository.delete(reservation);
    }

}