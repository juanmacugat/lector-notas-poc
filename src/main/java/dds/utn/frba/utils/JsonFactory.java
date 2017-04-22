package dds.utn.frba.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonFactory {

	private ObjectMapper objectMapper;

	public JsonFactory() {
		this.objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public String toJson(Object object) {
		try {
			String jsonString = this.objectMapper.writeValueAsString(object);
			return jsonString;
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Error creating a json", e);
		}
	}

	public <T> T fromJson(String json, Class<T> typeReference) {
		try {
			return this.objectMapper.readValue(json, typeReference);
		} catch (IOException e) {

			throw new RuntimeException("Error reading a json", e);
		}
	}

	public <T> T fromJson(final TypeReference<T> type, final String jsonPacket) {
		T data = null;

		try {
			data = new ObjectMapper().readValue(jsonPacket, type);
		} catch (Exception e) {
			System.out.println("Hola");
		}
		return data;
	}

}