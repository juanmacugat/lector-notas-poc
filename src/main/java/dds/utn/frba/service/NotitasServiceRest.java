package dds.utn.frba.service;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import dds.utn.frba.model.Assignment;
import dds.utn.frba.model.Student;
import dds.utn.frba.utils.JsonFactory;

public class NotitasServiceRest implements NotitasService {

	private static final String NOTITAS_API = "https://notitas.herokuapp.com";

	private String token;

	private NotitasServiceRest(String token) {
		this.token = token;
	}

	public static NotitasServiceRest getInstance(String token) {
		return new NotitasServiceRest(token);
	}

	@Override
	public Student getStudent() {
		ClientResponse response = Client.create().resource(NOTITAS_API).path("student")
				.header("Authorization", "Bearer " + token).accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		String student_json = response.getEntity(String.class);
		JsonFactory jsonFactory = new JsonFactory();
		return jsonFactory.fromJson(student_json, Student.class);

	}

	@Override
	public List<Assignment> getAssignments() {
		ClientResponse response = Client.create().resource(NOTITAS_API).path("student/assignments")
				.header("Authorization", "Bearer " + token).accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		String assignment_json = response.getEntity(String.class);
		JsonFactory jsonFactory = new JsonFactory();
		return jsonFactory.fromJson(assignment_json, Student.class).getAssignments();
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub

	}

}
