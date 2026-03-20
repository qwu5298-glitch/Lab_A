package tw.brad.springdemo.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tw.brad.springdemo.entity.Bookings;

@Repository
public interface BookingsRepo extends JpaRepository<Bookings, Long> {
    // 查詢該學生的所有排課紀錄
    @Query("SELECT b FROM Bookings b WHERE b.student.id = :studentId")
    List<Bookings> findByStudent_Id(Long studentId);
    
    List<Bookings> findByOrder_Id(Long orderId);
    Optional<Bookings> findByIdAndStudent_Id(Long id, Long studentId);
    
    List<Bookings> findByStudentIdAndDateOrderByHourAsc(Long studentId, LocalDate date);

}
