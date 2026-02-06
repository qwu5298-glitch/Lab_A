package tw.brad.h1.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.h1.dao.OrderDao;
import tw.brad.h1.dao.OrderDaoImp;
import tw.brad.h1.entity.Member;
import tw.brad.h1.entity.Order;
import tw.brad.h1.entity.OrderItem;
import tw.brad.h1.utils.HibernateUtil;

public class OrderServiceImp implements OrderService{
	private OrderDao dao = new OrderDaoImp(); 
	
	@Override
	public Long createOrder(String customer) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = new Order();
			order.setCustomer(customer);
			Long orderId = dao.save(session, order);
			
			transaction.commit();
			return orderId;
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}			
		return -1L;
	}

	@Override
	public Long createOrderWithItems(String customer, List<OrderItem> items) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = new Order();
			order.setCustomer(customer);
			
			for (OrderItem item: items) {
				order.addItem(item);
			}
			
			Long orderId = dao.save(session, order);
			
			transaction.commit();
			return orderId;
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}			
		return -1L;
	}

	@Override
	public void changeCustomerName(Long orderId, String newName) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findById(session, orderId)
					.orElseThrow(() -> new IllegalArgumentException("訂單找不到"));
			
			order.setCustomer(newName);
			
			transaction.commit();
		}		
	}

	@Override
	public void addItem(Long orderId, String pname, int qty, int price) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findById(session, orderId)
					.orElseThrow(() -> new IllegalArgumentException("訂單找不到"));
			
			order.addItem(new OrderItem(pname, qty, price));
			
			transaction.commit();
		}				
	}

	@Override
	public void updateItemQty(Long orderId, Long itemId, int newQty) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();

			Order order = dao.findByIdWithItems(session, orderId)
					.orElseThrow(() -> new IllegalArgumentException("訂單找不到"));
			
//			boolean isFind = false;
//			List<OrderItem> items = order.getItems();
//			for (OrderItem item : items) {
//				if (item.getId().equals(itemId)) {
//					item.setQty(newQty);
//					isFind = true;
//					break;
//				}
//			}
//			if (!isFind) throw new IllegalArgumentException("品項找不到");
				
			
			
			OrderItem item = order.getItems().stream()
							.filter(i -> i.getId().equals(itemId))
							.findFirst()
							.orElseThrow(
								() -> new IllegalArgumentException("品項找不到"));
			/*
			 * stream() => Stream<OrderItem>
			 * 期間操作
			 * 		filter()
			 * 		map()
			 * 		sorted()
			 * 		limit()
			 * 收尾操作
			 * 		findFirst()
			 * 		toList()
			 * 		sum()
			 * 		count()
			 * 		forEach()
			 */
			
			
			item.setQty(newQty);
			
			
			transaction.commit();
		}				
	}

	@Override
	public void removeItem(Long orderId, Long itemId) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findByIdWithItems(session, orderId)
				.orElseThrow(()-> new IllegalArgumentException("訂單找不到"));
			
			OrderItem item = order.getItems().stream()
				.filter(i -> i.getId().equals(itemId))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("品項找不到"));
			order.removeItem(item);
			
			transaction.commit();
		}				
	}

	@Override
	public Order getOrderWithItems(Long orderId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			return dao.findByIdWithItems(session, orderId)
				.orElseThrow(()-> new IllegalArgumentException("訂單找不到"));
		}			
	}

	@Override
	public void deleteOrder(Long orderId) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Order order = dao.findById(session, orderId)
				.orElseThrow(()-> new IllegalArgumentException("訂單找不到"));
			
			dao.delete(session, order);
			
			transaction.commit();
		}		
	}

}