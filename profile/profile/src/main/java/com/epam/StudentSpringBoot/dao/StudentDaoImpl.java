package com.epam.StudentSpringBoot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;
import com.epam.StudentSpringBoot.model.Profile;
import com.epam.StudentSpringBoot.model.Student;

@Component
public class StudentDaoImpl implements StudentDao {
	EntityManagerFactory eManagerFactory = Persistence.createEntityManagerFactory("my-local-mysql");
	EntityManager entityManager = eManagerFactory.createEntityManager();

	@Override
	public Student createStudent(Student s) {
		transactionCommit(entityManager, s);
		return s;
	}
	
	@Override
	public Profile createProfile(Profile p) {
		transactionCommit(entityManager, p);
		return p;
	}
	

	@Override
	public Student getStudentByRollNo(int sid) {
		Student student = entityManager.find(Student.class, sid);
		return student;
	}
	@Override
	public Profile getProfileById(long id) {
		Profile profile = entityManager.find(Profile.class, id);
		return profile;
	}
	@Override 
	public Profile getProfileByName(String profileName) {
		Profile profile = entityManager.find(Profile.class, profileName);
		return profile;
	}
	
	@Override
	public List<Student> getAll() {
		List<Student> list = entityManager.createQuery("select stu from Student stu").getResultList();
		return list;
	}
	
	@Override
	public List<Profile> getAllProf() {
		List<Profile> list = entityManager.createQuery("select p from Profile p").getResultList();
		return list;
	}

	@Override
	public void deleteStd(int sid) {
		Student student = entityManager.find(Student.class, sid);
		entityManager.getTransaction().begin();
		entityManager.remove(student);
		entityManager.getTransaction().commit();

	}
	@Override
	public void deleteProf(long id) {
		Profile profile = entityManager.find(Profile.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(profile);
		entityManager.getTransaction().commit();
	}
	
	@Override
	public void updateStd(Student s) {
		entityManager.getTransaction().begin();
		entityManager.merge(s);
		entityManager.getTransaction().commit();
	}
	@Override
	public void updateProf(Profile p) {
		entityManager.getTransaction().begin();
		entityManager.merge(p);
		entityManager.getTransaction().commit();
	}

	private static void transactionCommit(EntityManager entityManager, Object object) {
		entityManager.getTransaction().begin();
		entityManager.persist(object);
		entityManager.getTransaction().commit();
	}
}