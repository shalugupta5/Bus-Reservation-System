package com.project.ui;

import java.util.Scanner;

public class Main {
	
	private static BusUI busUI;
	
	public static void adminLogIn(Scanner sc) {
		
		System.out.println("Enter your username");
		String username=sc.next();
		
		System.out.println("Enter your password");
		String password=sc.next();
		
		if(username.equals("admin") && password.equals("admin")) {
			System.out.println("Welcome Admin, hope you are doing good.");
			System.out.println("");
			adminMenu(sc);
		}
		
		else {
			System.out.println("Wrong credentials , please check your username and password");
		}
				
	}
	
	public static void adminMenu(Scanner sc) {
		
		System.out.println("Hey Admin, what do you want to perform? please select.");
		
		System.out.println("1. Add new bus");
		System.out.println("2. Add new schedule");
		System.out.println("3. Add new route");
		System.out.println("4. Update bus details");
		System.out.println("5. Delete bus details");
		System.out.println("6. View All bookings");
		System.out.println("7. View bookings for a date range");
		System.out.println("8. View bookings by BusName");
		System.out.println("9. View bookings by mobileNo of Passenger");
		System.out.println("10. LogOut");
		
		displayAdminMenu(sc);
		
	}
	
	public static void displayAdminMenu(Scanner sc) {
		busUI=new BusUI(sc);
		
		int choice=sc.nextInt();
		
		
		do {
			switch(choice) {
		
		case 1:
			busUI.addBusUI();
			break;
			
		}
		}while(choice!=0);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter your role selection : \n1. Administrator\n2. Passenger");
		int role=sc.nextInt();
		
		do{
			switch(role) {
			case 1:
				adminLogIn(sc);
				
			}
			
		}while(role!=0);
		
	
		
		
		
		
		
		
//		busUI=new BusUI(sc);
//		
//		System.out.println("Enter your selection choice");
//		int choice=sc.nextInt();
//		
//		switch(choice) {
//		
//		case 1:
//			busUI.addBusUI();
//			break;
//			
//		case 2:
//			busUI.displayAllBuses();
//			break;
//			
//		default :
//			break;
//		}
		
		
	}
	
	
	
}
