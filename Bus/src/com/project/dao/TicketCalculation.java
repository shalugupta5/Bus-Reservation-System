package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class TicketCalculation {
	
	public static double calculateTotalCost(int numberOfSeats, String source, String destination) {
	    return numberOfSeats * calculatePrice(source, destination);
	}
	

	
	private static double calculatePrice(String source, String destination)  {
		double distance=0;
		double pricePerKm=2;
		double price=0;
		try(Connection con = DBUtils.provideConnection()) {
			String query="Select distance from routes where SourceLocation = ? and DestinationLocation = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, source);
			ps.setString(2, destination);
			
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println("No record found or we are not available for this route.");
			}
			else {
				while(rs.next()) {
					distance=rs.getInt("Distance");
					price = distance*pricePerKm;
					return price;
				}
			}
			
		}catch(Exception ex) {
			
			System.out.println(ex.getMessage());
		}
	   
	    return price;
	}






}
