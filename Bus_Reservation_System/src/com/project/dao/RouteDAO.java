package com.project.dao;

import com.project.dto.RouteDTO;

public interface RouteDAO {

	public void addRoute(RouteDTO route);
		
	public void updateRoute(RouteDTO route);
	
	public void deleteRoute(int routeID);
}
