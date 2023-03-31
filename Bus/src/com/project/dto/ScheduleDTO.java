package com.project.dto;


import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public interface ScheduleDTO {

	public int getScheduleId();

	public void setScheduleId(int ScheduleId);

	public int getBusId();

	public void setBusId(int busId) ;

	public int getRouteId();

	public void setRouteId(int routeId);

	public LocalDate getJourneyDate();

	public void setJourneyDate(LocalDate journeyDate);

	public LocalTime getDepartureTime();

	public void setDepartureTime(LocalTime departureTime) ;

	public LocalTime getArrivalTime();

	public void setArrivalTime(LocalTime arrivalTime) ;

	
}
