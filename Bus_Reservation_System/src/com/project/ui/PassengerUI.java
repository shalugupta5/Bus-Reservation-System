package com.project.ui;

import java.util.List;
import java.util.Scanner;

import com.project.colors.ConsoleColors;
import com.project.dao.BookingDAO;
import com.project.dao.BookingDAOImpl;
import com.project.dao.PassengerDAO;
import com.project.dao.PassengerDAOImpl;
import com.project.dto.BookingDTO;
import com.project.dto.PassengerDTO;
import com.project.dto.PassengerDTOImpl;

public class PassengerUI {

	public static String userName;
	private Scanner sc;

	public PassengerUI(Scanner sc) {
		super();
		this.sc = sc;
	}
	
	public void addPassenger() {
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter Name");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String Name=sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter Password");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String Password=sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter MobileNumber");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String MobileNumber=sc.next();
		
		PassengerDTO passengerdto = new PassengerDTOImpl(Name, MobileNumber, Password);
		PassengerDAO passengerdao = new PassengerDAOImpl();
		
		 String username = passengerdao.addPassenger(passengerdto);
		if(username!=null) {
			System.out.println();
			System.out.println(ConsoleColors.YELLOW_BOLD+"Here is your username please note it down.");
			System.out.println(ConsoleColors.BLACK_BOLD);
			System.out.println("+---------------------------+");
			System.out.println(ConsoleColors.BLUE_BOLD);
			System.out.println("| Username :  "+ConsoleColors.GREEN_BOLD+username   + "|");
			System.out.println(ConsoleColors.BLACK_BOLD);
			System.out.println("+---------------------------+");
			
		
			System.out.println();
		}
		
		//new BookingUI(username);
		
	}
	
	public String searchPassenger() {
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter userName");
		System.out.println(ConsoleColors.GREEN_BOLD);
		 userName=sc.next();
		
		 System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter Password");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String Password=sc.next();
		
		
		
		PassengerDTO passengerdto = new PassengerDTOImpl();
		PassengerDAO passengerdao = new PassengerDAOImpl();
		
		String message = passengerdao.searchPassenger(userName, Password);
		
		return message;
		
	}
	
	
		
	
	
	
	public void updatePassenger() {
//		System.out.println("Enter your userName");
//		String userName=sc.next();
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter Name");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String Name=sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter Password");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String Password=sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD);
		System.out.println("Enter MobileNumber");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String MobileNumber=sc.next();
		
		PassengerDTO passengerdto = new PassengerDTOImpl(0, Name, userName, MobileNumber, Password);
		PassengerDAO passengerdao = new PassengerDAOImpl();
		passengerdao.updatePassenger(passengerdto);
	}
	
	public void getBookingHistory() {
		PassengerDAO passengerdao = new PassengerDAOImpl();
		List<BookingDTO> list = passengerdao.getBookingHistory(userName);
		System.out.println(list);
	}
	
	public void deletePassengerAccount() {
		PassengerDAO passengerdao = new PassengerDAOImpl();
		passengerdao.deletePassengerAccount(userName);
	}
	
	public void logout() {
		PassengerDAO passengerdao = new PassengerDAOImpl();
		passengerdao.logout();
	}
}
