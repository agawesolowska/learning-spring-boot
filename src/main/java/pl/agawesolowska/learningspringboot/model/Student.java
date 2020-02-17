package pl.agawesolowska.learningspringboot.model;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class Student {

	private final UUID id;

	@NotBlank
	private final String name;

	@NotNull
	@Min(0)
	private final Integer age;

	@NotBlank
	private final String fieldOfStudy;

	public Student(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("age") Integer age,
			@JsonProperty("fieldOfStudy") String fieldOfStudy) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.fieldOfStudy = fieldOfStudy;
	}

}
