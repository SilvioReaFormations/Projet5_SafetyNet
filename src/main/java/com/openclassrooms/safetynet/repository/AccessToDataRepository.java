package com.openclassrooms.safetynet.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface AccessToDataRepository
{
	public List<String> getFirestationsFromPersons(String stationNumber);
	public List<String> getChildren(String address);
	public List<String> getPhoneNumbers(String station);
	public List<String> getPersonsFromAddress(String address);
	public List<String> getPersonsFromStation(String station);
	public List<String> getPersons();
	public List<String> getEmail();

	
}
