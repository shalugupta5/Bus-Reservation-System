package com.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import com.project.colors.ConsoleColors;
import com.project.dto.ScheduleDTO;

public class ScheduleDAOImpl implements ScheduleDAO{

	@Override
	public void addSchedule(ScheduleDTO schedule) {
		try(Connection con = DBUtils.provideConnection()){
			String query1="select TotalSeats from buses where BusID=?";
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.setInt(1, schedule.getBusId());
			
			ResultSet rs=ps1.executeQuery();
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println(ConsoleColors.RED_BOLD+"No record found");
			}
			else {
				while(rs.next()) {
					schedule.setAvailableSeats(rs.getInt("TotalSeats"));
					
					String query="INSERT INTO schedules (BusID, RouteID, DepartureTime, ArrivalTime, JourneyDate, AvailableSeats) VALUES (?, ?, ?, ?, ?,?)";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, schedule.getBusId());
					ps.setInt(2, schedule.getRouteId());
					ps.setTime(3, Time.valueOf(schedule.getDepartureTime()));
					ps.setTime(4, Time.valueOf(schedule.getArrivalTime()));
					ps.setDate(5, Date.valueOf(schedule.getJourneyDate()));
					ps.setInt(6, schedule.getAvailableSeats());
					if(ps.executeUpdate()>0) {
						System.out.println(ConsoleColors.GREEN_BOLD+"New schedule added successfully");
					}
				}
			
			
				
			}
			
			
		}catch(Exception ex) {
			System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
		}
		
	}

}
