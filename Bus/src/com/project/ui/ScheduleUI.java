package com.project.ui;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.project.dao.ScheduleDAO;
import com.project.dao.ScheduleDAOImpl;
import com.project.dto.ScheduleDTO;
import com.project.dto.ScheduleDTOImpl;

public class ScheduleUI {
	
	private Scanner sc;

	public ScheduleUI(Scanner sc) {
		super();
		this.sc = sc;
	}
	
	public void addSchedule() {
		 
		 
		System.out.println("Enter BusID");
		int BusID = sc.nextInt();
		
		System.out.println("Enter RouteID");
		int RouteID = sc.nextInt();
		
		
		System.out.println("Enter Departure Time");
		LocalTime DepartureTime = LocalTime.parse(sc.next());
		
		
		System.out.println("Enter Arrival Time");
		LocalTime ArrivalTime = LocalTime.parse(sc.next());
		
		
		System.out.println("Enter Journey Date");
		LocalDate JourneyDate = LocalDate.parse(sc.next());		
		
		ScheduleDTO scheduledto = new ScheduleDTOImpl(BusID, RouteID, JourneyDate, DepartureTime, ArrivalTime,0);
		ScheduleDAO scheduledao = new ScheduleDAOImpl();
		scheduledao.addSchedule(scheduledto);
	}

}
