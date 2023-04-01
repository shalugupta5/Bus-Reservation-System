package com.project.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.project.dao.BookingDAO;
import com.project.dao.BookingDAOImpl;
import com.project.dao.RouteDAO;
import com.project.dao.RouteDAOImpl;
import com.project.dao.TicketCalculation;
import com.project.dto.BookingDTO;
import com.project.dto.BookingDTOImpl;
import com.project.dto.RouteScheduleDTO;

public class BookingUI {
	
//	private Scanner sc;
//
//	public BookingUI(Scanner sc) {
//		super();
//		this.sc = sc;
//	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	
//	public void bookTicket() {
		System.out.println("Enter the departure city:");
		String departureCity = sc.nextLine();
		System.out.println("Enter the arrival city:");
		String arrivalCity = sc.nextLine();
		System.out.println("Enter the date (YYYY-MM-DD):");
		String dateStr = sc.nextLine();
		LocalDate date = LocalDate.parse(dateStr);
		BookingDAO booking  = new BookingDAOImpl();
		List<RouteScheduleDTO> li = booking.bookTicket(departureCity, arrivalCity, date);
		System.out.println("Available schedules:");
		System.out.println(li);
		
		System.out.println();
		
		System.out.println("Enter ScheduleID");
		int ScheduleID=sc.nextInt();
		
		System.out.println("Enter the number of seats you want to book ");
		int noOfSeats=sc.nextInt();
		
		double ticketPrice = TicketCalculation.calculateTotalCost(noOfSeats, departureCity, arrivalCity);
		System.out.println(ticketPrice);
		
		BookingDTO bookdto=new BookingDTOImpl(0, 0, 0, noOfSeats, ticketPrice);
		BookingDAO bookdao = new BookingDAOImpl();
		
		
		System.out.println("enter 1 for confirm");
		int n=sc.nextInt();
		
		if(n==1) {
			bookdao.addBooking(bookdto);
		}
	//}
	
	}
	
}
