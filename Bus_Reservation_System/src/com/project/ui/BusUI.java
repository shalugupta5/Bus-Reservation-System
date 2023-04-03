package com.project.ui;
import java.util.*;

import com.project.colors.ConsoleColors;
import com.project.dao.BusDAO;
import com.project.dao.BusDAOImpl;
import com.project.dto.BusDTO;
import com.project.dto.BusDTOImpl;

public class BusUI {
	
	private Scanner sc;
	
	
	public BusUI(Scanner sc) {
		super();
		this.sc = sc;
	}


	//public static void main(String[] args) {
	//	Scanner sc=new Scanner(System.in);
		
	public void addBusUI() {
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter BusNumber");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String busNumber=sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter BusType");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String busType=sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter totalSeats");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int totalSeats=sc.nextInt();
		
		BusDTO busdto = new BusDTOImpl(busNumber, busType, totalSeats);
		
		BusDAO busdao=new BusDAOImpl();
		
		busdao.addBus(busdto);
		
	}
	
	public void displayAllBuses() {
	
		BusDAO busdao=new BusDAOImpl();
		
		List<BusDTO> list = busdao.getAllBuses();
		
		if(list!=null) {
			System.out.println(ConsoleColors.BLACK_BOLD+"Here you go.");
			System.out.println(ConsoleColors.YELLOW_BOLD+list);
		}
		else {
			System.out.println(ConsoleColors.RED_BOLD+"No Record Found");
		}
	}
	
	public void updateBus() {
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter BusID");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int BusId=sc.nextInt();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter BusNumber");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String busNumber=sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter BusType");
		System.out.println(ConsoleColors.GREEN_BOLD);
		String busType=sc.next();
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter totalSeats");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int totalSeats=sc.nextInt();
		
		BusDTO busdto = new BusDTOImpl(BusId, busNumber, busType, totalSeats);
		
		BusDAO busdao=new BusDAOImpl();
		busdao.updateBus(busdto);
	}
	
	
	public void deleteBus() {
		
		System.out.println(ConsoleColors.BLACK_BOLD+"Enter BusID");
		System.out.println(ConsoleColors.GREEN_BOLD);
		int BusId=sc.nextInt();
		
		BusDAO busdao=new BusDAOImpl();
		busdao.deleteBus(BusId);
		
	}
	
	}


