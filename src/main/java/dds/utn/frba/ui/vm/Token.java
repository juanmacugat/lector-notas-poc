package dds.utn.frba.ui.vm;

import org.uqbar.commons.utils.Observable;

import dds.utn.frba.model.Student;

@Observable
public class Token {

	private String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiIxMTEyMjIzMzMiLCJybmQiOiJ5SXNmZFIwN2lIR3BRRmVjYU9KT2VRPT0ifQ.9pVJGUXhrJPQ-TptNCt971l0h_1dWqWgMrHAWXJchho";

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
