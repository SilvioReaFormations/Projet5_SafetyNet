package com.openclassrooms.safetynet;

import static org.assertj.core.api.Assertions.as;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.json.JSONString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.openclassrooms.safetynet.controler.PersonsController;
import com.openclassrooms.safetynet.model.Persons;
import com.openclassrooms.safetynet.service.PersonsService;


@WebMvcTest(controllers = PersonsController.class)
public class SafetyNetControllerClassesTests
{
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private PersonsService personsService;
	
	
	@Test
	public void getAllControllerTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/persons")).andExpect(status().isOk());
	}
	
	@Test
	public void addPersonsControllerTest() throws Exception
	{
		
	}
	
}
