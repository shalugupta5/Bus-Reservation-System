package com.project.ui;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	private static BusUI busUI;
	private static PassengerUI passengerUI;
	private static RouteUI routeUI;
	private static ScheduleUI scheduleUI;
	private static BookingUI bookingUI;

	public static void adminLogIn(Scanner sc) {

		System.out.println("Enter your username");
		String username = sc.next();

		System.out.println("Enter your password");
		String password = sc.next();

		if (username.equals("admin") && password.equals("admin")) {
			System.out.println("Welcome Admin, hope you are doing good.");
			System.out.println("");
			adminMenu(sc);
		}

		else {
			System.out.println("Wrong credentials , please check your username and password");
		}

	}
	
	

	public static void displayAdminMenu() {

		System.out.println("Hey Admin, what do you want to perform? please select.");
		System.out.println();
		System.out.println("1. Add new bus");
		System.out.println("2. Add new schedule");
		System.out.println("3. Add new route");
		System.out.println("4. Update bus details");
		System.out.println("5. Delete bus details");
		System.out.println("6. Update route details");
		System.out.println("7. Delete route details");
		System.out.println("8. View All bookings");
		System.out.println("9. View bookings for a date range");
		System.out.println("10. View bookings by BusNumber");
		System.out.println("11. View bookings by mobileNo of Passenger");
		System.out.println("0. for Exit");
		System.out.println();

	}

	public static void adminMenu(Scanner sc) {
		int choice = 0;

		do {
			displayAdminMenu();
			choice = sc.nextInt();

			switch (choice) {

			case 0:
				System.out.println("Bye Bye admin");
				break;

			case 1:
				busUI.addBusUI();
				break;

			case 2:
				scheduleUI.addSchedule();
				break;
				
			case 3:
				routeUI.addRoute();
				break;
			
			case 4:
				busUI.updateBus();
				break;
				
			case 5:
				busUI.deleteBus();
				break;
				
			case 6:
				routeUI.updateRoute();
				break;
				
			case 7:
				routeUI.deleteRoute();
				break;
				
			case 8:
				bookingUI.viewAllBookings();
				break;
				
			case 9:
				bookingUI.viewAllBookingsWithDateRange();
				break;
				
			case 10:
				bookingUI.viewAllBookingsByBusNumber();
				break;
				
			case 11:
				bookingUI.viewAllBookingsByMobileNumber();
				break;
			}

		} while (choice != 0);
	}
	
	
	public static void passengerDisplayMenu() {

		System.out.println("Hey passenger, what do you want to perform? please select.");
		System.out.println();
		System.out.println("1. View all buses");
		System.out.println("2. Book tickets");
		System.out.println("3. Cancel ticket");
		System.out.println("4. Update your passenger details");
		System.out.println("5. View tickets booking history");
		System.out.println("6. Delete your passenger account");
		System.out.println("7. Logout");
		System.out.println("0. for Exit");
		System.out.println();

	}
	
	public static void passengerMenu(Scanner sc) throws ClassNotFoundException, SQLException {
		int choice=0;
		
		do {
			passengerDisplayMenu();
			choice= sc.nextInt();
			
			switch(choice) {
			case 0:
				System.out.println("Thank you!!");
				break;
				
			case 1:
				busUI.displayAllBuses();
				break;
				
			case 2:
				bookingUI.bookTicket();
				break;
				
			case 3:
				bookingUI.cancelTicket();
				break;
				
			case 4:
				passengerUI.updatePassenger();
				break;
				
			case 5:
				passengerUI.getBookingHistory();
				break;
				
			case 6:
				passengerUI.deletePassengerAccount();
				break;
				
			}
		}while(choice!=0);
	}

		public static void passenger(Scanner sc) throws ClassNotFoundException, SQLException {
			int choice=0;
			
			do {
				System.out.println("1. Ragister\n2. LogIn");
				choice=sc.nextInt();
				
				switch(choice) {
				
				case 0:
					System.out.println("Thank You!!");
					break;
				
				case 1:
					passengerUI.addPassenger();
					break;
					
				case 2:
					String message = passengerUI.searchPassenger();
					if(message !=null) {
						passengerMenu(sc);
					}
					break;
				}
			}while(choice!=0);
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		busUI = new BusUI(sc);
		passengerUI = new PassengerUI(sc);
		routeUI = new RouteUI(sc);
		scheduleUI = new ScheduleUI(sc);
		bookingUI = new BookingUI(sc);

		int choice = 0;
		do {
			System.out.println("Enter your role selection : \n1. Administrator\n2. Passenger\n0. Exit");
			choice = sc.nextInt();

			switch (choice) {
			case 0:
				System.out.println("Thank you! Hope you like our service please visit again.");
				break;

			case 1:
				adminLogIn(sc);
				break;
				
			case 2:
				passenger(sc);
			}

		} while (choice != 0);
		sc.close();



	}

}
