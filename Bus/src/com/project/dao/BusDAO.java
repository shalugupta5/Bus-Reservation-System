package com.project.dao;

import java.util.List;

import com.project.dto.BusDTO;

public interface BusDAO {

	 public void addBus(BusDTO bus);
	 
	 public List<BusDTO> getAllBuses();
	 
	 public void updateBus(BusDTO bus);
	 
	 public void deleteBus(int busID);
}
