package com.fordoki.hotels.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fordoki.hotels.dto.ReservationDto;
import com.fordoki.hotels.exception.ResourceNotFoundException;
import com.fordoki.hotels.service.ReservationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author rustam
 */
public class ReservationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ReservationService reservationService;

    @InjectMocks
    private ReservationController reservationController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(reservationController)
                .build();
    }

    @Test
    public void testGetReservationById() throws Exception {
        when(reservationService.getReservationById(anyLong())).thenReturn(new ReservationDto(0L, "Test", "User", 207, new Date(), new Date()));

        mockMvc.perform(get("/api/reservations/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Test")))
                .andExpect(jsonPath("$.lastName", is("User")))
                .andExpect(jsonPath("$.roomNumber", is(207)));

        verify(reservationService, times(1)).getReservationById(1L);
        verifyNoMoreInteractions(reservationService);
    }

    @Test
    public void testGetReservationNotFound() throws Exception {
        when(reservationService.getReservationById(anyLong())).thenThrow(new ResourceNotFoundException("Reservation", "id", 33));

        mockMvc.perform(get("/api/reservations/33"))
                .andExpect(status().isNotFound());

        verify(reservationService, times(1)).getReservationById(33L);
        verifyNoMoreInteractions(reservationService);
    }

    @Test
    public void testCreateReservation() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        when(reservationService.createReservation(any(ReservationDto.class))).thenReturn(new ReservationDto(0L, "Test", "User", 207, new Date(), new Date()));

        mockMvc.perform(post("/api/reservations")
                .content(objectMapper.writeValueAsString(new ReservationDto(0L, "Test", "User", 207, new Date(), new Date())))
                .contentType("application/json"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is("Test")))
                .andExpect(jsonPath("$.lastName", is("User")))
                .andExpect(jsonPath("$.roomNumber", is(207)));

        verify(reservationService, times(1)).createReservation(any(ReservationDto.class));
        verifyNoMoreInteractions(reservationService);
    }

    @Test
    public void testUpdateReservation() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        when(reservationService.updateReservation(anyLong(), any(ReservationDto.class))).thenReturn(new ReservationDto(0L, "Test", "User", 207, new Date(), new Date()));

        mockMvc.perform(put("/api/reservations/1")
                .content(objectMapper.writeValueAsString(new ReservationDto(0L, "Test", "User", 207, new Date(), new Date())))
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Test")))
                .andExpect(jsonPath("$.lastName", is("User")))
                .andExpect(jsonPath("$.roomNumber", is(207)));

        verify(reservationService, times(1)).updateReservation(anyLong(), any(ReservationDto.class));
        verifyNoMoreInteractions(reservationService);
    }

    @Test
    public void testRemoveReservation() throws Exception {

        mockMvc.perform(delete("/api/reservations/1")
                .contentType("application/json"))
                .andExpect(status().isOk());

        verify(reservationService, times(1)).deleteReservation(anyLong());
        verifyNoMoreInteractions(reservationService);
    }

    @Test
    public void testSearch() throws Exception {

        List<ReservationDto> reservations = new ArrayList<>();
        reservations.add(new ReservationDto(0L, "Test", "User", 207, new Date(), new Date()));

        when(reservationService.getAllReservations(any(Date.class), any(Date.class))).thenReturn(reservations);

        mockMvc.perform(get("/api/reservations")
                .param("startDate", "2020-10-10")
                .param("endDate", "2020-10-20"))
                .andExpect(status().isOk());

        verify(reservationService, times(1)).getAllReservations(any(Date.class), any(Date.class));
        verifyNoMoreInteractions(reservationService);
    }
}