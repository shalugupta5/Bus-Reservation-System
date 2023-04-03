package com.project.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.project.colors.ConsoleColors;
import com.project.dto.BookingDTO;
import com.project.dto.BookingDTOImpl;
import com.project.dto.BusDTO;
import com.project.dto.BusDTOImpl;
import com.project.dto.PassengerDTO;

public class PassengerDAOImpl implements PassengerDAO{
	
	
	
	@Override
	public String addPassenger(PassengerDTO passenger) {
		String username=null;
		try(Connection con = DBUtils.provideConnection()) {
			String query="INSERT into Passenger (Name, userName, mobileNumber, Password) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			 username = RandomUsernameGenerator.generate(passenger.getName(), 8);
			  
			ps.setString(1, passenger.getName());
			ps.setString(2, username);
			ps.setString(3, passenger.getMobileNumber());
			ps.setString(4, passenger.getPassword());
			
			if(ps.executeUpdate()>0) {
				System.out.println(ConsoleColors.GREEN_BOLD+"HURRAY!, New passenger added successfully.");
				
			}
			
		}catch(Exception ex) {
			System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
			
		}
		
		return username;
		
	}

	@Override
	public String searchPassenger(String username, String password) {
		String message = null;
		try(Connection con = DBUtils.provideConnection()) {
			String query="SELECT * FROM Passenger where userName = ? and password = ? and is_deleted = 0";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println(ConsoleColors.RED_BOLD+"No record Found");
			}
			else {
				message="LogIn Successful";
				System.out.println(ConsoleColors.GREEN_BOLD+"LogIn Successful");
				
			}
			
		}catch(Exception ex) {
			System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
		}
		
		return message;
		
	}
	
	
	
	@Override
	public int searchPassenger(String username) {
		int passengerID=0;
		try(Connection con = DBUtils.provideConnection()) {
			String query="SELECT passengerID FROM Passenger where userName = ? and is_deleted = 0";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println(ConsoleColors.RED_BOLD+"No record Found");
			}
			else {
				while(rs.next()) {
					passengerID=rs.getInt("passengerID");
					
				}
				
			}
			
		}catch(Exception ex) {
			System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
		}
		
		return passengerID;
		
	}

	@Override
	public void updatePassenger(PassengerDTO passenger) {
		try(Connection con = DBUtils.provideConnection()) {
			String query="UPDATE  Passenger SET Name = ?, mobileNumber = ?, Password = ? where userName = ? and is_deleted = 0";
			PreparedStatement ps = con.prepareStatement(query);
			
			
			  
			ps.setString(1, passenger.getName());			
			ps.setString(2, passenger.getMobileNumber());
			ps.setString(3, passenger.getPassword());
			ps.setString(4, passenger.getUserName());
			
			if(ps.executeUpdate()>0) {
				System.out.println(ConsoleColors.GREEN_BOLD+"HURRAY!,  passenger updated successfully.");
				
			}
			
			
		}catch(Exception ex) {
			System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
			
		}
		
	}

	@Override
	public List<BookingDTO> getBookingHistory(String username) {
		List<BookingDTO> list = new ArrayList<>();
		
		try(Connection con = DBUtils.provideConnection()) {
			String query="SELECT * FROM bookings b inner join passenger p on p.PassengerID = b.PassengerID WHERE p.userName=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println("No Record Found");
			}
			
			else {
				while(rs.next()) {
					BookingDTO booking = new BookingDTOImpl(rs.getInt("BookingID"), rs.getInt("ScheduleID"), rs.getInt("PassengerID"), rs.getInt("NumberOfSeats"), rs.getDouble("TotalCost"));
	                list.add(booking);
				}
			}
			
		}catch(Exception ex) {
			
			System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
		}
		
		return list;
	}

	@Override
	public void deletePassengerAccount(String username) {
		try(Connection con = DBUtils.provideConnection()){
			
			String query="UPDATE passenger SET is_deleted=1 where userName=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			
			if(ps.executeUpdate()>0) {
				System.out.println(ConsoleColors.GREEN_BOLD+"Passenger record deleted successfully");
			}
			
		}catch(Exception ex) {
			System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
		}
		
	}

	@Override
	public void logout() {
		LoggedInUser.loggedInUserId = 0;
		
	}
	
	
	

	
}
