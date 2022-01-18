package com.openclassrooms.safetynet.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.openclassrooms.safetynet.model.Persons;

@Repository
public interface PersonsRepository
{
	public List<Persons> convertUrlToList();
	public Persons addPersons(Persons persons);
	public Persons updatePersons(Persons persons);
	public String deletePersons(String firstName, String lastName);
	

}
