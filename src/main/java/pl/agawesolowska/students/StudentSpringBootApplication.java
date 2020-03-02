package pl.agawesolowska.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Simple CRUD app that connects to a database using Spring REST and Hibernate technologies.
 * 
 * @author Aga
 *
 */
@SpringBootApplication
public class StudentSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSpringBootApplication.class, args);
	}

}
