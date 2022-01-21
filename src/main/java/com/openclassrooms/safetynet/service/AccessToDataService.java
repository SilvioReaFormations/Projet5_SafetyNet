package com.openclassrooms.safetynet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.safetynet.model.Firestations;
import com.openclassrooms.safetynet.model.MedicalRecords;
import com.openclassrooms.safetynet.model.Persons;
import com.openclassrooms.safetynet.repository.AccessToDataRepository;

@Service
public class AccessToDataService implements AccessToDataRepository
{

	@Autowired
	PersonsService personsService;
	@Autowired
	MedicalRecordsService medicalRecordsService;
	@Autowired
	FirestationsService firestationsService;

	public List<String> getFirestationsFromPersons(String stationNumber)
	{
		List<String> personsCoveredByFirestations = new ArrayList<>();
		List<Persons> personsList = personsService.getPersonsList();
		List<MedicalRecords> medicalRecordsList = medicalRecordsService.getMedicalRecordsList();
		int adult = 0;
		int child = 0;

		for (Firestations firestationsSortList : firestationsService.getFirestationsList())
		{
			if (stationNumber.equals(firestationsSortList.getStation()))
			{
				for (Persons personsSortList : personsList)
				{
					if (firestationsSortList.getAddress().equals(personsSortList.getAddress()))
					{
						personsCoveredByFirestations.add("First Name : " + personsSortList.getFirstName());
						personsCoveredByFirestations.add("Last Name : " + personsSortList.getLastName());
						personsCoveredByFirestations.add("Address : " + personsSortList.getAddress());
						personsCoveredByFirestations.add("Phone Number : " + personsSortList.getPhone());

						for (MedicalRecords medicalRecordsSort : medicalRecordsList)
						{
							if (personsSortList.getFirstName().equals(medicalRecordsSort.getFirstName())
									&& personsSortList.getLastName().equals(medicalRecordsSort.getLastName()))
							{

								try
								{
									SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
									Date birthdate = sdf.parse(medicalRecordsSort.getBirthdate());
									Date now = new Date();

									long age = (now.getTime() - birthdate.getTime()) / 86400000 / 365;

									if (age < 18)
									{
										child++;
									} else
									{
										adult++;
									}

								}

								catch (ParseException e)
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}
						}
					}

				}
			}

		}
		personsCoveredByFirestations.add("Children : " + child);
		personsCoveredByFirestations.add("Adults : " + adult);
		return personsCoveredByFirestations;

	}

	public List<String> getChildren(String address)
	{
		List<String> childrenList = new ArrayList<>();
		List<String> familyMembersList = new ArrayList<>();

		for (Persons personsSortList : personsService.getPersonsList())
		{
			if (personsSortList.getAddress().equals(address))
			{

				for (MedicalRecords medicalRecordsSortList : medicalRecordsService.getMedicalRecordsList())
				{
					if (personsSortList.getFirstName().equals(medicalRecordsSortList.getFirstName())
							&& personsSortList.getLastName().equals(medicalRecordsSortList.getLastName()))
					{

						try
						{
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
							Date birthdate = sdf.parse(medicalRecordsSortList.getBirthdate());
							Date now = new Date();
							long age = (now.getTime() - birthdate.getTime()) / 86400000 / 365;

							if (age < 18)
							{
								childrenList.add("First Name : " + medicalRecordsSortList.getFirstName());
								childrenList.add("Last Name : " + medicalRecordsSortList.getLastName());
								childrenList.add("Age : " + age);
								
							}

						}

						catch (ParseException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

				if (!familyMembersList.contains(personsSortList.getFirstName()))
				{
					familyMembersList.add(personsSortList.getFirstName());
				}

			}
		}

		childrenList.add("Other family members : " + familyMembersList.toString());
		return childrenList;
	}

	public List<String> getPhoneNumbers(String station)
	{
		List<String> phoneNumbersList = new ArrayList<>();

		for (Firestations firestationSortList : firestationsService.getFirestationsList())
		{
			if (firestationSortList.getStation().equals(station))
			{

				for (Persons personsSortList : personsService.getPersonsList())
				{
					if (firestationSortList.getAddress().equals(personsSortList.getAddress()))
					{
						phoneNumbersList.add(personsSortList.getPhone());
					}
				}
			}
		}
		return phoneNumbersList;
	}

	public List<String> getPersonsFromAddress(String address)
	{
		// Nom, tel, age antécédent, + caserne
		List<String> personsList = new ArrayList<>();
		List<String> medicationsList = new ArrayList<>();
		List<String> allergiesList = new ArrayList<>();
		long age = 0;

		for (Persons personsSortList : personsService.getPersonsList())
		{
			if (personsSortList.getAddress().equals(address))
			{
				personsList.add("First Name : " + personsSortList.getFirstName());
				personsList.add("Last Name : " + personsSortList.getLastName());
				personsList.add("Phone Number : " + personsSortList.getPhone());

				for (MedicalRecords medicalRecordsSortList : medicalRecordsService.getMedicalRecordsList())
				{
					if (personsSortList.getFirstName().equals(medicalRecordsSortList.getFirstName())
							&& personsSortList.getLastName().equals(medicalRecordsSortList.getLastName()))
					{

						try
						{
							SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
							Date birthdate = sdf.parse(medicalRecordsSortList.getBirthdate());
							Date now = new Date();
							age = (now.getTime() - birthdate.getTime()) / 86400000 / 365;

						}

						catch (ParseException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						for (String string : medicalRecordsSortList.getAllergies())
						{
							allergiesList.add(string);
						}

						for (String string : medicalRecordsSortList.getMedications())
						{
							medicationsList.add(string);
						}
					}
				}

				personsList.add("Age : " + age);
				personsList.add("Allergies : " + allergiesList.toString());
				personsList.add("Medications : " + medicationsList.toString());
				allergiesList.clear();
				medicationsList.clear();

				for (Firestations firestationsSortList : firestationsService.getFirestationsList())
				{

					if (firestationsSortList.getAddress().equals(address))
					{
						personsList.add("Station Number : " + firestationsSortList.getStation());
					
					}
				}
			}
		}
		return personsList;
	}

	public List<String> getPersonsFromStation(String station)
	{

		List<String> personsList = new ArrayList<>();
		List<String> medicationsList = new ArrayList<>();
		List<String> allergiesList = new ArrayList<>();
		long age = 0;

		for (Firestations fireStationsSortList : firestationsService.getFirestationsList())
		{
			if (fireStationsSortList.getStation().equals(station))
			{
				for (Persons personsSortList : personsService.getPersonsList())
				{
					if (personsSortList.getAddress().equals(fireStationsSortList.getAddress()))
					{

						for (MedicalRecords medicalRecordsSortList : medicalRecordsService.getMedicalRecordsList())
						{
							if (personsSortList.getFirstName().equals(medicalRecordsSortList.getFirstName())
									&& personsSortList.getLastName().equals(medicalRecordsSortList.getLastName()))
							{

								try
								{
									SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
									Date birthdate = sdf.parse(medicalRecordsSortList.getBirthdate());
									Date now = new Date();
									age = (now.getTime() - birthdate.getTime()) / 86400000 / 365;

								}

								catch (ParseException e)
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								for (String string : medicalRecordsSortList.getAllergies())
								{
									allergiesList.add(string);
								}

								for (String string : medicalRecordsSortList.getMedications())
								{
									medicationsList.add(string);
								}
							}
						}

						personsList.add("Address : " + personsSortList.getAddress());
						personsList.add("First Name : " + personsSortList.getFirstName());
						personsList.add("Last Name : " + personsSortList.getLastName());
						personsList.add("Allergies : " + allergiesList.toString());
						personsList.add("Medications : " + medicationsList.toString());
						allergiesList.clear();
						medicationsList.clear();
						personsList.add("Age : " + age);
						personsList.add("Phone Number : " + personsSortList.getPhone());
						
					}
				}
			}
		}
		return personsList;
	}

	public List<String> getPersons()
	{

		List<String> personsList = new ArrayList<>();
		List<String> medicationsList = new ArrayList<>();
		List<String> allergiesList = new ArrayList<>();
		long age = 0;

		for (Persons personsSortList : personsService.getPersonsList())
		{

			personsList.add("First Name : " + personsSortList.getFirstName());
			personsList.add("Last Name : " + personsSortList.getLastName());
			personsList.add("Mail : " + personsSortList.getEmail());

			for (MedicalRecords medicalRecordsSortList : medicalRecordsService.getMedicalRecordsList())
			{
				if (personsSortList.getFirstName().equals(medicalRecordsSortList.getFirstName())
						&& personsSortList.getLastName().equals(medicalRecordsSortList.getLastName()))
				{

					try
					{
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
						Date birthdate = sdf.parse(medicalRecordsSortList.getBirthdate());
						Date now = new Date();
						age = (now.getTime() - birthdate.getTime()) / 86400000 / 365;

					}

					catch (ParseException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					for (String string : medicalRecordsSortList.getAllergies())
					{
						allergiesList.add(string);
					}

					for (String string : medicalRecordsSortList.getMedications())
					{
						medicationsList.add(string);
					}
				}
			}

			personsList.add("Age : " + age);
			personsList.add("Allergies : " + allergiesList.toString());
			personsList.add("Medications : " + medicationsList.toString());
			allergiesList.clear();
			medicationsList.clear();
		}
		return personsList;
	}

	public List<String> getEmail()
	{
		List<String> emailList = new ArrayList<>();

		for (Persons personsSortList : personsService.getPersonsList())
		{
			emailList.add(personsSortList.getEmail());
		}
		return emailList;
	}
}
