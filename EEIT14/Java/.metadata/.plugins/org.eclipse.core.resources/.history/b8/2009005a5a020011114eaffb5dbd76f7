package tw.brad.h1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "memberinfo")
public class MemberInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "gender")
	private boolean isMale;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	//-------------------------
	@OneToOne
	@MapsId
	@JoinColumn(name = "id")
	private Member member;

	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
}