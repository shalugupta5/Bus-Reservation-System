package com.project.ui;
import java.util.*;


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
		
		System.out.println("Enter BusNumber");
		String busNumber=sc.next();
		
		System.out.println("Enter BusType");
		String busType=sc.next();
		
		System.out.println("Enter totalSeats");
		int totalSeats=sc.nextInt();
		
		BusDTO busdto = new BusDTOImpl(busNumber, busType, totalSeats);
		
		BusDAO busdao=new BusDAOImpl();
		
		busdao.addBus(busdto);
		
	}
	
	public void displayAllBuses() {
	
		BusDAO busdao=new BusDAOImpl();
		
		List<BusDTO> list = busdao.getAllBuses();
		
		if(list!=null) {
			list.forEach(x->System.out.println(x));
		}
		else {
			System.out.println("No Record Found");
		}
	}
	
	public void updateBus() {
		
		System.out.println("Enter BusID");
		int BusId=sc.nextInt();
		
		System.out.println("Enter BusNumber");
		String busNumber=sc.next();
		
		System.out.println("Enter BusType");
		String busType=sc.next();
		
		System.out.println("Enter totalSeats");
		int totalSeats=sc.nextInt();
		
		BusDTO busdto = new BusDTOImpl(BusId, busNumber, busType, totalSeats);
		
		BusDAO busdao=new BusDAOImpl();
		busdao.updateBus(busdto);
	}
	
	
	public void deleteBus() {
		
		System.out.println("Enter BusID");
		int BusId=sc.nextInt();
		
		BusDAO busdao=new BusDAOImpl();
		busdao.deleteBus(BusId);
		
	}
	
	}


