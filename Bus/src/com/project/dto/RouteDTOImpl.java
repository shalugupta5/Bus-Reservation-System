package com.project.dto;

public class RouteDTOImpl implements RouteDTO{
	
	private int routeID;
	private String SourceLocation;
	private String DestinationLocation;
	private int distance;
	
	public RouteDTOImpl() {
		
	}
	
	public RouteDTOImpl(String sourceLocation, String destinationLocation, int distance) {
		super();
		
		SourceLocation = sourceLocation;
		DestinationLocation = destinationLocation;
		this.distance = distance;
	}
	
	public RouteDTOImpl(int routeID, String sourceLocation, String destinationLocation, int distance) {
		super();
		this.routeID = routeID;
		SourceLocation = sourceLocation;
		DestinationLocation = destinationLocation;
		this.distance = distance;
	}

	@Override
	public int getRouteID() {
		return routeID;
	}

	@Override
	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}

	@Override
	public String getSourceLocation() {
		return SourceLocation;
	}

	@Override
	public void setSourceLocation(String sourceLocation) {
		SourceLocation = sourceLocation;
	}

	@Override
	public String getDestinationLocation() {
		return DestinationLocation;
	}

	@Override
	public void setDestinationLocation(String destinationLocation) {
		DestinationLocation = destinationLocation;
	}

	@Override
	public int getDistance() {
		return distance;
	}

	@Override
	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "RouteDTOImpl [routeID=" + routeID + ", SourceLocation=" + SourceLocation + ", DestinationLocation="
				+ DestinationLocation + ", distance=" + distance + "]";
	}
	
	
	
	

}
