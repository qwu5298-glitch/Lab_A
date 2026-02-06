package tw.brad.h1.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table( name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "passwd")
	private String passwd;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "icon")
	private byte[] icon;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getIcon() {
		return icon;
	}

	public void setIcon(byte[] icon) {
		this.icon = icon;
	}
	
	//-------------------------
	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	private MemberInfo memberinfo;

	public MemberInfo getMemberinfo() {
		return memberinfo;
	}

	public void setMemberinfo(MemberInfo memberinfo) {
		this.memberinfo = memberinfo;
		memberinfo.setMember(this);
	}
	
	
}