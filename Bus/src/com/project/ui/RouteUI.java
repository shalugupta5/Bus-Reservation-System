package com.project.ui;

import java.util.Scanner;

import com.project.dao.RouteDAO;
import com.project.dao.RouteDAOImpl;
import com.project.dto.RouteDTO;
import com.project.dto.RouteDTOImpl;

public class RouteUI {
	
	private Scanner sc;

	public RouteUI(Scanner sc) {
		super();
		this.sc = sc;
	}
	
	public void addRoute() {
		System.out.println("Enter Source Location");
		String SourceLocation=sc.next();
		
		System.out.println("Enter Destination Location");
		String DestinationLocation=sc.next();
		
		System.out.println("Enter distance between source and destination");
		int distance=sc.nextInt();	
		
		
		RouteDTO routedto = new RouteDTOImpl(SourceLocation, DestinationLocation, distance);
		RouteDAO routedao = new RouteDAOImpl();
		routedao.addRoute(routedto);
		
	}
	
	public void updateRoute() {
		System.out.println("Enter RouteID");
		int RouteID=sc.nextInt();
		
		System.out.println("Enter Source Location");
		String SourceLocation=sc.next();
		
		System.out.println("Enter Destination Location");
		String DestinationLocation=sc.next();
		
		System.out.println("Enter distance between source and destination");
		int distance=sc.nextInt();	
		
		RouteDTO routedto = new RouteDTOImpl(RouteID, SourceLocation, DestinationLocation, distance);
		RouteDAO routedao = new RouteDAOImpl();
		routedao.updateRoute(routedto);
	}
	
	public void deleteRoute() {
		System.out.println("Enter RouteID");
		int RouteID=sc.nextInt();
		
		RouteDAO routedao = new RouteDAOImpl();
		routedao.deleteRoute(RouteID);
	}

}
