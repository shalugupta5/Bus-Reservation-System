package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.dto.BusDTO;
import com.project.dto.BusDTOImpl;

public class BusDAOImpl implements BusDAO{

	@Override
	public void addBus(BusDTO bus) {
		
		try(Connection con = DBUtils.provideConnection()) {
			String query="INSERT INTO Buses (BusNumber, BusType, TotalSeats) VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bus.getBusNumber());
			ps.setString(2, bus.getBusType());
			ps.setInt(3, bus.getTotalSeats());
			
			if(ps.executeUpdate()>0) {
				System.out.println("HURRAY!, New bus added successfully.");
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public List<BusDTO> getAllBuses() {
		List<BusDTO> list=new ArrayList<>();
		
		try(Connection con = DBUtils.provideConnection()) {
			String query="SELECT * FROM Buses WHERE is_deleted = 0";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			if(DBUtils.isResultSetEmpty(rs)) {
				System.out.println("No Record Found");
			}
			
			else {
				while(rs.next()) {
					BusDTO bus = new BusDTOImpl(rs.getString("BusNumber"), rs.getString("BusType"), rs.getInt("TotalSeats"));
	                list.add(bus);
				}
			}
			
		}catch(Exception ex) {
			System.out.println("sorry error");
			System.out.println(ex.getMessage());
		}
		
		return list;
	}

//	@Override
//	public void updateBus(BusDTO bus) {
//		
//		
//	}

//	@Override
//	public void deleteBus(int busID) {
//		
//		
//	}

	
	
}
