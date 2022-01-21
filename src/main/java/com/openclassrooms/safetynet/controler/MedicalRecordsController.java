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
import com.openclassrooms.safetynet.service.MedicalRecordsService;

@RestController
public class MedicalRecordsController
{
	@Autowired
	MedicalRecordsService medicalRecordsService;
	
	
	@GetMapping("/medicalrecords")
	public List<MedicalRecords> getAll()
	{
		return medicalRecordsService.getMedicalRecordsList();
	}
	
	
	@PostMapping("/medicalrecords")
	public MedicalRecords addMedicalRecords (@RequestBody MedicalRecords medicalRecords)
	{
		return medicalRecordsService.addMedicalRecords(medicalRecords);
	}
	
	
	@PatchMapping("/medicalrecords")
	public MedicalRecords updateMedicalRecords (@RequestBody MedicalRecords medicalRecords)
	{
		return medicalRecordsService.updateMedicalRecords(medicalRecords);
	}
	
	@DeleteMapping("/medicalrecords")
	public String deleteMedicalRecords(@RequestParam String firstName, @RequestParam String lastName)
	{
		return medicalRecordsService.deleteMedicalRecords(firstName, lastName);
	}
	
	
}
