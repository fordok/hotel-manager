package com.fordoki.hotels.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author rustam
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {

    private Long id;

    @NotNull(message = "firstName cannot be null!")
    private String firstName;

    @NotNull(message = "lastName cannot be null!")
    private String lastName;

    @NotNull(message = "roomNumber cannot be null!")
    private Integer roomNumber;

    @NotNull(message = "startDate cannot be null!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date startDate;

    @NotNull(message = "endDate cannot be null!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;

}