package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		        System.out.println(walletBalance);
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
		        
		        message="done";
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
		        	System.out.println("ho gya ");
		        	PreparedStatement statement2 = connection.prepareStatement("Select BookingID from bookings where PassengerID=?");
			        statement2.setInt(1, UserID);
		        	ResultSet rs=statement2.executeQuery();
		        	if(DBUtils.isResultSetEmpty(rs)) {
		        		System.out.println("No record");
		        	}
		        	else {
		        		while(rs.next()) {
		        			int booingId=rs.getInt("BookingID");
			        		System.out.println(booingId);
		        		}
		        	}
		        }
		        
		    }
		    
		} else {
		    // Insufficient balance
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
	        	System.out.println("inserted ");
	        }
	    }catch(Exception ex) {
	    	System.out.println(ex.getMessage());
	    }
	}



	@Override
	public void updateBalnce(int passengerID) {
		
		try (Connection connection = DBUtils.provideConnection()){
	    	
		    
	         PreparedStatement statement = connection.prepareStatement("UPDATE  wallet set balance = ? where user_id=?");
	         statement.setInt(1, 50000);
	         statement.setInt(2, passengerID);
	        
	        
	        
	       
	         if(statement.executeUpdate()>0) {
		        	System.out.println("updated ");
		        }
	    }catch(Exception ex) {
	    	System.out.println(ex.getMessage());
	    }
	}
	
	
	
	
	
	
	
	
	

}
