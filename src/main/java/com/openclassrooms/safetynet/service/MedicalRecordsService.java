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
import com.openclassrooms.safetynet.model.MedicalRecords;
import com.openclassrooms.safetynet.repository.MedicalRecordsRepository;

@Service
public class MedicalRecordsService implements MedicalRecordsRepository
{
	
	private ObjectMapper objectMapper = new ObjectMapper();
	private JsonUrl jsonUrl;
	private List<MedicalRecords> medicalRecordsList = new ArrayList<>();

	public List<MedicalRecords> getMedicalRecordsList()
	{
		return medicalRecordsList;
	}

	public void setMedicalRecordsList(List<MedicalRecords> medicalRecordsList)
	{
		this.medicalRecordsList = medicalRecordsList;
	}


	@Override
	public List<MedicalRecords> convertUrlToList()
	{
		try
		{
	    
			jsonUrl = objectMapper.readValue(new URL("https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json"), JsonUrl.class);
			medicalRecordsList = jsonUrl.getMedicalrecords();
			System.out.println(medicalRecordsList);
			
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
	return medicalRecordsList;
}
	
	
	@Override
	public void addMedicalRecords(MedicalRecords medicalRecords)
	{
		medicalRecordsList.add( medicalRecords );
		
		System.out.println(medicalRecordsList);
	}



	@Override
	public void deleteMedicalRecords(String firstName, String lastName)
	{
		int index = -1;
		for (MedicalRecords medicalRecordsLoop : medicalRecordsList)
		{
			if (medicalRecordsLoop.getFirstName().equals(firstName) && medicalRecordsLoop.getLastName().equals(lastName))
			{
				index = medicalRecordsList.indexOf(medicalRecordsLoop);
			}
		}
		medicalRecordsList.remove(index);
	}
	
	
	

	@Override
	public MedicalRecords updateMedicalRecords(MedicalRecords medicalRecords)
	{
	
		MedicalRecords temp = null;
		for (MedicalRecords medicalRecordsLoop : medicalRecordsList)
			{
				if (medicalRecordsLoop.getFirstName().equals(medicalRecords.getFirstName()) && medicalRecordsLoop.getLastName().equals(medicalRecords.getLastName()) )
				{
					medicalRecordsLoop.setBirthdate(medicalRecords.getBirthdate());
					medicalRecordsLoop.setMedications(medicalRecords.getMedications());
					medicalRecordsLoop.setAllergies(medicalRecords.getAllergies());
					temp = medicalRecordsLoop;
				}
			}
		return temp;
	}

	
	
	
	////////////////////////////////////////////////////////////////////
	
	
	
	

}
