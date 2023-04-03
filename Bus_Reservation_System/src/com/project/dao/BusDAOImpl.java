package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.colors.ConsoleColors;
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
				System.out.println(ConsoleColors.GREEN_BOLD+"HURRAY!, New bus added successfully.");
			}
			
		}catch(Exception ex) {
			System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
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
				System.out.println(ConsoleColors.RED_BOLD+"No Record Found");
			}
			
			else {
				while(rs.next()) {
					BusDTO bus = new BusDTOImpl(rs.getInt("BusID"), rs.getString("BusNumber"), rs.getString("BusType"), rs.getInt("TotalSeats"));
	                list.add(bus);
				}
			}
			
		}catch(Exception ex) {
			
			System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
		}
		
		return list;
	}

	@Override
	public void updateBus(BusDTO bus) {
		
		try(Connection con = DBUtils.provideConnection()){
			String query="UPDATE Buses SET BusNumber = ?, BusType = ?, TotalSeats = ? WHERE BusID = ? and is_deleted = 0";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bus.getBusNumber());
			ps.setString(2, bus.getBusType());
			ps.setInt(3, bus.getTotalSeats());
			ps.setInt(4, bus.getBusId());
			
			if(ps.executeUpdate()>0) {
				System.out.println(ConsoleColors.GREEN_BOLD+"Bus record updated successfully");
			}
			
		
		}catch(Exception ex) {
			System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
		}
		
	}

	@Override
	public void deleteBus(int busID) {
		
			try(Connection con = DBUtils.provideConnection()){
				
				String query="UPDATE Buses SET is_deleted=1 where BusID=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, busID);
				
				if(ps.executeUpdate()>0) {
					System.out.println(ConsoleColors.GREEN_BOLD+"Bus record deleted successfully");
				}
				
			}catch(Exception ex) {
				System.out.println(ConsoleColors.RED_BOLD+ex.getMessage());
			}
		
	}

	
	
}
