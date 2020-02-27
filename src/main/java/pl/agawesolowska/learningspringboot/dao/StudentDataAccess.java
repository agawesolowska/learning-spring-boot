package pl.agawesolowska.learningspringboot.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.agawesolowska.learningspringboot.entity.Student;

@Repository("dataAccess")
public class StudentDataAccess implements StudentDao {

	private EntityManager entityManager;

	@Autowired
	public StudentDataAccess(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public int insertStudent(UUID id, Student student) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(student);
		return 1;
	}

	@Override
	public List<Student> selectAllStudents() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Student> query = currentSession.createQuery("from Student order by age", Student.class);
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public Optional<Student> selectStudentById(UUID id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Student> query = currentSession.createQuery("from Student where id=:studentId", Student.class);
		query.setParameter("studentId", id);
		Optional<Student> student = query.uniqueResultOptional();
		return student;
	}

	@Override
	public int updateStudentById(UUID id, Student studentToUpdate) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student student = currentSession.get(Student.class, id);
		student.setName(studentToUpdate.getName());
		student.setAge(studentToUpdate.getAge());
		student.setFieldOfStudy(studentToUpdate.getFieldOfStudy());
		currentSession.saveOrUpdate(student);
		return 1;
	}

	@Override
	public int deleteStudentById(UUID id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Student> query = currentSession.createQuery("delete from Student where id=:studentId");
		query.setParameter("studentId", id).executeUpdate();
		return 1;
	}

}
