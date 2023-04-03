package com.project.ui;

import java.util.List;
import java.util.Scanner;

import com.project.dao.BusDAO;
import com.project.dao.BusDAOImpl;
import com.project.dto.BusDTO;

public class AllBusList {
	
	public static void main(String[] args) {
		BusDAO busdao=new BusDAOImpl();
		
		List<BusDTO> list = busdao.getAllBuses();
		
	
		
		if(list!=null) {
			list.forEach(x->System.out.println(x));
		}
		else {
			System.out.println("No Record Found");
		}

}
}
