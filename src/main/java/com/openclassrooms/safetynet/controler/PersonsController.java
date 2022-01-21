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
	
	
	@PostMapping("/persons")
	public Persons addPersons(@RequestBody Persons persons)
	{
		return personsService.addPersons(persons);
	}
	
	
	
	@GetMapping("/persons")
	public List<Persons> getAll()
	{
		return personsService.getPersonsList();
	}
	
	
	
	@PatchMapping("/persons")
	public Persons updatePersons(@RequestBody Persons persons)
	{
		return personsService.updatePersons(persons);
	}
	
	
	
	
	
	@DeleteMapping("/persons")
	public String deletePersons(@RequestParam String firstName, @RequestParam String lastName)
	{
		return personsService.deletePersons(firstName, lastName);

	}
	
	
}
