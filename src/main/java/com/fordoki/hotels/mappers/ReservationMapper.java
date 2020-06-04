package com.fordoki.hotels.mappers;

import com.fordoki.hotels.dto.ReservationDto;
import com.fordoki.hotels.model.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author rustam
 */
@Component
public class ReservationMapper {

    @Autowired
    private ModelMapper mapper;

    public List<ReservationDto> toDtos(List<Reservation> reservations) {
        List<ReservationDto> dtos = new ArrayList<>();
        for (Reservation reservation : reservations) {
            dtos.add(toDto(reservation));
        }
        return dtos;
    }

    public Reservation toEntity(ReservationDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, Reservation.class);
    }

    public ReservationDto toDto(Reservation entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, ReservationDto.class);
    }

}