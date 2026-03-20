package tw.brad.springdemo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.brad.springdemo.entity.Users;

public interface UsersRepo extends JpaRepository<Users, Long>{
    Optional<Users> findById(Long id);
}
