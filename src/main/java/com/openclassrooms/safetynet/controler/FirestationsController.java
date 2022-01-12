package com.openclassrooms.safetynet.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/firestations")
	public List<Firestations> getAll()
	{
		return firestationsService.getFirestationsList();
	}
	
	@PostMapping("/firestations")
	public void addFirestations(@RequestBody Firestations firestations)
	{
		firestationsService.addFirestation(firestations);
	}
	
	@PatchMapping("/firestations")
	public void updateFirestations(@RequestParam String address, @RequestParam String station, @RequestParam String newStation)
	{
		firestationsService.updateFirestation(address, station, newStation);
	}
	
	@DeleteMapping("/firestations")
	public void deleteFirestations(@RequestParam String address, @RequestParam String station)
	{
		firestationsService.deleteFirestation(address, station);
	}
	
}