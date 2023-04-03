package com.project.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.project.dto.BookingDTO;
import com.project.dto.RouteScheduleDTO;
import com.project.dto.ScheduleDTO;

public interface BookingDAO {

	//public void addBooking(BookingDTO booking);
	
	public List<RouteScheduleDTO> bookTicket(String departureCity, String arrivalCity, LocalDate date);
	
	public void cancelBooking(LocalTime now,int bookingId, int passengerID) throws ClassNotFoundException;
	
	public List<BookingDTO > viewAllBookings();
	
	public List<BookingDTO > viewAllBookingsWithDateRange(LocalDate startDate, LocalDate endDate);
	
	public List<BookingDTO > viewAllBookingsByBusNumber(String busNUmber);
	
	public List<BookingDTO > viewAllBookingsByMobileNumber(String mobileNUmber);
	
	
	
}
