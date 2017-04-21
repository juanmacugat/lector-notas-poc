package dds.utn.frba.service;

import java.util.List;

import dds.utn.frba.model.Assignment;
import dds.utn.frba.model.Student;
import dds.utn.frba.utils.JsonFactory;

public class NotitasServiceMock implements NotitasService{
	
	private String token;
	
	public static NotitasServiceMock getInstance(String token){
		return new NotitasServiceMock(token);
	}
	
	private NotitasServiceMock(String token){
		this.token = token;
	}

	@Override
	public Student getStudent() {
		String student = "{\"code\":\"111222333\",\"first_name\":\"fasdd\",\"last_name\":\"Fulanito\",\"github_user\":\"fulanoDeTal\"}";
		JsonFactory jsonFactory = new JsonFactory();
		return jsonFactory.fromJson(student, Student.class);
	}

	@Override
	public List<Assignment> getAssignments() {
		String assignments = "{\"assignments\":[{\"id\":1,\"title\":\"Primer Parcial\",\"description\":null,\"grades\":[{\"id\":1,\"value\":2,\"created_at\":\"2017-03-25T13:56:07.526Z\",\"updated_at\":\"2017-03-25T13:56:07.526Z\"},{\"id\":2,\"value\":7,\"created_at\":\"2017-03-25T13:56:07.595Z\",\"updated_at\":\"2017-03-25T13:56:07.595Z\"}]},{\"id\":3,\"title\":\"TPA1\",\"description\":\"Primera Entrega del TP Anual\",\"grades\":[{\"id\":4,\"value\":\"B+\",\"created_at\":\"2017-03-25T13:56:07.649Z\",\"updated_at\":\"2017-03-25T13:56:07.649Z\"}]}]}";
		JsonFactory jsonFactory = new JsonFactory();
		return jsonFactory.fromJson(assignments, Student.class).getAssignments();
	}

	@Override
	public void updateStudent(Student student) {
		
	}

}
