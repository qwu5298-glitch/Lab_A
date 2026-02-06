package tw.brad.h1.tutor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.h1.utils.HibernateUtil;

public class Brad03 {
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction transaction = session.beginTransaction();
			
			String sql = """
					SELECT * FROM member
					""";
			NativeQuery query = session.createNativeQuery(sql);
			List list = query.getResultList();
			for (Object obj : list) {
				Object[] data = (Object[])obj;
				System.out.printf("%d:%s:%s:%s\n", data[0],data[1],data[2],data[3]);
			}
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
		}		
	}
}
