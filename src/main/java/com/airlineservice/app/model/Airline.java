package com.airlineservice.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("airlinedata")
public class Airline {
	
	private String airlineName;
	private String airlineAddress;
	private String airlineContact;
	private List<String> airnineDetails;
	
	
	public List<String> getAirnineDetails() {
		return airnineDetails;
	}
	public void setAirnineDetails(List<String> airnineDetails) {
		this.airnineDetails = airnineDetails;
	}
	
	
	@Id
	private String airlineId;
	
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getAirlineAddress() {
		return airlineAddress;
	}
	public void setAirlineAddress(String airlineAddress) {
		this.airlineAddress = airlineAddress;
	}
	public String getAirlineContact() {
		return airlineContact;
	}
	public void setAirlineContact(String airlineContact) {
		this.airlineContact = airlineContact;
	}
	public String getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}
	public Airline(String airlineName, String airlineAddress, String airlineContact, String airlineId, List<String> airnineDetails) {
		super();
		this.airlineName = airlineName;
		this.airlineAddress = airlineAddress;
		this.airlineContact = airlineContact;
		this.airlineId = airlineId;
		this.airnineDetails= airnineDetails;
	}
	@Override
	public String toString() {
		return "Airline [airlineName=" + airlineName + ", airlineAddress=" + airlineAddress + ", airlineContact="
				+ airlineContact + ", airlineId=" + airlineId + "]";
	}
	 public Airline() {}
	

}
