package com.project.dto;

public class PassengerDTOImpl implements PassengerDTO{
	
	private int id;
    private String name;
    private String userName;
    private String mobileNumber;
    private String password;
    
    public PassengerDTOImpl() {
    	
    }
    
    public PassengerDTOImpl(String name, String mobileNumber, String password) {
		super();
		
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
    
    public PassengerDTOImpl(String name, String userName, String mobileNumber, String password) {
		super();
		this.userName=userName;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}
    
	public PassengerDTOImpl(int id, String name, String userName, String mobileNumber, String password) {
		super();
		this.id = id;
		this.name = name;
		this.userName=userName;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getMobileNumber() {
		return mobileNumber;
	}

	@Override
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "PassengerDTOImpl [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", password="
				+ password + "]";
	}
    
    

}
