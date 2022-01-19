package com.openclassrooms.safetynet;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AccessToDataControllerTest
{
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void contextLoads()
	{
	}
	
	@Test
	public void getFirestationsFromPersonsControllerTest() throws Exception
	{
		mockMvc.perform(get("/firestation")
				.param("stationNumber", "3"))
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[0]", is("First Name : John")))
		.andExpect(jsonPath("$.[53]", is("Adults : 10")))
		.andExpect(status().isOk());
	}
	
	
	@Test
	public void getChildrenControllerTest() throws Exception
	{
		mockMvc.perform(get("/childAlert")
				.param("address", "1509 Culver St"))
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[0]", is("First Name : Tenley")))
		.andExpect(jsonPath("$.[2]", is("Age : 8")))
		.andExpect(jsonPath("$.[6]", is("Other family members : [John, Jacob, Tenley, Roger, Felicia]")))
		.andExpect(status().isOk());
	}
	
	
	@Test
	public void getPhoneNumbersControllerTest() throws Exception
	{
		mockMvc.perform(get("/phoneAlert")
				.param("firestation", "3"))
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[0]", is("841-874-6512")))
		.andExpect(jsonPath("$.[1]", is("841-874-6513")))
		.andExpect(status().isOk());
	}
	
	
	@Test
	public void getPersonsFromAdressControllerTest() throws Exception
	{
		mockMvc.perform(get("/fire")
				.param("address", "1509 Culver St"))
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[0]", is("First Name : John")))
		.andExpect(jsonPath("$.[2]", is("Phone Number : 841-874-6512")))
		.andExpect(jsonPath("$.[5]", is("Medications : [aznol:350mg, hydrapermazol:100mg]")))
		.andExpect(status().isOk());
	}
	
	
	@Test
	public void getPersonsFromStationControllerTest() throws Exception
	{
		mockMvc.perform(get("/flood")
				.param("station", "3"))
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[0]", is("Address : 1509 Culver St")))
		.andExpect(jsonPath("$.[2]", is("Last Name : Boyd")))
		.andExpect(jsonPath("$.[5]", is("Age : 37")))
		.andExpect(status().isOk());
	}
	
	
	@Test
	public void getPersonsControllerTest() throws Exception
	{
		mockMvc.perform(get("/personInfo"))
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[0]", is("First Name : John")))
		.andExpect(jsonPath("$.[2]", is("Mail : jaboyd@email.com")))
		.andExpect(jsonPath("$.[5]", is("Medications : [aznol:350mg, hydrapermazol:100mg]")))
		.andExpect(status().isOk());
	}
	
	
	@Test
	public void getEmailControllerTest() throws Exception
	{
		mockMvc.perform(get("/communityEmail"))
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$[0]", is("jaboyd@email.com")))
		.andExpect(jsonPath("$.[2]", is("tenz@email.com")))
		.andExpect(jsonPath("$.[5]", is("drk@email.com")))
		.andExpect(status().isOk());
	}
	
	
}
