package tw.brad.h1.tutor;

import java.util.List;

import tw.brad.h1.entity.OrderItem;
import tw.brad.h1.service.OrderService;
import tw.brad.h1.service.OrderServiceImp;

public class Brad12 {
	public static void main(String[] args) {
		OrderService service = new OrderServiceImp();
		
		Long id = service.createOrder("Eric");
		System.out.println(id);
		service.addItem(id, "item3", 2, 100);
		service.addItem(id, "item4", 4, 300);
		
		
	}
}