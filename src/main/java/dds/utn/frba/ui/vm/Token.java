package dds.utn.frba.ui.vm;

import org.uqbar.commons.utils.Observable;

import dds.utn.frba.model.Student;

@Observable
public class Token {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
