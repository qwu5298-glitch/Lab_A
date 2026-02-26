package tw.brad.spring05.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.brad.spring05.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Long>{

}