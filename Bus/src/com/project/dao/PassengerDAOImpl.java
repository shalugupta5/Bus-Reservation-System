package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
				System.out.println("HURRAY!, New passenger added successfully.");
				
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			
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
				System.out.println("No record Found");
			}
			else {
				message="LogIn Successful";
				System.out.println("LogIn Successful");
				
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return message;
		
	}

	
}
