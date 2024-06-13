package com.veiculo.vagas_microservice.request_response;

public class ParkingSpotResponse {

	private String spotName;
	private int capacity;

	// getters and setters
	public String getSpotName() {
		return spotName;
	}

	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
