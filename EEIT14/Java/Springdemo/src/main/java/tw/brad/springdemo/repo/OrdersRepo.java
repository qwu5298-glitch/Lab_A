package tw.brad.springdemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.brad.springdemo.entity.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Long> {
    // 查詢該學生的所有訂單 (課程包)
    List<Orders> findByUser_Id(Long userId);
}
