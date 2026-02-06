package tw.brad.h2;

import tw.brad.h2.dao.CustomerDao;
import tw.brad.h2.entity.Customer;

public class Brad02 {

	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		Customer c1 = dao.getById("ANTON");
		System.out.println(c1.getCname() + ":" + c1.getPhone());
	}

}