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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.safetynet.model.Firestations;
import com.openclassrooms.safetynet.model.MedicalRecords;
import com.openclassrooms.safetynet.model.Persons;



@SpringBootTest
@AutoConfigureMockMvc
public class SafetyNetControllerClassesTests
{
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	 private ObjectMapper objectMapper;
	
	
	
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
		.andExpect(jsonPath("$[0].lastName", is("Boyd")));
	}
	
	@Test
	public void addPersonsControllerTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.post("/persons")
				.contentType(MediaType.APPLICATION_JSON)
			    .content(objectMapper.writeValueAsString(new Persons("Silvio", "REA", "Test address", "city", "zip", "phone", "email"))))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", is("Silvio")))
				.andExpect(jsonPath("$.lastName", is("REA")));
	}
	
	
	
	@Test
	public void updatePersonsControllerTest() throws JsonProcessingException, Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.patch("/persons")
				.contentType(MediaType.APPLICATION_JSON)
			    .content(objectMapper.writeValueAsString(new Persons("John", "Boyd", "Test address", "city", "zip", "phone", "email"))))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.address", is("Test address")))
				.andExpect(jsonPath("$.phone", is("phone")));
	}
	
	
	@Test
	public void deletePersonsControllerTest() throws Exception
	{
		mockMvc.perform(delete("/persons")
				.param("firstName", "John")
				.param("lastName", "Boyd"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", is("John Boyd has been delete")));
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
	public void addFirestationsControllerTest() throws JsonProcessingException, Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.post("/firestation")
				.contentType(MediaType.APPLICATION_JSON)
			    .content(objectMapper.writeValueAsString(new Firestations("New Firestation", "New NumberStation"))))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.address", is("New Firestation")))
				.andExpect(jsonPath("$.station", is("New NumberStation")));
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
	public void deleteFirestationsControllerTest() throws Exception
	{
		mockMvc.perform(delete("/firestation")
				.param("address", "29 15th St")
				.param("station", "2"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", is("Firestation number 2 located at 29 15th St has been deleted")));
	
	}
	
	
	
	
	
	
	
	////////////// MedicalRecordsController TESTS /////////////////

	@Test
	public void getAllMedicalRecordsControllerTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/medicalrecords"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[0].firstName", is("John")))
		.andExpect(jsonPath("[0].lastName", is("Boyd")));
	}
	
	@Test
	public void deleteMedicalRecordsControllerTest() throws Exception
	{
		mockMvc.perform(delete("/medicalrecords")
				.param("firstName", "John")
				.param("lastName", "Boyd"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", is("John Boyd's medical records had been deleted")));
	
	}
	
	@Test
	public void addMedicalRecordsControllerTest() throws JsonProcessingException, Exception
	{
		String[] arrayMedications = { "medi1", "medi2" };
		String[] arrayAllergies = { "POLEN", "LACTOSE" };
		
		mockMvc.perform(MockMvcRequestBuilders.post("/medicalrecords")
				.contentType(MediaType.APPLICATION_JSON)
			    .content(objectMapper.writeValueAsString(new MedicalRecords("Silvio", "REA", "26/09/1986", arrayMedications,
						arrayAllergies))))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", is("Silvio")))
				.andExpect(jsonPath("$.lastName", is("REA")))
				.andExpect(jsonPath("$.allergies[0]", is("POLEN")));
	}
	
	@Test
	public void updateMedicalRecordsControllerTest() throws JsonProcessingException, Exception
	{
		String[] arrayMedications = { "medi1", "medi2" };
		String[] arrayAllergies = { "POLEN", "LACTOSE" };
		
		mockMvc.perform(MockMvcRequestBuilders.post("/medicalrecords")
				.contentType(MediaType.APPLICATION_JSON)
			    .content(objectMapper.writeValueAsString(new MedicalRecords("John", "Boyd", "03/06/1984", arrayMedications,
						arrayAllergies))))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", is("John")))
				.andExpect(jsonPath("$.lastName", is("Boyd")))
				.andExpect(jsonPath("$.allergies[0]", is("POLEN")));
	}
	
	

	
	
}
