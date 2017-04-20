package dds.utn.frba.controller;

import java.util.List;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import dds.utn.frba.model.Assignment;
import dds.utn.frba.model.Student;
import dds.utn.frba.utils.JsonFactory;

public class StudentController {
	
	private static final String NOTITAS_API = "https://notitas.herokuapp.com";

	public List<Assignment> getAssignment(String token){
		
		ClientResponse response = Client.create().resource(NOTITAS_API).path("student/assignments")
				.header("Authorization", "Bearer " + token).accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		String assignment_json = response.getEntity(String.class);
		JsonFactory jsonFactory = new JsonFactory();
		return jsonFactory.fromJson(assignment_json, Student.class).getAssignments();
		
	}
	
}
