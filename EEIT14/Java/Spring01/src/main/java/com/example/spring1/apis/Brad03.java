package com.example.spring1.apis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // =>Bean =>IoC =>Server Starting
@RequestMapping("/brad03")
public class Brad03 {
	public Brad03() {System.out.println("Brad03()");}
	
	@RequestMapping("/test1")
	public void test1() {
		System.out.println("Brad03:test1()");
	}@RequestMapping("/test2")
	public void test2() {
		System.out.println("Brad03:test2()");
	}
	@RequestMapping("/test3")
	public String test3() {
		System.out.println("Brad03:test3()");
		return "<h1>Hello,Brad<h1>";
	}
}
