package com.project.ui;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Scanner;

import com.project.colors.ConsoleColors;
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
		 
		 
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter BusID");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int BusID = sc.nextInt();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter RouteID");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int RouteID = sc.nextInt();
		
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter Departure Time");
		System.out.println(ConsoleColors.GREEN_BOLD);
		LocalTime DepartureTime = LocalTime.parse(sc.next());
		
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter Arrival Time");
		System.out.println(ConsoleColors.GREEN_BOLD);
		LocalTime ArrivalTime = LocalTime.parse(sc.next());
		
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter Journey Date");
		System.out.println(ConsoleColors.GREEN_BOLD);
		LocalDate JourneyDate = LocalDate.parse(sc.next());		
		
		
		if(JourneyDate.isBefore(LocalDate.now())) {
			System.out.println(ConsoleColors.RED_BOLD+"Enter valid date, this has been passed.");
		}else if(JourneyDate.isAfter(LocalDate.now())) {
			ScheduleDTO scheduledto = new ScheduleDTOImpl(BusID, RouteID, JourneyDate, DepartureTime, ArrivalTime,0);
			ScheduleDAO scheduledao = new ScheduleDAOImpl();
			scheduledao.addSchedule(scheduledto);
		}
		else {
			System.out.println(ConsoleColors.RED_BOLD+"Enter valid date");
		}
		
		
	}

}
