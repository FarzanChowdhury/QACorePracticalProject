package com.qa.cat.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.cat.domain.Cat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts= {"classpath:cat-schema.sql", "classpath:cat-data.sql"}, executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class CatControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Cat testCat = new Cat(null, "Jones", "Sphynx", 15);
		String testCatAsJSON = this.mapper.writeValueAsString(testCat);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testCatAsJSON);

		Cat testCreatedCat = new Cat(3, "Jones", "Sphynx", 15);
		String testCreatedDCatAsJSON = this.mapper.writeValueAsString(testCreatedCat);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedDCatAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetAll() throws Exception {
		RequestBuilder req = get("/getAll");
		List<Cat> testDogs = List.of(new Cat(1, "John", "Persian", 12), new Cat(2, "Jimmy", "Bengal", 5));
		String testGetAllAsJSON = this.mapper.writeValueAsString(testDogs);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testGetAllAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetById() throws Exception {
		RequestBuilder req = get("/get/1");
		Cat testCats = new Cat(1, "John", "Persian", 12);
		String testGetByIdAsJSON = this.mapper.writeValueAsString(testCats);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testGetByIdAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testReplace() throws Exception {
		Cat testCat = new Cat(null, "Albert", "Siamese", 8);
		String testCatAsJSON = this.mapper.writeValueAsString(testCat);
		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(testCatAsJSON);

		Cat testReplaceCat = new Cat(1, "Albert", "Siamese", 8);
		String testReplaceCatAsJSON = this.mapper.writeValueAsString(testReplaceCat);
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testReplaceCatAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testRemove() throws Exception {
		RequestBuilder req = delete("/remove/1");
		ResultMatcher checkStatus = status().isNoContent();
		
		this.mvc.perform(req).andExpect(checkStatus);
	}
	
}
