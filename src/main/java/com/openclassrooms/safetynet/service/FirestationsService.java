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
import com.openclassrooms.safetynet.model.Firestations;
import com.openclassrooms.safetynet.model.JsonUrl;
import com.openclassrooms.safetynet.repository.FirestationsRepository;

@Service
public class FirestationsService implements FirestationsRepository
{

	ObjectMapper objectMapper = new ObjectMapper();
	private JsonUrl jsonUrl;
	List<Firestations> firestationsList = new ArrayList<>();
	
	public List<Firestations> getFirestationsList()
	{
		return firestationsList;
	}
	public void setFirestationsList(List<Firestations> firestationsList)
	{
		this.firestationsList = firestationsList;
	}


	@Override
	public List<Firestations> convertUrlToList()
	{
		try
		{
	    
			jsonUrl = objectMapper.readValue(new URL("https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json"), JsonUrl.class);
			firestationsList = jsonUrl.getFirestations();
			System.out.println(firestationsList);
			
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
	return firestationsList;
}

	
	@Override
	public void addFirestation(Firestations firestations)
	{
		firestationsList.add(firestations);
		
	}
	
	

	@Override
	public void updateFirestation(String address, String station, String newStation)
	{
		for (Firestations fireStationsLoop : firestationsList)
		{
			if (fireStationsLoop.getAddress().equals(address) && fireStationsLoop.getStation().equals(station))
			{
				fireStationsLoop.setStation(newStation);
			}
		}
		
	}



	@Override
	public void deleteFirestation(String address, String station)
	{
		int index = -1;
		for (Firestations fireStationsLoop : firestationsList)
		{
			
			if (fireStationsLoop.getAddress().equals(address) && fireStationsLoop.getStation().equals(station))
			{
				index = firestationsList.indexOf(fireStationsLoop);
			}
		}
		
		firestationsList.remove(index);

	}
	
	

}