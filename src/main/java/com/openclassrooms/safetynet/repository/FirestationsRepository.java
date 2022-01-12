package com.openclassrooms.safetynet.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.openclassrooms.safetynet.model.Firestations;

@Repository
public interface FirestationsRepository
{
	public List<Firestations> convertUrlToList();
	public void addFirestation(Firestations firestations);
	public void updateFirestation(String address, String station, String newStation);
	public void deleteFirestation(String address, String station);
}
