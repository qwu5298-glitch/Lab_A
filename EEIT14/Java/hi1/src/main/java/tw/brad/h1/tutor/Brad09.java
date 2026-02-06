package tw.brad.h1.tutor;

import tw.brad.h1.dao.MemberDao;
import tw.brad.h1.entity.Member;

public class Brad09 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		Member member = dao.findById(14);
		if (member != null) {
			System.out.printf("%d. %s : %s\n", 
				member.getId(), member.getEmail(), 
				member.getMemberinfo()!=null?member.getMemberinfo().getBirthday():"NO INFO");
			dao.delMember(member);
			System.out.println("Delete Success");
		}else {
			System.out.println("ID NOT FOUND");
		}
		
	}

}