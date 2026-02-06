package tw.brad.h1.tutor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.h1.entity.Member;
import tw.brad.h1.utils.HibernateUtil;

public class Brad04 {
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction transaction = session.beginTransaction();
			
			String sql = """
					SELECT * FROM member
					""";
			NativeQuery<Member> query = session.createNativeQuery(sql, Member.class);
			List<Member> list = query.getResultList();
			for (Member member : list) {
				System.out.printf("%d:%s:%s\n", member.getId(),member.getEmail(),member.getName());
			}
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
		}		
	}
}