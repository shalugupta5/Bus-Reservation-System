package com.project.ui;

import java.util.Scanner;

import com.project.colors.ConsoleColors;
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
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter Source Location");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String SourceLocation=sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter Destination Location");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String DestinationLocation=sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter distance between source and destination");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int distance=sc.nextInt();	
		
		
		RouteDTO routedto = new RouteDTOImpl(SourceLocation, DestinationLocation, distance);
		RouteDAO routedao = new RouteDAOImpl();
		routedao.addRoute(routedto);
		
	}
	
	public void updateRoute() {
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter RouteID");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int RouteID=sc.nextInt();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter Source Location");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String SourceLocation=sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter Destination Location");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String DestinationLocation=sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter distance between source and destination");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int distance=sc.nextInt();	
		
		RouteDTO routedto = new RouteDTOImpl(RouteID, SourceLocation, DestinationLocation, distance);
		RouteDAO routedao = new RouteDAOImpl();
		routedao.updateRoute(routedto);
	}
	
	public void deleteRoute() {
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter RouteID");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int RouteID=sc.nextInt();
		
		RouteDAO routedao = new RouteDAOImpl();
		routedao.deleteRoute(RouteID);
	}

}
