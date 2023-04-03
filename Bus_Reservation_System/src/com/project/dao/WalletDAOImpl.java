package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.colors.ConsoleColors;

public class WalletDAOImpl implements WalletDAO{
	
	@Override
	public String balanceDeduct(int UserID, int scheduleID, int noOfSeats, double ticketPrice) throws ClassNotFoundException, SQLException{
		// Retrieve user's wallet balance
		String message=null;
		//int userId = 1; // user's ID
		//float ticketPrice = 50.0f; // ticket price
		float walletBalance = 0.0f;
		try (Connection connection = DBUtils.provideConnection()){
			
		
		     PreparedStatement statement = connection.prepareStatement("SELECT balance FROM wallet WHERE user_id = ?");
		    statement.setInt(1, UserID);
		    ResultSet result = statement.executeQuery();
		    if (result.next()) {
		        walletBalance = result.getFloat("balance");
		        System.out.println(ConsoleColors.GREEN_BOLD+"Your wallet balance : "+walletBalance);
		    }
		     }
		

		// Check if user has sufficient balance
		if (walletBalance >= ticketPrice) {
		    // Update wallet balance
		    try (Connection connection = DBUtils.provideConnection()){
		    	
		    
		         PreparedStatement statement = connection.prepareStatement("UPDATE wallet SET balance = ? WHERE user_id = ?");
		        statement.setFloat(1, walletBalance - (float)ticketPrice);
		        statement.setInt(2, UserID);
		        statement.executeUpdate();
		        
		        message="Updated";
		    }
		

		    // Add booking to database
		    try (Connection connection = DBUtils.provideConnection()){
		    	
		    
		         PreparedStatement statement = connection.prepareStatement("INSERT INTO bookings (PassengerID, ScheduleID, NumberOfSeats,TotalCost) VALUES (?, ?, ?,?)");
		        statement.setInt(1, UserID);
		        statement.setInt(2, scheduleID);
		        statement.setInt(3, noOfSeats);
		        statement.setDouble(4, ticketPrice);
		        
		        
		       // statement.setArray(3, connection.createArrayOf("VARCHAR", seatNumbers));
		        if(statement.executeUpdate()>0) {
		        	
		        	PreparedStatement statement2 = connection.prepareStatement("Select BookingID from bookings where PassengerID=?");
			        statement2.setInt(1, UserID);
		        	ResultSet rs=statement2.executeQuery();
		        	if(DBUtils.isResultSetEmpty(rs)) {
		        		System.out.println(ConsoleColors.RED_BOLD+"No record found");
		        	}
		        	else {int booingId=0;
		        		while(rs.next()) {
		        			 booingId=rs.getInt("BookingID");
			        		//System.out.println(ConsoleColors.YELLOW_BOLD+"Your bookingID : "+booingId);
		        		}
		        		if(booingId==0) {
		        			System.out.println(ConsoleColors.RED_BOLD+"SomeThingWrong");
		        		}else {
		        			System.out.println(ConsoleColors.YELLOW_BOLD+"Your bookingID : "+booingId);
		        		}
		        		
		        	}
		        }
		        
		    }
		    
		} else {
		    
			message=null;
		    System.out.println("Error: Insufficient balance");
		}

		return message;
	}

	
	
	@Override
	public void addBalnce(int passengerID) throws ClassNotFoundException, SQLException {
		
		try (Connection connection = DBUtils.provideConnection()){
	    	
		    
	         PreparedStatement statement = connection.prepareStatement("INSERT INTO wallet (user_id) VALUES (?)");
	        statement.setInt(1, passengerID);
	        
	        
	        
	       
	        if(statement.executeUpdate()>0) {
	        	System.out.println(ConsoleColors.GREEN_BOLD+"Record inserted successfully");
	        }
	    }catch(Exception ex) {
	    	System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
	    }
	}



	@Override
	public void updateBalnce(int passengerID,double amount) {
		
		try (Connection connection = DBUtils.provideConnection()){
	    	
		    
	         PreparedStatement statement = connection.prepareStatement("UPDATE  wallet set balance = ? where user_id=?");
	         statement.setDouble(1, amount);
	         statement.setInt(2, passengerID);
	        
	        
	        
	       
	         if(statement.executeUpdate()>0) {
		        	System.out.println(ConsoleColors.GREEN_BOLD+"Wallet updated successfully");
		        }
	    }catch(Exception ex) {
	    	System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
	    }
	}
	
	
	
	
	
	
	
	
	

}
