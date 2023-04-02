package com.project.dto;

import java.sql.Timestamp;

public class BookingDTOImpl implements BookingDTO{
	
	private int bookingId;
	private int scheduleId;
	private int passengerId;
	private int numberOfSeats;
	private double totalCost;
	private Timestamp cancleTicket;
	
	public BookingDTOImpl() {
		
	}
	
	public BookingDTOImpl(int scheduleId, int passengerId, int numberOfSeats, double totalCost) {
		super();
		
		this.scheduleId = scheduleId;
		this.passengerId = passengerId;
		this.numberOfSeats = numberOfSeats;
		this.totalCost = totalCost;
	}
	public BookingDTOImpl(int bookingId, int scheduleId, int passengerId, int numberOfSeats, double totalCost) {
		super();
		this.bookingId = bookingId;
		this.scheduleId = scheduleId;
		this.passengerId = passengerId;
		this.numberOfSeats = numberOfSeats;
		this.totalCost = totalCost;
	}

	@Override
	public int getBookingId() {
		return bookingId;
	}

	@Override
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public int getScheduleId() {
		return scheduleId;
	}

	@Override
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	@Override
	public int getPassengerId() {
		return passengerId;
	}

	@Override
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	@Override
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	@Override
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public double getTotalCost() {
		return totalCost;
	}

	@Override
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "BookingDTOImpl [bookingId=" + bookingId + ", scheduleId=" + scheduleId + ", passengerId=" + passengerId
				+ ", numberOfSeats=" + numberOfSeats + ", totalCost=" + totalCost + "]";
	}
	
	

}
