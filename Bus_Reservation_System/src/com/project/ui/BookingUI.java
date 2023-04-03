package com.project.ui;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.project.colors.ConsoleColors;
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
	
	private static Scanner sc;
	

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
		
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter amount you want to add in your wallet");
		
		System.out.println(ConsoleColors.GREEN_BOLD);
		double amount=sc.nextDouble();
		
		WalletDAO walletdao = new WalletDAOImpl();
		walletdao.updateBalnce(passengerID,amount);
		
	}
	
	
	public void cancelTicket() throws ClassNotFoundException {
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter your booking id");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int bookingID=sc.nextInt();
		
		PassengerDAO passengerdao=new PassengerDAOImpl();
		int passengerID = passengerdao.searchPassenger(PassengerUI.userName);
		
		BookingDAO booking  = new BookingDAOImpl();
		
		 LocalTime now = LocalTime.now();
		
		booking.cancelBooking(now ,bookingID,passengerID);
		
		
	}
	
	
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Scanner sc=new Scanner(System.in);
//		
	public void bookTicket() throws ClassNotFoundException, SQLException {
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter the departure city:");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String departureCity = sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter the arrival city:");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String arrivalCity = sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter the date (YYYY-MM-DD):");
		System.out.println(ConsoleColors.GREEN_BOLD);
//		String dateStr = sc.nextLine();
		LocalDate date = LocalDate.parse(sc.next());
		
		
		 if(date.isAfter(LocalDate.now())){
			
		
		
		BookingDAO booking  = new BookingDAOImpl();
		List<RouteScheduleDTO> li = booking.bookTicket(departureCity, arrivalCity, date);
		System.out.println(ConsoleColors.BLACK_BOLD);
		if(li!=null) {
			
		
		System.out.println("Available schedules:");
		System.out.println(ConsoleColors.GREEN_BOLD);
		System.out.println(li);
		
		System.out.println();
		
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter ScheduleID");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int ScheduleID=sc.nextInt();
		
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter the number of seats you want to book ");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int noOfSeats=sc.nextInt();
		
		
		
		double ticketPrice = TicketCalculation.calculateTotalCost(noOfSeats, departureCity, arrivalCity);
		System.out.println(ConsoleColors.YELLOW_BOLD+"Your Total Cost :"+ConsoleColors.GREEN_BOLD+ticketPrice);
		
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Please confirm your username");	
		System.out.println(ConsoleColors.GREEN_BOLD);
		String username=sc.next();
		
		PassengerDAO passengerdao=new PassengerDAOImpl();
		
		int passengerID=passengerdao.searchPassenger(username);
		System.out.println(passengerID);
		
		WalletDAO walletdao = new WalletDAOImpl();
		String mess=walletdao.balanceDeduct(passengerID, ScheduleID, noOfSeats, ticketPrice);
		
		if(mess==null) {
			System.out.println(ConsoleColors.RED_BOLD+"Insufficient balance please add some balance or may be you do not have wallet facility please create your wallet account.");
			System.out.println(ConsoleColors.BLACK_BOLD+"Enter selection: \n1. Create Wallet Account \n2. Add balance");
			int bal=sc.nextInt();
			if(bal==1) {
				BookingUI.addBalnce(passengerID);
			}
			else if(bal==2) {
				BookingUI.updateBalnce(passengerID);
			}
			else {
				System.out.println(ConsoleColors.RED_BOLD+"Invalid Selelction");
			}
			
		}
		else {
			System.out.println();
		}
		
//		 else {
//				System.out.println(ConsoleColors.RED_BOLD+"Enter valid date, this has been passed.");
//			}
		 }
		
		else {
			 Main.passengerMenu(sc);
		 }
		
		 }
		 
		 else {
			System.out.println(ConsoleColors.RED_BOLD+"Enter valid date, this has been passed.");
		}
//		 else {
//			 Main.passengerMenu(sc);
//		 }
	
	}
	
	public void viewAllBookings() {
		BookingDAO bookingdao = new BookingDAOImpl();
		List<BookingDTO> list = bookingdao.viewAllBookings();
		System.out.println(ConsoleColors.BLACK_BOLD+"Here you go.");
		System.out.println(ConsoleColors.YELLOW_BOLD+list);
		
	}
	
	
	public void viewAllBookingsWithDateRange() {
		
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter date where you want to start.");
		System.out.println(ConsoleColors.GREEN_BOLD);
		LocalDate startDate=LocalDate.parse(sc.next());
		
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter date where you want to end.");
		System.out.println(ConsoleColors.GREEN_BOLD);
		LocalDate endDate=LocalDate.parse(sc.next());
		
		BookingDAO bookingdao = new BookingDAOImpl();
		List<BookingDTO> list = bookingdao.viewAllBookingsWithDateRange(startDate, endDate);
		System.out.println(ConsoleColors.BLACK_BOLD+"Here you go.");
		System.out.println(ConsoleColors.YELLOW_BOLD+list);
		
	}
	
	public void viewAllBookingsByBusNumber() {
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter busNumber.");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String busNumber = sc.next();
		
		BookingDAO bookingdao = new BookingDAOImpl();
		List<BookingDTO> list = bookingdao.viewAllBookingsByBusNumber(busNumber);
		System.out.println(ConsoleColors.BLACK_BOLD+"Here you go.");
		System.out.println(ConsoleColors.YELLOW_BOLD+list);
		
	}
	
	public void viewAllBookingsByMobileNumber() {
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter mobileNumber.");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String mobileNumber = sc.next();
		
		BookingDAO bookingdao = new BookingDAOImpl();
		List<BookingDTO> list = bookingdao.viewAllBookingsByMobileNumber(mobileNumber);
		System.out.println(ConsoleColors.BLACK_BOLD+"Here you go.");
		System.out.println(ConsoleColors.YELLOW_BOLD+list);
	}
	
	
}
