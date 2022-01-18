package com.openclassrooms.safetynet;


import static org.assertj.core.api.Assertions.as;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.core.IsNot;
import org.json.JSONString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.openclassrooms.safetynet.model.Persons;



@SpringBootTest
@AutoConfigureMockMvc
public class SafetyNetControllerClassesTests
{
	@Autowired
	MockMvc mockMvc;
	
	
	
	@Test
	void contextLoads()
	{
	}
	
	
	////////////// PersonsController TESTS /////////////////
	
	@Test
	public void getAllPersonsControllerTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/persons"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[0].firstName", is("John")))
		.andExpect(jsonPath("[0].lastName", is("Boyd")));
	}
	
//	@Test
//	public void addPersonsControllerTest() throws Exception
//	{
//		mockMvc.perform(MockMvcRequestBuilders.post("/persons")
//				.contentType(MediaType.APPLICATION_JSON)
//				.param("persons", "new Persons(\"Silvio\", \"REA\", \"Test address\", \"city\", \"zip\", \"phone\", \"email\")")
//				)
//				.andExpect(status().isCreated());
//	}
	
	@Test
	public void deletePersonsControllerTest() throws Exception
	{
		mockMvc.perform(delete("/persons")
				.param("firstName", "John")
				.param("lastName", "Boyd"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", is("John Boyd has been delete")));
	}
	
	@Test
	public void updatePersonsControllerTest()
	{
		
	}
	
	
	
	
	////////////// FirestationsController TESTS /////////////////

	
	@Test
	public void getAllFirestationsControllerTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/firestations"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[0].address", is("1509 Culver St")))
		.andExpect(jsonPath("[0].station", is("3")));
	}
	
	
	@Test
	public void deleteFirestationsControllerTest() throws Exception
	{
		mockMvc.perform(delete("/firestation")
				.param("address", "1509 Culver St")
				.param("station", "3"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", is("Firestation number 3 located at 1509 Culver St has been deleted")));
	
	}
	
	
	@Test
	public void updateFirestationsControllerTest() throws Exception
	{
		mockMvc.perform(patch("/firestation")
				.param("address", "1509 Culver St")
				.param("station", "3")
				.param("newStation", "15"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.station", is("15")));
	}
	
	
	@Test
	public void addFirestationsControllerTest()
	{
		
	}
	
	
	////////////// MedicalRecordsController TESTS /////////////////

	
	
}
