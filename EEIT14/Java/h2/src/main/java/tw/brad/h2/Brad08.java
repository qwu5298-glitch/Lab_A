package tw.brad.h2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import tools.jackson.databind.ObjectMapper;
import tw.brad.h2.dto.DetailItem;
import tw.brad.h2.dto.OrderItem;
import tw.brad.h2.util.HibernateUtil;

public class Brad08 {
	private static final String hql = """
			SELECT
				o.customer.cname,
				o.employee.lastName,
				o.orderDate,
				p.productName,
				d.unitPrice,
				d.quantity
			FROM Order o
			JOIN o.orderDetails d
			JOIN d.product p
			WHERE o.orderId = :orderId
			""";
	public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			List<Object[]> result = session.createQuery(hql, Object[].class)
					.setParameter("orderId", 10250)
					.getResultList();
			//-------------------------------------
			for (Object[] row : result) {
				System.out.println(row[0]);
				System.out.println(row[1]);
				System.out.println(row[2]);
				System.out.println(row[3] + ":" + row[4] + ":" + row[5]);
				System.out.println("--------------------");
			}
			System.out.println("--------JSON---------");
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writerWithDefaultPrettyPrinter()
					.writeValueAsString(result);
			System.out.println(json);
			System.out.println("-----");
			toObjectJSON(result);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private static void toObjectJSON(List<Object[]> result) {
		Map<String,Object> output = new HashMap<>();
		output.put("customer", result.get(0)[0]);
		output.put("employee", result.get(0)[1]);
		output.put("date", result.get(0)[2]);
		
		List<Map<String,Object>> details = new ArrayList<>();
		for (Object[] row : result) {
			Map<String,Object> detail = new HashMap<>();
			detail.put("pname", row[3]);
			detail.put("price", row[4]);
			detail.put("qty", row[5]);
			details.add(detail);
		}
		
		output.put("details", details);
		
		//---------------------------
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(output);
		System.out.println("--------JSON-Object--------");
		System.out.println(json);
		
		System.out.println("--------to-Object--------");
		toOrderItem(json);
	}
	
	public static void toOrderItem(String json) {
		ObjectMapper mapper = new ObjectMapper();
		OrderItem order = mapper.readValue(json, OrderItem.class);
		//-------------------------
		System.out.println(order.customer);
		System.out.println(order.employee);
		System.out.println(order.date);
		System.out.println(order.details.size());
		for (DetailItem detail : order.details) {
			System.out.println(detail.pname +":"+detail.price + ":" + detail.qty);
		}
	}
	
}