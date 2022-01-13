package com.openclassrooms.safetynet.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.openclassrooms.safetynet.model.MedicalRecords;


@Repository
public interface MedicalRecordsRepository
{
	public List<MedicalRecords> convertUrlToList();
	public void addMedicalRecords(MedicalRecords medicalRecords);
//	public void updateMedicalRecords(String firstName, String lastName, String birthdate, String[] medications, String [] allergies);
	public void deleteMedicalRecords(String firstName, String lastName);
	
	
	public MedicalRecords updateMedicalRecords(MedicalRecords medicalRecords);
}


