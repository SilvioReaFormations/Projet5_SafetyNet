package com.openclassrooms.safetynet.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.openclassrooms.safetynet.model.Firestations;
import com.openclassrooms.safetynet.model.Persons;

@Repository
public interface FirestationsRepository
{
	public List<Firestations> convertUrlToList();
	public void addFirestation(Firestations firestations);
	public Firestations updateFirestation(String address, String station, String newStation);
	public String deleteFirestation(String address, String station);
}
