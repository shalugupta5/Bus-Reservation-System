package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.project.dto.RouteDTO;

public class RouteDAOImpl implements RouteDAO{

	@Override
	public void addRoute(RouteDTO route) {
		try(Connection con = DBUtils.provideConnection()){
			
			String query="INSERT INTO Routes (SourceLocation, DestinationLocation, Distance) VALUES (?, ?, ?) ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, route.getSourceLocation());
			ps.setString(2, route.getDestinationLocation());
			ps.setInt(3, route.getDistance());
			
			if(ps.executeUpdate()>0) {
				System.out.println("New route inserted successfully");
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void updateRoute(RouteDTO route) {
			try(Connection con = DBUtils.provideConnection()){
			
			String query="UPDATE Routes SET SourceLocation = ?, DestinationLocation = ?, Distance = ? WHERE RouteID = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, route.getSourceLocation());
			ps.setString(2, route.getDestinationLocation());
			ps.setInt(3, route.getDistance());
			ps.setInt(4, route.getRouteID());
			
			if(ps.executeUpdate()>0) {
				System.out.println("New route updated successfully");
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void deleteRoute(int routeID) {
		try(Connection con = DBUtils.provideConnection()){
			
			String query="UPDATE Routes SET is_deleted=1 where RouteID=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, routeID);
			
			if(ps.executeUpdate()>0) {
				System.out.println("Route record deleted successfully");
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	

}
