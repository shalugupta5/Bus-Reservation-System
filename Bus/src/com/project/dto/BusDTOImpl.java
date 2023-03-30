package com.project.dto;

public class BusDTOImpl implements BusDTO{

	
	private String BusNumber;
	private String BusType;
	private int TotalSeats;
	
	public BusDTOImpl() {
		
	}
	
	public BusDTOImpl(String busNumber, String busType, int totalSeats) {
		super();
		
		BusNumber = busNumber;
		BusType = busType;
		TotalSeats = totalSeats;
	}

	

	@Override
	public String getBusNumber() {
		return BusNumber;
	}

	@Override
	public void setBusNumber(String busNumber) {
		BusNumber = busNumber;
	}

	@Override
	public String getBusType() {
		return BusType;
	}

	@Override
	public void setBusType(String busType) {
		BusType = busType;
	}

	@Override
	public int getTotalSeats() {
		return TotalSeats;
	}

	@Override
	public void setTotalSeats(int totalSeats) {
		TotalSeats = totalSeats;
	}

	@Override
	public String toString() {
		return "BusDTOImpl [BusNumber=" + BusNumber + ", BusType=" + BusType + ", TotalSeats=" + TotalSeats + "]";
	}

	

	
	
	
	
}
