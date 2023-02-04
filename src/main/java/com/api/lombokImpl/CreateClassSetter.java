package com.api.lombokImpl;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreateClassSetter {
	
	String key = "SWAT";
	
	public String createTicketRequest() throws JsonProcessingException {
		
		CreateTicketRequest createTicket = new CreateTicketRequest();
		
		CreateTicketRequest.Fields fields = createTicket.new Fields();
		
		CreateTicketRequest.Project project = createTicket.new Project();
		project.setKey(key);
		
		fields.setProject(project);
		
		CreateTicketRequest.IssueType issueType = createTicket.new IssueType();
		issueType.setName("Bug");
		
		fields.setIssuetype(issueType);
		
		fields.setDescription("Praveen - Bug Creation Description");
		
		fields.setSummary("Praveen - Bug Creation Summary");
		
		createTicket.setFields(fields);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String jsonBody = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(createTicket);
		return jsonBody;
		
		
	}
	
	public Response createRequest(String input) {
		
		RestAssured.baseURI = "https://fiyaznafa.atlassian.net";
		
		RestAssured.basePath = "/rest/api/2/";
			
		ValidatableResponse response = RestAssured.given().log().all()
				.contentType("application/json")
				.accept("application/json")
				.body(input)
				.auth().preemptive().basic("fiyaznafa@gmail.com", "K1zCJI8OdANGd4CXyVfN9EAB")
				.when()
				.post("issue/")
				.then().log().all()
				.assertThat().statusCode(201);
		
		return response.extract().response();
		
	}
	
	public void createTicketResponse(Response response) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		CreateTicketResponse createTicket = mapper.readValue(response.asPrettyString(), CreateTicketResponse.class);
		
		Assert.assertTrue(createTicket.getKey().startsWith(key));
		
		Assert.assertTrue(createTicket.getSelf().contains("/api/2/issue/"));
	}

	
	@Test
	public void createTicketTestMethod() throws JsonProcessingException {
		String requestJson = createTicketRequest();
		
		Response response = createRequest(requestJson);
		
		createTicketResponse(response);
		
		
	}
	
}
