package com.project.dto;



import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleDTOImpl implements ScheduleDTO{
	
	private int ScheduleId;
    private int busId;
    private int routeId;
    private int availableSeats;
    private LocalDate journeyDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    
    public ScheduleDTOImpl() {
    	
    }
    
	public ScheduleDTOImpl(int ScheduleId, int busId, int routeId, LocalDate journeyDate, LocalTime departureTime, LocalTime arrivalTime, int availableSeats) {
		super();
		this.ScheduleId = ScheduleId;
		this.busId = busId;
		this.routeId = routeId;
		this.journeyDate = journeyDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.availableSeats = availableSeats;
	}
	
	public ScheduleDTOImpl(int busId, int routeId, LocalDate journeyDate, LocalTime departureTime, LocalTime arrivalTime, int availableSeats) {
		super();
		
		this.busId = busId;
		this.routeId = routeId;
		this.journeyDate = journeyDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.availableSeats = availableSeats;
	}

	
	
	@Override
	public int getScheduleId() {
		return ScheduleId;
	}

	@Override
	public void setScheduleId(int ScheduleId) {
		this.ScheduleId = ScheduleId;
	}

	@Override
	public int getBusId() {
		return busId;
	}

	@Override
	public void setBusId(int busId) {
		this.busId = busId;
	}

	@Override
	public int getRouteId() {
		return routeId;
	}

	@Override
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	@Override
	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	@Override
	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	@Override
	public LocalTime getDepartureTime() {
		return departureTime;
	}

	@Override
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	@Override
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	@Override
	public int getAvailableSeats() {
		return availableSeats;
	}

	@Override
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	@Override
	public String toString() {
		return "ScheduleId=" + ScheduleId + ", busId=" + busId + ", routeId=" + routeId
				+ ", availableSeats=" + availableSeats + ", journeyDate=" + journeyDate + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime ;
	}

	
    
    
    
    
    

}
