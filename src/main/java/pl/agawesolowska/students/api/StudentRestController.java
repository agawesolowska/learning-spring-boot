package pl.agawesolowska.students.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.agawesolowska.students.entity.Student;
import pl.agawesolowska.students.service.StudentService;

/**
 * The heart of the students' web service responding to HTTP queries.
 * 
 * @author Aga
 *
 */
@RestController
@RequestMapping("/api/v1/students")
public class StudentRestController {

	private StudentService studentService;

	@Autowired
	public StudentRestController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping
	public void addStudent(@Valid @NotNull @RequestBody Student student) {
		studentService.addStudent(student);
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable UUID id) {
		return studentService.getStudentById(id);
	}

	@PutMapping("/{id}")
	public void correctStudentById(@PathVariable UUID id, @Valid @NotNull @RequestBody Student updatedStudent) {
		studentService.correctStudentById(id, updatedStudent);
	}

	@DeleteMapping("/{id}")
	public void removeStudentById(@PathVariable UUID id) {
		studentService.removeStudentById(id);
	}

}
