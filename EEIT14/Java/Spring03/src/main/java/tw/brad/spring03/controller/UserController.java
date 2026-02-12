package tw.brad.spring03.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.brad.spring03.dto.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@RequestMapping("/test1")
	public void test1() {
		//User user = User.builder().id(100).name("OK").gender(false).build();
		User user = new User();
		user.setId(123);
		user.setName("Brad");
		user.setGender(true);
		System.out.println(user);
		
		
	}
}