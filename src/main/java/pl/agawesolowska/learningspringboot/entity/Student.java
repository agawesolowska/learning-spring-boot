package pl.agawesolowska.learningspringboot.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private UUID id;

	@NotBlank
	@Column(name="name")
	private String name;

	@NotNull
	@Min(0)
	@Column(name="age")
	private Integer age;

	@NotBlank
	@Column(name="field_of_study")
	private String fieldOfStudy;

	public Student(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("age") Integer age,
			@JsonProperty("fieldOfStudy") String fieldOfStudy) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.fieldOfStudy = fieldOfStudy;
	}

}
