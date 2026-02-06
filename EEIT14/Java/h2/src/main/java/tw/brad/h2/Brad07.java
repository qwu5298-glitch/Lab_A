package tw.brad.h2;

import tw.brad.h2.entity.User;

public class Brad07 {
	public static void main(String[] args) {
		User user = new User.UserBuilder("Brad")
					.id(1)
					.age(18)
					.gender(true)
					.build();
		System.out.println(user.getAge());
		System.out.println("---------");
		
		User user2 = User.builder("Kevin")
				.id(2)
				.age(20)
				.gender(false)
				.build();
	}
}