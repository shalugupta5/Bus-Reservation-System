package com.project.ui;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.project.dao.BookingDAO;
import com.project.dao.BookingDAOImpl;
import com.project.dao.PassengerDAO;
import com.project.dao.PassengerDAOImpl;
import com.project.dao.RouteDAO;
import com.project.dao.RouteDAOImpl;
import com.project.dao.TicketCalculation;
import com.project.dao.WalletDAO;
import com.project.dao.WalletDAOImpl;
import com.project.dto.BookingDTO;
import com.project.dto.BookingDTOImpl;
import com.project.dto.RouteScheduleDTO;

public class BookingUI {
	
	private Scanner sc;
	

	//
	public BookingUI(Scanner sc) {
		super();
		this.sc = sc;
	}
	
	public static void addBalnce(int passengerID) throws ClassNotFoundException, SQLException {
		WalletDAO walletdao = new WalletDAOImpl();
		walletdao.addBalnce(passengerID);
		
		
	}
	
	public static void updateBalnce(int passengerID) {
		
		WalletDAO walletdao = new WalletDAOImpl();
		walletdao.updateBalnce(passengerID);
		
	}
	
	
	public void cancelTicket() throws ClassNotFoundException {
		System.out.println("Enter your booking id");
		int bookingID=sc.nextInt();
		
		BookingDAO booking  = new BookingDAOImpl();
		
		 LocalTime now = LocalTime.now();
		
		booking.cancelBooking(now ,bookingID,7);
		
		
	}
	
	
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Scanner sc=new Scanner(System.in);
//		
	public void bookTicket() throws ClassNotFoundException, SQLException {
		System.out.println("Enter the departure city:");
		String departureCity = sc.next();
		System.out.println("Enter the arrival city:");
		String arrivalCity = sc.next();
		System.out.println("Enter the date (YYYY-MM-DD):");
//		String dateStr = sc.nextLine();
		LocalDate date = LocalDate.parse(sc.next());
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
		
		
		System.out.println("Please confirm your username");	
		String username=sc.next();
		
		PassengerDAO passengerdao=new PassengerDAOImpl();
		
		int passengerID=passengerdao.searchPassenger(username);
		System.out.println(passengerID);
		
		WalletDAO walletdao = new WalletDAOImpl();
		String mess=walletdao.balanceDeduct(passengerID, ScheduleID, noOfSeats, ticketPrice);
		
		if(mess==null) {
			System.out.println("Insufficient balance please add some balance or may be you do not have wallet facility please create your wallet account.");
			System.out.println("Enter selection 1 or 2");
			int bal=sc.nextInt();
			if(bal==1) {
				BookingUI.addBalnce(passengerID);
			}
			else if(bal==2) {
				BookingUI.updateBalnce(passengerID);
			}
			
		}
	
	}
	
	public void viewAllBookings() {
		BookingDAO bookingdao = new BookingDAOImpl();
		List<BookingDTO> list = bookingdao.viewAllBookings();
		System.out.println(list);
	}
	
	
	public void viewAllBookingsWithDateRange() {
		
		System.out.println("Enter date where you want to start.");
		LocalDate startDate=LocalDate.parse(sc.next());
		
		System.out.println("Enter date where you want to end.");
		LocalDate endDate=LocalDate.parse(sc.next());
		
		BookingDAO bookingdao = new BookingDAOImpl();
		List<BookingDTO> list = bookingdao.viewAllBookingsWithDateRange(startDate, endDate);
		System.out.println(list);
	}
	
	public void viewAllBookingsByBusNumber() {
		System.out.println("Enter busNumber.");
		String busNumber = sc.next();
		
		BookingDAO bookingdao = new BookingDAOImpl();
		List<BookingDTO> list = bookingdao.viewAllBookingsByBusNumber(busNumber);
		System.out.println(list);
		
	}
	
	public void viewAllBookingsByMobileNumber() {
		System.out.println("Enter mobileNumber.");
		String mobileNumber = sc.next();
		
		BookingDAO bookingdao = new BookingDAOImpl();
		List<BookingDTO> list = bookingdao.viewAllBookingsByMobileNumber(mobileNumber);
		System.out.println(list);
	}
	
	
}
