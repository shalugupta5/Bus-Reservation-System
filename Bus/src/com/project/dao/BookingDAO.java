package com.project.dao;

import java.time.LocalDate;
import java.util.List;

import com.project.dto.BookingDTO;
import com.project.dto.RouteScheduleDTO;
import com.project.dto.ScheduleDTO;

public interface BookingDAO {

	public void addBooking(BookingDTO booking);
	
	public List<RouteScheduleDTO> bookTicket(String departureCity, String arrivalCity, LocalDate date);
}
