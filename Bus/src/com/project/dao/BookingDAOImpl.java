package com.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import com.project.dto.BookingDTO;
import com.project.dto.RouteDTOImpl;
import com.project.dto.RouteScheduleDTO;
import com.project.dto.RouteScheduleDTOImpl;

import com.project.dto.ScheduleDTOImpl;
import com.project.ui.PassengerUI;



public class BookingDAOImpl implements BookingDAO{
	
	private static int passengerID;
	private static String username;
	private static int scheduleID;
	
	public static void getPassengerID() {
		try(Connection con=DBUtils.provideConnection()) {
			String query="SELECT passangerID from passenger where userName=?";
			PreparedStatement ps=con.prepareStatement(query);
			username=PassengerUI.getPassengerID();
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println("No passenger Found");
			}
			else {
				while(rs.next()) {
					passengerID=rs.getInt("PassengerID");
				}
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	

	@Override
	public List<RouteScheduleDTO> bookTicket(String departureCity, String arrivalCity, LocalDate date) {
		List<RouteScheduleDTO> list=new ArrayList<>();
		RouteScheduleDTO routSchedule=null;
		try(Connection con = DBUtils.provideConnection()) {
			String query="SELECT * from schedules s inner join routes r on r.routeID = s.routeID where s.journeyDate = ? and r.SourceLocation = ? and r.DestinationLocation = ?";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setDate(1, Date.valueOf(date));
			ps.setString(2, departureCity);
			ps.setString(3, arrivalCity);
			
			ResultSet rs=ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println("No record found");
			}
			else {
				while(rs.next()) {
					scheduleID=rs.getInt("ScheduleID");
					routSchedule=new RouteScheduleDTOImpl(new RouteDTOImpl(rs.getInt("routeID"), rs.getString("SourceLocation"), 
					rs.getString("DestinationLocation"), rs.getInt("Distance"))
							,new ScheduleDTOImpl(rs.getInt("ScheduleID"),rs.getInt("BusID"), rs.getInt("routeID"), (rs.getDate("journeyDate").toLocalDate()),
									rs.getTime("DepartureTime").toLocalTime(), rs.getTime("ArrivalTime").toLocalTime()));
				
				
					
				list.add(routSchedule);
				
				
			}
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
	
	

	@Override
	public void addBooking(BookingDTO booking) {
		try(Connection con = DBUtils.provideConnection()){
			String query="INSERT INTO Bookings (PassengerID, ScheduleID, NumberOfSeats, TotalCost) VALUES (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			getPassengerID();
			ps.setInt(1, passengerID);
			ps.setInt(2, scheduleID);
			ps.setInt(3, booking.getNumberOfSeats());
			ps.setDouble(4, booking.getTotalCost());
			
			if(ps.executeUpdate()>0) {
				System.out.println("Booking created ssuccessfully");
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	
	

}
