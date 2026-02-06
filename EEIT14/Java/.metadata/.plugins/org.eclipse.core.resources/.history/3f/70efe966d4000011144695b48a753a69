package tw.brad.h1.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;

import tw.brad.h1.entity.Order;

public class OrderDaoImp implements OrderDao{

	@Override
	public Long save(Session session, Order order) {
		session.persist(order);
		return order.getId();
	}

	@Override
	public Optional<Order> findById(Session session, Long id) {
		return Optional.ofNullable(session.get(Order.class, id)); 
	}

	@Override
	public Optional<Order> findByIdWithItems(Session session, Long id) {
		// LEFT JOIN => 沒有 item 也要查到
		String hql = """
				SELECT o
				FROM Order o
				LEFT JOIN FETCH o.items
				WHERE o.id = :id
				""";
		Order o = session.createQuery(hql, Order.class)
				.setParameter("id", id)
				.uniqueResult();
		return Optional.ofNullable(o);
	}

	@Override
	public void delete(Session session, Order order) {
		session.remove(order);
	}

	@Override
	public List<Order> findAll(Session session, int start, int size) {
		String hql = """
				SELECT o
				FROM Order o
				ORDER BY o.id DESC
				""";
		return session.createQuery(hql, Order.class)
				.setFirstResult(start)
				.setMaxResults(size)
				.list();
	}
	
	//---------- HQL --------------
	public void test1(Session session) {
		String hql = """
				SELECT o
				FROM Order o
				ORDER BY o.odate DESC
				""";
		List<Order> orders = session.createQuery(hql, Order.class).list();
	}
	public void test2(Session session) {
		String hql = """
				SELECT o
				FROM Order o
				WHERE o.customer = :cname
				""";
		List<Order> orders = session.createQuery(hql, Order.class)
				.setParameter("cname", "Brad").list();
	}
	public void test3(Session session) {
		String hql = """
				SELECT o
				FROM Order o
				WHERE o.id = :id
				""";
		Order order = session.createQuery(hql, Order.class)
				.setParameter("id", 1L).uniqueResult();
	}
	
	public void test4(Session session) {
		String hql = """
				SELECT DISTINCT o
				FROM Order o
				JOIN o.items i
				WHERE i.pname LIKE :key
				ORDER BY o.id
				""";
		List<Order> order = session.createQuery(hql, Order.class)
				.setParameter("id", 1L).list();
	}
	
	public void test5(Session session) {
		String hql = """
				SELECT o
				FROM Order o
				LEFT JOIN FETCH o.items
				WHERE o.id = :id
				""";
		Order order = session.createQuery(hql, Order.class)
				.setParameter("id", 1L).uniqueResult();
	}
	
	
	
	
	
	
	

}