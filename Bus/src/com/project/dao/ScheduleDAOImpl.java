package com.project.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;

import com.project.dto.ScheduleDTO;

public class ScheduleDAOImpl implements ScheduleDAO{

	@Override
	public void addSchedule(ScheduleDTO schedule) {
		try(Connection con = DBUtils.provideConnection()){
			String query="INSERT INTO schedules (BusID, RouteID, DepartureTime, ArrivalTime, JourneyDate) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, schedule.getBusId());
			ps.setInt(2, schedule.getRouteId());
			ps.setTime(3, Time.valueOf(schedule.getDepartureTime()));
			ps.setTime(4, Time.valueOf(schedule.getArrivalTime()));
			ps.setDate(5, Date.valueOf(schedule.getJourneyDate()));
			if(ps.executeUpdate()>0) {
				System.out.println("New schedule added successfully");
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
