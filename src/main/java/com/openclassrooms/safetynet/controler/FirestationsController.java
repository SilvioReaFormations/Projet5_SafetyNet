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
import com.openclassrooms.safetynet.model.Persons;
import com.openclassrooms.safetynet.service.FirestationsService;

/**
 * Controller Class of the firestationService  methods
 * @author Silvio
 *
 */
@RestController
public class FirestationsController
{
	@Autowired
	private FirestationsService firestationsService;
	
	
	@GetMapping("/firestations")
	public List<Firestations> getAll()
	{
		return firestationsService.getFirestationsList();
	}
	
	
	@PostMapping("/firestation")
	public Firestations addFirestations(@RequestBody Firestations firestations)
	{
		return firestationsService.addFirestation(firestations);
	}
	
	@PatchMapping("/firestation")
	public Firestations updateFirestations(@RequestParam String address, @RequestParam String station, @RequestParam String newStation)
	{
		return firestationsService.updateFirestation(address, station, newStation);
	}
	
	@DeleteMapping("/firestation")
	public String deleteFirestations(@RequestParam String address, @RequestParam String station)
	{
		return firestationsService.deleteFirestation(address, station);
	}
	
	
}
