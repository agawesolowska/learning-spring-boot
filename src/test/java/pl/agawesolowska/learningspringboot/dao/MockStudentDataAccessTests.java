package pl.agawesolowska.learningspringboot.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import pl.agawesolowska.learningspringboot.entity.Student;

public class MockStudentDataAccessTests {

	private MockStudentDataAccess underTest;

	@Before
	public void setUp() {
		underTest = new MockStudentDataAccess();
	}

	@Test
	public void canPerformCrud() {

		// Taking into consideration 3 students (by name, age and field of study):
		UUID firstId = UUID.randomUUID();
		Student firstStudent = new Student(firstId, "Fae Izsak", 23, "Chemistry");

		UUID secondId = UUID.randomUUID();
		Student secondStudent = new Student(secondId, "Fionnula Egdale", 20, "Computer Science");

		UUID thirdId = UUID.randomUUID();
		Student thirdStudent = new Student(thirdId, "Reagan Guppey", 24, "Medicine");

		// Testing insertStudent method:
		int firstExpectedResult = underTest.insertStudent(firstStudent);
		int secondExpectedResult = underTest.insertStudent(secondStudent);
		int thirdExpectedResult = underTest.insertStudent(thirdStudent);

		assertEquals(1, firstExpectedResult);
		assertEquals(1, secondExpectedResult);
		assertEquals(1, thirdExpectedResult);

		// Testing sellectAllStudents method:
		List<Student> studentsList = underTest.selectAllStudents();
		assertThat(studentsList).hasSize(3);

		// Testing selectStudentById method:
		Optional<Student> optionalStudent = underTest.selectStudentById(firstId);
		assertEquals(firstStudent, optionalStudent);

		// Testing updateStudentById method:
		Student studentToUpdate = new Student(firstId, "Fae John Izsak", 25, "Biotechnology");
		int fourthExpectedResult = underTest.updateStudentById(firstId, studentToUpdate);
		assertEquals(1, fourthExpectedResult);

		// Testing deleteStudentById method:
		assertThat(underTest.deleteStudentById(firstId)).isEqualTo(1);

	}

}
