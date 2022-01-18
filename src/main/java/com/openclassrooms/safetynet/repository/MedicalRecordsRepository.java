package com.openclassrooms.safetynet.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.openclassrooms.safetynet.model.MedicalRecords;


@Repository
public interface MedicalRecordsRepository
{
	public List<MedicalRecords> convertUrlToList();
	public MedicalRecords addMedicalRecords(MedicalRecords medicalRecords);
	public String deleteMedicalRecords(String firstName, String lastName);
	public MedicalRecords updateMedicalRecords(MedicalRecords medicalRecords);
	
	

	
}


