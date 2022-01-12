package com.openclassrooms.safetynet.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.safetynet.model.MedicalRecords;
import com.openclassrooms.safetynet.model.Persons;
import com.openclassrooms.safetynet.service.MedicalRecordsService;

@RestController
public class MedicalRecordsController
{
	@Autowired
	MedicalRecordsService medicalRecordsService;

	public void convertUrlToList()
	{
		medicalRecordsService.convertUrlToList();
	}
	
	
	@GetMapping("/medicalrecords")
	public List<MedicalRecords> getAll()
	{
		return medicalRecordsService.getMedicalRecordsList();
	}
	
	
	@PostMapping("/medicalrecords")
	public void addMedicalRecords (@RequestBody MedicalRecords medicalRecords)
	{
		medicalRecordsService.addMedicalRecords(medicalRecords);
	}
	
	@PatchMapping("/medicalrecords")
	public void updateMedicalRecords (@RequestParam String firstName, @RequestParam String lastName, @RequestParam String birthdate,
			@RequestParam String[] medications, @RequestParam String[] allergies)
	{
		medicalRecordsService.updateMedicalRecords(firstName, lastName, birthdate, medications, allergies);
	}
	
	@DeleteMapping("/medicalrecords")
	public void deleteMedicalRecords(@RequestParam String firstName, @RequestParam String lastName)
	{
		medicalRecordsService.deleteMedicalRecords(firstName, lastName);
	}
	
	
}
