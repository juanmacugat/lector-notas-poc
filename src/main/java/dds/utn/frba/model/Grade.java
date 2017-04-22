package dds.utn.frba.model;

import java.time.LocalDateTime;

import org.uqbar.commons.utils.Observable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@Observable
public class Grade {
	
	@JsonProperty("id")
	private int id;

	@JsonProperty("value")
	private String value;

	@JsonProperty("created_at")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime created_at;
	
	@JsonProperty("updated_at")
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime updated_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	
	@Override
	public String toString(){
		return String.valueOf(value);
	}
	
	
	

}
