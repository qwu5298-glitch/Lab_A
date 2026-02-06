package tw.brad.h2;

import java.util.List;

import org.hibernate.Session;

import tw.brad.h2.entity.Employee;
import tw.brad.h2.util.HibernateUtil;

public class Brad03 {
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			String sql = """
					SELECT EmployeeID, FirstName fname, LastName, Title 
					FROM employees 
					ORDER BY Title ASC, LastName DESC
					""";
			List<Employee> employees = 
					session.createNativeQuery(sql, Employee.class).getResultList();
			System.out.println(employees.size());
			System.out.println("---");
			for (Employee e  : employees) {
				System.out.printf("%d:%s:%s:%s\n",
						e.getEmployeeId(),
						e.getFirstName(),
						e.getLastName(),
						e.getTitle());
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
