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

import com.openclassrooms.safetynet.model.Persons;
import com.openclassrooms.safetynet.service.PersonsService;

@RestController
public class PersonsController
{
	@Autowired
	private PersonsService personsService;
	
	public void convertUrlToList()
	{
		personsService.convertUrlToList();
	}
	
	@PostMapping("/persons")
	public void addPersons(@RequestBody Persons persons)
	{
		personsService.addPersons(persons);
	}
	
	
	
	@GetMapping("/persons")
	public List<Persons> getAll()
	{
		return personsService.getPersonsList();
	}
	
	
	
	@PatchMapping("/persons")
	public void updatePersons(@RequestBody Persons persons)
	{
		personsService.updatePersons(persons);
	}
	
	
	
	
	
	@DeleteMapping("/persons")
	public void deletePersons(@RequestParam String firstName, @RequestParam String lastName)
	{
		personsService.deletePersons(firstName, lastName);
		
		
	}
	
	
}
