package com.openclassrooms.safetynet.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.safetynet.model.Firestations;
import com.openclassrooms.safetynet.service.FirestationsService;

@RestController
public class FirestationsController
{
	@Autowired
	private FirestationsService firestationsService;
	
	public void convertUrlToList()
	{
		firestationsService.convertUrlToList();
	}
	
	
	@PostMapping("/firestation")
	public void addFirestations(@RequestBody Firestations firestations)
	{
		firestationsService.addFirestation(firestations);
	}
	
	@PatchMapping("/firestation")
	public void updateFirestations(@RequestParam String address, @RequestParam String station, @RequestParam String newStation)
	{
		firestationsService.updateFirestation(address, station, newStation);
	}
	
	@DeleteMapping("/firestation")
	public void deleteFirestations(@RequestParam String address, @RequestParam String station)
	{
		firestationsService.deleteFirestation(address, station);
	}
	
	
	/////////////////////////////////////////////////////////////////
	
	
	
	// @GetMapping("/firestation")
//	public List<Firestations> getAll()
//	{
//		return firestationsService.getFirestationsList();
//	}
//	
//	@GetMapping("/firestation")
//	public List<String> getFirestationsToPersons(@RequestParam String stationNumber)
//	{
//		return firestationsService.getFirestationsToPersons(stationNumber);
//	}

	
	
	
	
	// A COLLER DANS AccessToDataController
	
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
