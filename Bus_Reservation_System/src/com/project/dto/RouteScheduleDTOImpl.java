package com.project.dto;

public class RouteScheduleDTOImpl implements RouteScheduleDTO{
	
	private RouteDTO route;
	private ScheduleDTO schedule;
	
	
	public RouteScheduleDTOImpl() {
		
	}
	public RouteScheduleDTOImpl(RouteDTO route, ScheduleDTO schedule) {
		super();
		this.route = route;
		this.schedule = schedule;
	}
	
	

	@Override
	public RouteDTO getRoute() {
		return route;
	}

	@Override
	public void setRoute(RouteDTO route) {
		this.route = route;
	}

	@Override
	public ScheduleDTO getSchedule() {
		return schedule;
	}

	@Override
	public void setSchedule(ScheduleDTO schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return"route=" + route + ", schedule=" + schedule+ "\n";
	}

	

}
