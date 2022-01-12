package com.openclassrooms.safetynet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.safetynet.model.Persons;
import com.openclassrooms.safetynet.service.FirestationsService;
import com.openclassrooms.safetynet.service.MedicalRecordsService;
import com.openclassrooms.safetynet.service.PersonsService;

@SpringBootTest
class SafetyNetServiceClassesTests {

	@Autowired
	PersonsService personsService;
	@Autowired
	FirestationsService firestationsService;
	@Autowired
	MedicalRecordsService medicalRecordsService;
	

	List<Persons> listTest = new ArrayList<>();
	Persons personsTest = new Persons("Silvio", "REA", "address", "city", "zip", "phone", "email");
	
	
	@Test
	void contextLoads() {
	}
	
	
	//////////////// PersonsService TESTS ////////////////////
	
	@Test
	public void testIfConvertUrlToPersonsListWorks()
	{
		listTest = personsService.convertUrlToList();
		assertNotNull(listTest);
	}
	
	
	@Test
	public void testAddPersonsMethod ()
	{
		personsService.addPersons(personsTest);
		assertTrue(personsService.getPersonsList().contains(personsTest));
	}
	
	
	@Test
	public void testUpdatePersonsMethod()
	{
		listTest.add(personsTest);
		personsService.setPersonsList(listTest);
		personsService.updatePersons("Silvio", "REA", "TEST", "TEST", "TEST", "TEST", "TEST");
		assertTrue(personsTest.getAddress().equals("TEST"));
	}
	
	
	@Test
	public void testDeletePersonsMethod()
	{
		listTest.add(personsTest);
		personsService.setPersonsList(listTest);
		personsService.deletePersons("Silvio", "REA");
		assertFalse(personsService.getPersonsList().contains(personsTest));
	}
	
	
	

}
