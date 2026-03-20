package tw.brad.spring11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.brad.spring11.entity.Member;
import tw.brad.spring11.repo.MemberRepo;
import tw.brad.spring11.util.BCrypt;

@Service
public class MemberService {
	@Autowired
	private MemberRepo repo;
	
	public Member register(String email, String passwd, String name) {
		if (repo.existsByEmail(email)) throw new IllegalArgumentException("email exist");
		
		Member member = new Member();
		member.setEmail(email);
		member.setPasswd(BCrypt.hashpw(passwd, BCrypt.gensalt()));
		member.setName(name);
		Member savedMember = repo.save(member);
		return savedMember;
	}
}