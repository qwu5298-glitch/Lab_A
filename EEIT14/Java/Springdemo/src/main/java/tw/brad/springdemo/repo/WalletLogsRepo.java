package tw.brad.springdemo.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import tw.brad.springdemo.entity.WalletLogs;


public interface WalletLogsRepo extends JpaRepository<WalletLogs, Long> {
    // 按時間倒序查詢使用者的所有錢包變動
    List<WalletLogs> findByUser_IdOrderByCreatedAtDesc(Long userId);
}
