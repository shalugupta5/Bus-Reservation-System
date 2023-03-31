package com.project.dao;

import com.project.dto.PassengerDTO;

public interface PassengerDAO {
	
	
	
	 public String addPassenger(PassengerDTO passenger);
	 public String searchPassenger(String username, String password);

}
