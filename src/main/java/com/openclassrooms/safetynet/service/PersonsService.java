package com.openclassrooms.safetynet.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.safetynet.model.Firestations;
import com.openclassrooms.safetynet.model.JsonUrl;
import com.openclassrooms.safetynet.model.MedicalRecords;
import com.openclassrooms.safetynet.model.Persons;
import com.openclassrooms.safetynet.repository.PersonsRepository;

@Service
public class PersonsService implements PersonsRepository
{
	@Autowired
	MedicalRecordsService medicalRecordsService;
	@Autowired
	FirestationsService firestationService;
	
	ObjectMapper objectMapper = new ObjectMapper();
	private JsonUrl jsonUrl;
	List<Persons> personsList = new ArrayList<>();
	
	public List<Persons> getPersonsList()
	{
		return personsList;
	}
	public void setPersonsList(List<Persons> personsList)
	{
		this.personsList = personsList;
	}


	@Override
	public List<Persons> convertUrlToList()
	{
		try
		{
	    
			jsonUrl = objectMapper.readValue(new URL("https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json"), JsonUrl.class);
			personsList = jsonUrl.getPersons();
			System.out.println(personsList);
			
		} 
	    
	    
	    catch (StreamReadException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return personsList;
}
	
	
	
	
	@Override
	public void addPersons(Persons persons)
	{
		personsList.add(persons);		
	}
	
	
	
	@Override
	public void updatePersons(Persons persons)
	{
		for (Persons personsLoop : personsList)
		{
			if(personsLoop.getFirstName().equals(persons.getFirstName()) && personsLoop.getLastName().equals(persons.getLastName()) )
			{
				personsLoop.setAddress(persons.getAddress());
				personsLoop.setCity(persons.getCity());
				personsLoop.setZip(persons.getZip());
				personsLoop.setPhone(persons.getPhone());
				personsLoop.setEmail(persons.getEmail());
				
			}
		}
	}
	
	
	
	@Override
	public String deletePersons(String firstName, String lastName)
	{
		String confirm = "";
		int index = -1;
		for (Persons personsLoop : personsList)
		{
			if (personsLoop.getFirstName().equals(firstName) && personsLoop.getLastName().equals(lastName))
			{
				index = personsList.indexOf(personsLoop);
				confirm = personsLoop.getFirstName() + " " + personsLoop.getLastName() + 
						" has been delete";
			}
			
		}	
		
		personsList.remove(index);
		return confirm;
	}
	
	
	
	
	////////////////////////////////////////////////////////////////////
	
	
	

		
	
	
	

	
	
	
}
