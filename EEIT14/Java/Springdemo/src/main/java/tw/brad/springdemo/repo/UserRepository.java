package tw.brad.springdemo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.brad.springdemo.entity.Users;


public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    Optional<Users> findBySocialProviderAndSocialId(Byte provider, String socialId);

}