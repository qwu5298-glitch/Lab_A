package tw.brad.h1.tutor;

import java.util.List;

import tw.brad.h1.dao.MemberDao;
import tw.brad.h1.entity.Member;
import tw.brad.h1.utils.BCrypt;

public class Brad06 {

	public static void main(String[] args) {
		Member m1 = new Member();
		m1.setEmail("test5@brad.tw");
		m1.setPasswd(BCrypt.hashpw("12345678", BCrypt.gensalt()));
		m1.setName("Test3");
		
		MemberDao dao = new MemberDao();
		//dao.addMember(m1);
		
		Member m2 = dao.findById(9);
		if (m2 != null) {
			System.out.println(m2.getEmail());
			dao.delMember(m2);
		}
		
		List<Member> members = dao.findAll();
		for (Member member : members) {
			System.out.println(member.getEmail());
		}
		System.out.println("------");
		List<Member> ms = dao.findByLike("test");
		for (Member member : ms) {
			System.out.println(member.getEmail() + ":" + member.getName());
		}
		
		
	}

}