package tw.brad.springdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.brad.springdemo.entity.Courses;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, Long> {
    // 可以在這裡擴充額外的查詢方法
}
