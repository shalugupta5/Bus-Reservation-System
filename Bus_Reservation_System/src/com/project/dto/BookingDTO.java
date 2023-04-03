package com.project.dto;

public interface BookingDTO {

	public int getBookingId() ;

	public void setBookingId(int bookingId);
	
	public int getScheduleId() ;

	public void setScheduleId(int scheduleId) ;

	public int getPassengerId();

	public void setPassengerId(int passengerId);

	public int getNumberOfSeats() ;
	
	public void setNumberOfSeats(int numberOfSeats) ;

	public double getTotalCost() ;

	public void setTotalCost(double totalCost) ;
}
