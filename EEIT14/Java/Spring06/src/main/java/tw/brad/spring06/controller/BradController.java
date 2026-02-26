package tw.brad.spring06.controller;

import java.rmi.registry.Registry;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.brad.spring06.annotation.BradAOP;
import tw.brad.spring06.dto.Register;

@RequestMapping("/brad")
@RestController
public class BradController {

	@RequestMapping("/test1")
	public void test11(@RequestParam String name, 
			@RequestParam int age) {
		System.out.printf("%s : %d\n", name, age);
	}
	
	@BradAOP
	@RequestMapping("/test2")
	public void test22() {
		System.out.println("test22");
	}
	
	@RequestMapping("/test3")
	public void test3(@RequestBody Register register) {
		System.out.println("==> " + register.getAccount());
	}
	
}