package tw.brad.springdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data @Table(name = "reviews")
public class Reviews {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    @ManyToOne @JoinColumn(name = "course_id", nullable = false)
    private Courses course;
    @Column(name = "focus_score", nullable = false) private Byte focusScore;
    @Column(name = "comprehension_score", nullable = false) private Integer comprehensionScore;
    @Column(name = "confidence_score", nullable = false) private Integer confidenceScore;
    @Column(length = 1000) private String comment;
}