package com.project.dto;

public class BusDTOImpl implements BusDTO{

	private int BusId;
	private String BusNumber;
	private String BusType;
	private int TotalSeats;
	
	public BusDTOImpl() {
		
	}
	
	public BusDTOImpl(int busId, String busNumber, String busType, int totalSeats) {
		super();
		BusId=busId;
		BusNumber = busNumber;
		BusType = busType;
		TotalSeats = totalSeats;
	}
	
	public BusDTOImpl(String busNumber, String busType, int totalSeats) {
		super();
		
		BusNumber = busNumber;
		BusType = busType;
		TotalSeats = totalSeats;
	}

	

	@Override
	public int getBusId() {
		return BusId;
	}

	@Override
	public void setBusId(int busId) {
		BusId = busId;
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
//		return "BusDTOImpl [BusNumber=" + BusNumber + ", BusType=" + BusType + ", TotalSeats=" + TotalSeats + "]";
		return "        " + BusNumber + "       " + BusType + "        " + TotalSeats + "";
	
	}

	

	
	
	
	
}
