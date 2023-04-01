package com.project.ui;

import java.util.Scanner;

import com.project.dao.BookingDAO;
import com.project.dao.BookingDAOImpl;
import com.project.dao.PassengerDAO;
import com.project.dao.PassengerDAOImpl;
import com.project.dto.PassengerDTO;
import com.project.dto.PassengerDTOImpl;

public class PassengerUI {

	static String username;
	private Scanner sc;

	public PassengerUI(Scanner sc) {
		super();
		this.sc = sc;
	}
	
	public void addPassenger() {
		System.out.println("Enter Name");
		String Name=sc.next();
		
		System.out.println("Enter Password");
		String Password=sc.next();
		
		System.out.println("Enter MobileNumber");
		String MobileNumber=sc.next();
		
		PassengerDTO passengerdto = new PassengerDTOImpl(Name, MobileNumber, Password);
		PassengerDAO passengerdao = new PassengerDAOImpl();
		
		 username = passengerdao.addPassenger(passengerdto);
		if(username!=null) {
			System.out.println("Here is your username please note it down.");
			System.out.println();
			System.out.println(username);
			System.out.println();
		}
		
		
		
	}
	
	public String searchPassenger() {
		System.out.println("Enter userName");
		String userName=sc.next();
		
		System.out.println("Enter Password");
		String Password=sc.next();
		
		
		
		PassengerDTO passengerdto = new PassengerDTOImpl();
		PassengerDAO passengerdao = new PassengerDAOImpl();
		
		String message = passengerdao.searchPassenger(userName, Password);
		
		return message;
		
	}
	
	public static String getPassengerID() {
		
		String username=PassengerUI.username;
		return username;
	}
	
}
