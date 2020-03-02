package pl.agawesolowska.students.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import pl.agawesolowska.students.entity.Student;

@Repository("mockDataAccess")
public class MockStudentDataAccess implements StudentDao {

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
		Optional<Student> optionalStudent = selectStudentById(id);
		if (optionalStudent.isEmpty()) {
			return 0;
		} else {
			optionalStudent.map(student -> {
				int indexOfStudentToUpdate = DB.indexOf(student);
				DB.set(indexOfStudentToUpdate, new Student(id, studentToUpdate.getName(), studentToUpdate.getAge(),
						studentToUpdate.getFieldOfStudy()));
				return 1;
			});
		}
		return 0;
	}

	@Override
	public int deleteStudentById(UUID id) {
		Optional<Student> optionalStudent = selectStudentById(id);
		if (optionalStudent.isEmpty()) {
			return 0;
		} else {
			DB.remove(optionalStudent.get());
			return 1;
		}
	}

}
