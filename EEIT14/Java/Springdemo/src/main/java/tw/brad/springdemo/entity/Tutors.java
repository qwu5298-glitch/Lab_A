package tw.brad.springdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Data @Table(name = "tutors")
public class Tutors {
    @Id private Long id;
    @OneToOne @MapsId @JoinColumn(name = "id")
    private Users user;
    @Column(length = 50) private String title;
    @Column(length = 1000) private String intro;
    @Column(length = 500) private String certificate_1;
    @Column(nullable = false, length = 40) private String certificate_name_1;
    @Column(nullable = false, length = 500) private String certificate_2;
    @Column(nullable = false) private Integer certificate_name_2; // 資料庫定義為 int(11)
    @Column(length = 500) private String video_url_1;
    @Column(length = 500) private String video_url_2;
    @Column(length = 10) private String bank_code;
    @Column(length = 20) private String bank_account;
}