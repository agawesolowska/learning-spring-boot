package pl.agawesolowska.learningspringboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import pl.agawesolowska.learningspringboot.model.Student;

@Repository("mockService")
public class MockStudentDataAccessService implements StudentDao {

	private static List<Student> DB = new ArrayList<>();

	@Override
	public int insertStudent(UUID id, Student student) {
		DB.add(new Student(id, student.getName(), student.getAge(), student.getFieldOfStudy()));
		return 1;
	}

	@Override
	public List<Student> selectAllStudents() {
		return DB;
	}

	@Override
	public Optional<Student> selectStudentById(UUID id) {
		return DB.stream().filter(student -> student.getId().equals(id)).findFirst();
	}

	@Override
	public int updateStudentById(UUID id, Student studentToUpdate) {
		return selectStudentById(id).map(student -> {
			int indexOfStudentToUpdate = DB.indexOf(student);
			if (indexOfStudentToUpdate >= 0) {
				DB.set(indexOfStudentToUpdate, new Student(id, studentToUpdate.getName(), studentToUpdate.getAge(),
						studentToUpdate.getFieldOfStudy()));
				return 1;
			}
			return 0;
		}).orElse(0);
	}

	@Override
	public int deleteStudentById(UUID id) {
		Optional<Student> optionalPerson = selectStudentById(id);
		if (optionalPerson.isEmpty()) {
			return 0;
		}
		DB.remove(optionalPerson.get());
		return 1;
	}
	
}
