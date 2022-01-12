package com.openclassrooms.safetynet.model;

import java.util.List;

public class JsonUrl
{
	private List<Persons> persons;
	private List<Firestations> firestations;
	private List<MedicalRecords> medicalrecords;
	
	

	public JsonUrl()
	{
	}



	@Override
	public String toString()
	{
		return "JsonUrl [persons=" + persons + "\n" + ", firestations=" + firestations + "\n" + ", medicalrecords=" + medicalrecords
				+ "]";
	}



	public List<Persons> getPersons()
	{
		return persons;
	}



	public void setPersons(List<Persons> persons)
	{
		this.persons = persons;
	}



	public List<Firestations> getFirestations()
	{
		return firestations;
	}



	public void setFirestations(List<Firestations> firestations)
	{
		this.firestations = firestations;
	}



	public List<MedicalRecords> getMedicalrecords()
	{
		return medicalrecords;
	}



	public void setMedicalrecords(List<MedicalRecords> medicalrecords)
	{
		this.medicalrecords = medicalrecords;
	}
	
	

}	
