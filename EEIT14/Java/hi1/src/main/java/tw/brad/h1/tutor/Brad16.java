package tw.brad.h1.tutor;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import tw.brad.h1.dao.SCDao;
import tw.brad.h1.entity.Course;
import tw.brad.h1.entity.Student;

public class Brad16 {
	public static void main(String[] args) {
		SCDao dao = new SCDao();
		Student s1;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Student ID:");
		long sid = scanner.nextLong();
		
		s1 = dao.getStudentById(sid);
		System.out.printf("Welcome, %s", s1.getSname());
		
		while (true) {
			List<Course> courses = dao.getAllCourse();
			for (Course course : courses) {
				if (!isExist(s1, course.getStudents())) {
					System.out.printf("%d. %s\n", course.getId(), course.getCname());
				}
			}
			System.out.println("-----");
			System.out.println("Which? (0: for EXIST):");
			long cid = scanner.nextLong();
			
			if (cid <= 0) break;
			
			s1.addCourse(dao.getCourseById(cid));
			s1 =dao.update(s1);
		}
	}
	
	static boolean isExist(Student s, Set<Student> students) {
		return students.stream()
				.anyMatch(student -> student.getId().equals(s.getId()));
	}
	
	
	
}