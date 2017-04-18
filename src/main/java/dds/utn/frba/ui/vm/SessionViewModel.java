package dds.utn.frba.ui.vm;

import org.uqbar.commons.utils.Observable;

import dds.utn.frba.model.Student;

@Observable
public class SessionViewModel {

	private String token;
	private Student currentStudent;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Student getCurrentStudent() {
		return currentStudent;
	}

	public void setCurrentStudent(Student currentStudent) {
		this.currentStudent = currentStudent;
	}

}
