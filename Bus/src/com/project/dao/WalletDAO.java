package com.project.dao;

import java.sql.SQLException;

public interface WalletDAO {
	
	public String  balanceDeduct(int UserID, int ScheduleID, int noOfSeats, double ticketPrice) throws ClassNotFoundException, SQLException;

	public void addBalnce(int passengerID) throws ClassNotFoundException, SQLException;
	
	public  void updateBalnce(int passengerID);
	
}
