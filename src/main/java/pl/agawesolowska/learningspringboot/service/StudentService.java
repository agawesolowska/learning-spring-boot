package pl.agawesolowska.learningspringboot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pl.agawesolowska.learningspringboot.dao.StudentDao;
import pl.agawesolowska.learningspringboot.model.Student;

@Service
public class StudentService {

	private final StudentDao studentDao;

	@Autowired
	public StudentService(@Qualifier("mockService") StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public int addStudent(Student student) {
		return studentDao.insertStudent(student);
	}

	public List<Student> getAllStudents() {
		return studentDao.selectAllStudents();
	}

	public Optional<Student> getStudentById(UUID id) {
		return studentDao.selectStudentById(id);
	}

	public int correctStudentById(UUID id, Student updatedStudent) {
		return studentDao.updateStudentById(id, updatedStudent);
	}

	public int removeStudentById(UUID id) {
		return studentDao.deleteStudentById(id);
	}

}
