package tw.brad.h1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "oitem")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "pname", nullable = false, length = 100)
	private String pname;
	
	@Column(nullable = false)
	private int qty;
	
	@Column(nullable = false)
	private int price;
	
	
	public OrderItem() {}
	public OrderItem(String pname, int qty, int price) {
		this.pname = pname; this.qty = qty; this.price = price;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	//------------------------------
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oid", nullable = false)
	private Order order;

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}