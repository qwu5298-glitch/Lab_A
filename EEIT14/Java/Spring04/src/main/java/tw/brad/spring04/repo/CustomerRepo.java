package tw.brad.spring04.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tw.brad.spring04.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String>{
	@Query("""
			SELECT c
			FROM Customer c
			WHERE c.customerid = :id
			""")
	Optional<Customer> findByCustomerID(@Param("id") String id);
}