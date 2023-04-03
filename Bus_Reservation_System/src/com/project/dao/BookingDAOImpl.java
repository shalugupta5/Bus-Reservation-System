package com.project.dao;

import java.security.Timestamp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import java.util.List;


import com.project.colors.ConsoleColors;
import com.project.dto.BookingDTO;
import com.project.dto.BookingDTOImpl;
import com.project.dto.RouteDTOImpl;
import com.project.dto.RouteScheduleDTO;
import com.project.dto.RouteScheduleDTOImpl;

import com.project.dto.ScheduleDTOImpl;
import com.project.ui.PassengerUI;



public class BookingDAOImpl implements BookingDAO{
	
	

	@Override
	public List<RouteScheduleDTO> bookTicket(String departureCity, String arrivalCity, LocalDate date) {
		List<RouteScheduleDTO> list=new ArrayList<>();
		RouteScheduleDTO routSchedule=null;
		try(Connection con = DBUtils.provideConnection()) {
			String query="SELECT * from schedules s inner join routes r on r.routeID = s.routeID inner join Buses b on s.BusID = b.BusID where s.journeyDate = ? and r.SourceLocation = ? and r.DestinationLocation = ?";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setDate(1, Date.valueOf(date));
			ps.setString(2, departureCity);
			ps.setString(3, arrivalCity);
			
			ResultSet rs=ps.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println(ConsoleColors.RED_BOLD+"No Bus Schedule available for this.");
				return null;
			}
			else {
				while(rs.next()) {
					
					routSchedule=new RouteScheduleDTOImpl(new RouteDTOImpl(rs.getInt("routeID"), rs.getString("SourceLocation"), 
					rs.getString("DestinationLocation"), rs.getInt("Distance"))
							,new ScheduleDTOImpl(rs.getInt("ScheduleID"),rs.getInt("BusID"), rs.getInt("routeID"), (rs.getDate("journeyDate").toLocalDate()),
									rs.getTime("DepartureTime").toLocalTime(), rs.getTime("ArrivalTime").toLocalTime(), rs.getInt("TotalSeats")));
				
				
					
				list.add(routSchedule);
				
				
				
			}
			}
		}catch(Exception ex) {
			System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
			
		}
		
		return list;
	}
	
	@Override
	public void cancelBooking(LocalTime now,int bookingId, int passengerID) throws ClassNotFoundException {
	    try(Connection connection = DBUtils.provideConnection()) {
	        
	        PreparedStatement statement = connection.prepareStatement(
	                "UPDATE bookings SET  status = ? WHERE BookingID = ?");
	        statement.setString(1, "Cancelled");
	        statement.setInt(2, bookingId);
	        if(statement.executeUpdate()>0) {
	        	System.out.println(ConsoleColors.RED_BOLD+"Your ticket has been cancellled,"+ConsoleColors.RED_BOLD+" we will surely refund your amount.");
	        	
	        	
	        	
	        	
	        	 PreparedStatement statement2 = connection.prepareStatement(
	 	                "SELECT s.journeyDate, s.DepartureTime, b.TotalCost, b.NumberOfSeats FROM schedules s inner join Bookings b ON s.scheduleID = b.scheduleID where BookingID =?");
	 	       
	        	 statement2.setInt(1, bookingId);
	        	
	        	 ResultSet rs=statement2.executeQuery();
	        	 
	        	 if(DBUtils.isResultSetEmpty(rs)) {
	        		 System.out.println(ConsoleColors.RED_BOLD+"No booking available");
	        	 }
	        	 else {
	        		 while(rs.next()) {
	        			 double refundAmount=0;
	        			 
	        			 LocalDate journeyDate=rs.getDate("journeyDate").toLocalDate();
	        			 LocalTime DepartureTime=rs.getTime("DepartureTime").toLocalTime();
	        			 long hours=ChronoUnit.HOURS.between(DepartureTime, now);
	        			
	        			 double totalCost=rs.getDouble("TotalCost");
	     	        	int noofseats=rs.getInt("NumberOfSeats");
	     	        	
	        			 
	        			 if (hours >= 24) {
	        	                // Full refund
	        	                refundAmount = totalCost;
	        	               
	        	            } else if (hours >= 12) {
	        	                // 50% refund
	        	                refundAmount = noofseats*((totalCost/noofseats) * 0.5);
	        	               
	        	            } else if (hours >= 6) {
	        	                // 20% refund
	        	                refundAmount = noofseats*((totalCost/noofseats) * 0.2);
	        	               
	        	            }
	        			 
	        			 PreparedStatement statement4 = connection.prepareStatement("select balance from  wallet where user_id = ?");
	        	         statement4.setInt(1, passengerID);
	        	         ResultSet rs3=statement4.executeQuery();
	        	         if(DBUtils.isResultSetEmpty(rs3)) {
	        	        	 System.out.println(ConsoleColors.RED_BOLD+" No record found");
	        	         }
	        	         else {
	        	        	 while(rs3.next()) {
	        	        		 double balance=rs3.getDouble("balance");
	        	        		
	        	        		 PreparedStatement statement3 = connection.prepareStatement("UPDATE  wallet set balance = ? where user_id=?");
	    	        	         statement3.setDouble(1, balance+refundAmount);
	    	        	         statement3.setInt(2, passengerID);
	    	        	         
	    	        	         if(statement3.executeUpdate()>0) {
	 	        		        	System.out.println(ConsoleColors.GREEN_BOLD+"Your wallet has been updated .");
	 	        		        }
	        	        	 }
	        	         }
	        			 
	        		   
	        			 
	        		 }
	        	 }
	        	
	        	
	        }
	       
	    } catch (SQLException e) {
	        System.out.println(ConsoleColors.RED_BOLD+e.getMessage());
	    }
	}

	@Override
	public List<BookingDTO> viewAllBookings() {
		
		List<BookingDTO> list = new ArrayList<>();
		
		try(Connection con = DBUtils.provideConnection()) {
			String query="SELECT * FROM bookings where Status='Booked'";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println(ConsoleColors.RED_BOLD+"No Record Found");
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
	public List<BookingDTO> viewAllBookingsWithDateRange(LocalDate startDate, LocalDate endDate) {
		List<BookingDTO> list = new ArrayList<>();
		
		try(Connection con = DBUtils.provideConnection()) {
			String query="SELECT * FROM bookings b inner join schedules s on b.scheduleID=s.scheduleID where s.journeyDate between ? and ? and b.Status='Booked'";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setDate(1, Date.valueOf(startDate));
			ps.setDate(2, Date.valueOf(endDate));
			ResultSet rs=ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println(ConsoleColors.RED_BOLD+"No Record Found");
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
	public List<BookingDTO> viewAllBookingsByBusNumber(String busNUmber) {
		List<BookingDTO> list = new ArrayList<>();
		
		try(Connection con = DBUtils.provideConnection()) {
			String query="SELECT * FROM bookings b inner join schedules s on b.scheduleID=s.scheduleID inner join buses bs on s.BusID = bs.BusID where bs.BusNumber = ?and b.Status='Booked'";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, busNUmber);
			
			ResultSet rs=ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println(ConsoleColors.RED_BOLD+"No Record Found");
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
	public List<BookingDTO> viewAllBookingsByMobileNumber(String mobileNUmber) {
		List<BookingDTO> list = new ArrayList<>();
		
		try(Connection con = DBUtils.provideConnection()) {
			String query="SELECT * FROM bookings b inner join passenger p on p.passengerID=b.passengerID where p.mobileNumber = ?and b.Status='Booked'";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, mobileNUmber);
			
			ResultSet rs=ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println(ConsoleColors.RED_BOLD+"No Record Found");
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


	
	
	

}
