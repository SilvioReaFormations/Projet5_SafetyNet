package com.openclassrooms.safetynet.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.safetynet.service.AccessToDataService;

@RestController
public class AccessToDataController
{
	@Autowired
	AccessToDataService accessToDataService;
	
	@GetMapping("/firestation")
	public List<String> getFirestationsFromPersons(@RequestParam String stationNumber)
	{
		return accessToDataService.getFirestationsFromPersons(stationNumber);
	}
	
	
	@GetMapping("/childAlert")
	public List<String> getChildren(@RequestParam String address)
	{
		return accessToDataService.getChildren(address);

	}
	
	@GetMapping("/phoneAlert")
	public List<String> getPhoneNumbers(@RequestParam String firestation)
	{
		return accessToDataService.getPhoneNumbers(firestation);

	}
	
	@GetMapping("/fire")
	public List<String> getPersonsFromAdress(@RequestParam String address)
	{
		return accessToDataService.getPersonsFromAdress(address);
	}
	
	@GetMapping("/flood")
	public List<String> getPersonsFromStation(@RequestParam String station)
	{
		return accessToDataService.getPersonsFromStation(station);
	}

	@GetMapping("/personInfo")
	public List<String> getPersons()
	{
		return accessToDataService.getPersons();
	}

	@GetMapping("/communityEmail")
	public List<String> getEmail()
	{
		return accessToDataService.getEmail();
		
	}
	
//	@RequestMapping(value = "/firestation", params = "stationNumber", method = RequestMethod.GET)
//	public List<String> getFirestationsToPersons(@RequestParam String stationNumber)
//	{
//		return firestationsService.getFirestationsToPersons(stationNumber);
//	}
//
//	@RequestMapping(value = "/firestation", method = RequestMethod.GET)
//	public List<Firestations> getAll()
//	{
//		return firestationsService.getFirestationsList();
//	}
	
	

}
