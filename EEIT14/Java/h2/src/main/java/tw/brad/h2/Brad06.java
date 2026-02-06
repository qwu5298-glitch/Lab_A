package tw.brad.h2;

import java.util.List;

import org.hibernate.Session;

import tw.brad.h2.entity.Employee;
import tw.brad.h2.util.HibernateUtil;

public class Brad06 {
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			String hql = """
					FROM Employee e 
					ORDER BY e.title ASC, e.lastName DESC
					""";
			List<Employee> employees = 
					session.createQuery(hql, Employee.class).getResultList();
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