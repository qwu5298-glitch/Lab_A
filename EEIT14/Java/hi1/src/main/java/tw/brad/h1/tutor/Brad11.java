package tw.brad.h1.tutor;

import java.util.List;

import tw.brad.h1.entity.OrderItem;
import tw.brad.h1.service.OrderService;
import tw.brad.h1.service.OrderServiceImp;

public class Brad11 {
	public static void main(String[] args) {
		OrderService service = new OrderServiceImp();
		
		//Long id = service.createOrder("Tony");
		//System.out.println(id);
		
		List<OrderItem> items = List.of(new OrderItem("item1", 7, 100),
				new OrderItem("item2", 1, 430),
				new OrderItem("item4", 5, 50));
		Long id = service.createOrderWithItems("Kevin", items);
		System.out.println(id);
		
	}
}