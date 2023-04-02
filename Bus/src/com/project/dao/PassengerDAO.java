package com.project.dao;

import java.util.List;

import com.project.dto.BookingDTO;
import com.project.dto.PassengerDTO;

public interface PassengerDAO {
	
	
	
	 public String addPassenger(PassengerDTO passenger);
	 public String searchPassenger(String username, String password);
	 public int searchPassenger(String username);
	 public void updatePassenger(PassengerDTO passenger);
	 public List<BookingDTO> getBookingHistory(String username);
	 public void deletePassengerAccount(String username);

}
