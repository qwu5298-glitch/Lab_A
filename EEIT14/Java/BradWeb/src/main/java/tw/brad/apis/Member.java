package tw.brad.apis;

public class Member {
	private Long id;
	private String email, passwd, name;
	private byte[] icon;
	private byte[] bike;
	private String iconBase64;
	
	public String getIconBase64() {
		return iconBase64;
	}
	public void setIconBase64(String iconBase64) {
		this.iconBase64 = iconBase64;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public byte[] getBike() {
		return bike;
	}
	public void setBike(byte[] bike) {
		this.bike = bike;
	}
	
	
}