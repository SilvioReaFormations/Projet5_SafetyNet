package com.openclassrooms.safetynet;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.FileSystemUtils;

import com.openclassrooms.safetynet.controler.FirestationsController;
import com.openclassrooms.safetynet.controler.MedicalRecordsController;
import com.openclassrooms.safetynet.controler.PersonsController;
import com.openclassrooms.safetynet.model.Persons;
import com.openclassrooms.safetynet.service.AccessToDataService;
import com.openclassrooms.safetynet.service.FirestationsService;
import com.openclassrooms.safetynet.service.MedicalRecordsService;
import com.openclassrooms.safetynet.service.PersonsService;


/**
 * When application lunch, convert URL into 3 lists
 * 
 * @author Silvio
 *
 */
@SpringBootApplication
public class SafetyNetProjectApplication implements CommandLineRunner
{

	@Autowired
	PersonsService personsS;
	@Autowired
	FirestationsService firestationsS;
	@Autowired
	MedicalRecordsService medicalRecordsS;
	
	
	
	public static void main(String[] args)
	{
		SpringApplication.run(SafetyNetProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		
		personsS.convertUrlToList();
		firestationsS.convertUrlToList();
		medicalRecordsS.convertUrlToList();
		
		
		
	
		
    

	}

}