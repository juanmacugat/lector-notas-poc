package dds.utn.frba.controller;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

import dds.utn.frba.model.Student;
import dds.utn.frba.utils.JsonFactory;

public class AuthenticationController {

	private static final String NOTITAS_API = "https://notitas.herokuapp.com";

	private static final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

	public Student authenticate(String token) {

		ClientResponse response = Client.create().resource(NOTITAS_API).path("student")
				.header("Authorization", "Bearer " + token).accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		String student_json = response.getEntity(String.class);
		JsonFactory jsonFactory = new JsonFactory();
		return jsonFactory.fromJson(student_json, Student.class);

	}

}
