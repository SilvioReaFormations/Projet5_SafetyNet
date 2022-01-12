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

import com.openclassrooms.safetynet.model.Firestations;
import com.openclassrooms.safetynet.model.MedicalRecords;
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
	

	List<Persons> personsListTest = new ArrayList<>();
	List<Firestations> firestationsListTest = new ArrayList<>();
	List<MedicalRecords> medicalRecordsListTest = new ArrayList<>();
	Persons personsTest = new Persons("Silvio", "REA", "address", "city", "zip", "phone", "email");
	Firestations firestationsTest = new Firestations("Test address", "Test station");
	
	
	@Test
	void contextLoads() {
	}
	
	
	//////////////// PersonsService TESTS ////////////////////
	
	@Test
	public void testIfConvertUrlToPersonsListWorks()
	{
		personsListTest = personsService.convertUrlToList();
		assertNotNull(personsListTest);
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
		personsListTest.add(personsTest);
		personsService.setPersonsList(personsListTest);
		personsService.updatePersons("Silvio", "REA", "TEST", "TEST", "TEST", "TEST", "TEST");
		assertTrue(personsTest.getAddress().equals("TEST"));
	}
	
	
	@Test
	public void testDeletePersonsMethod()
	{
		personsListTest.add(personsTest);
		personsService.setPersonsList(personsListTest);
		personsService.deletePersons("Silvio", "REA");
		assertFalse(personsService.getPersonsList().contains(personsTest));
	}
	
	
	
	
	//////////////// FirestationsService TESTS ////////////////////

	@Test
	public void testIfConvertUrlToFirestationsListWorks()
	{
		firestationsListTest = firestationsService.convertUrlToList();
		assertNotNull(firestationsListTest);
	}
	
	
	@Test
	public void testAddFirestationsMethod ()
	{
		firestationsService.addFirestation(firestationsTest);
		assertTrue(firestationsService.getFirestationsList().contains(firestationsTest));
	}
	
	
	@Test
	public void testUpdateFirestationsMethod()
	{
		firestationsListTest.add(firestationsTest);
		firestationsService.setFirestationsList(firestationsListTest);;
		firestationsService.updateFirestation("Test address", "Test station", "55");;
		assertTrue(firestationsTest.getStation().equals("55"));
	}

	
	@Test
	public void testDeleteFirestationsMethod()
	{
		firestationsListTest.add(firestationsTest);
		firestationsService.setFirestationsList(firestationsListTest);
		firestationsService.deleteFirestation("Test address", "Test station");
		assertFalse(firestationsService.getFirestationsList().contains(firestationsTest));
	}
	
	
	//////////////// MedicalRecordsService TESTS ////////////////////
	
	
	
}
