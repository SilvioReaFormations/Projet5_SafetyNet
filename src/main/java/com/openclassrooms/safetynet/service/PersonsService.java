package com.openclassrooms.safetynet.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.safetynet.model.JsonUrl;
import com.openclassrooms.safetynet.model.Persons;
import com.openclassrooms.safetynet.repository.PersonsRepository;

@Service
public class PersonsService implements PersonsRepository
{
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
	public void updatePersons(String firstName, String lastName, String address, String city, String zip, String phone,
			String email)
	{
		for (Persons personsLoop : personsList)
		{
			if (personsLoop.getFirstName().equals(firstName) && personsLoop.getLastName().equals(lastName))
			{
				personsLoop.setAddress(address);
				personsLoop.setCity(city);
				personsLoop.setZip(zip);
				personsLoop.setPhone(phone);
				personsLoop.setEmail(email);
			}
		}
		System.out.println(personsList);		
	}
	
	
	
	@Override
	public void deletePersons(String firstName, String lastName)
	{
		int index = -1;
		for (Persons personsLoop : personsList)
		{
			if (personsLoop.getFirstName().equals(firstName) && personsLoop.getLastName().equals(lastName))
			{
				index = personsList.indexOf(personsLoop);
			}
			
		}	
		
		personsList.remove(index);
	}

		

	
	
	
}
