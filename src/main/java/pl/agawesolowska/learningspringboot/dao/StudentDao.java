package pl.agawesolowska.learningspringboot.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import pl.agawesolowska.learningspringboot.model.Student;

public interface StudentDao {

	default int insertStudent(Student student) {
		UUID id = UUID.randomUUID();
		return insertStudent(id, student);
	}

	int insertStudent(UUID id, Student student);

	List<Student> selectAllStudents();

	Optional<Student> selectStudentById(UUID id);

	int updateStudentById(UUID id, Student studentToUpdate);

	int deleteStudentById(UUID id);

}
