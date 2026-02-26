package tw.brad.spring09.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.brad.spring09.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{
	Optional<Member> findByEmail(String email);
}