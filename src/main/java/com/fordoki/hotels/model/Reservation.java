package com.fordoki.hotels.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author rustam
 */
@Data
@Entity
@Table(name = "reservations")
public class Reservation extends AbstractEntity {

    private String firstName;

    private String lastName;

    private Integer roomNumber;

    private Date startDate;

    private Date endDate;

}