package tw.brad.h1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.h1.entity.Course;
import tw.brad.h1.entity.Student;
import tw.brad.h1.utils.HibernateUtil;

public class SCDao {
	public void save(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(student);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) transaction.rollback();
		}
	}
	
	public void save(Course course) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(course);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) transaction.rollback();
		}
	}
	
	public Student update(Student student) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.merge(student);
			
			transaction.commit();
			return getStudentById(student.getId());
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) transaction.rollback();
		}
		return null;
	}
	
	public Student getStudentById(Long sid) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Student.class, sid);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public Course getCourseById(Long cid) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.get(Course.class, cid);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public List<Course> getAllCourse(){
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery("FROM Course", Course.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	

	
}