package tw.brad.h1.tutor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import tw.brad.h1.entity.Member;
import tw.brad.h1.entity.Person;

public class Brad05 {

	public static void main(String[] args) throws Exception{
		Class<String> stringCls = String.class;
		Class<Person> memberCls = Person.class;
	
		System.out.println(stringCls.getName());
		System.out.println(memberCls.getName());
		System.out.println("----");
		for (Constructor<?> c : memberCls.getDeclaredConstructors()) {
			System.out.println(c);
		}
		System.out.println("----");
		for(Field f : memberCls.getDeclaredFields()) {
			System.out.printf("%s:%s:%s\n", 
					f.getModifiers(), 
					f.getType().getSimpleName(), 
					f.getName());
		}
		System.out.println("----");
		for(Method m : memberCls.getDeclaredMethods()) {
			System.out.println(m);
		}
		System.out.println("-------------------");
		Class<?> mClass = Class.forName("tw.brad.h1.entity.Person");
		Constructor<?> c = 
			mClass.getDeclaredConstructor(long.class, String.class, String.class);
		Object obj = c.newInstance(12L, "brad@brad.tw", "Brad");
		Method m = mClass.getDeclaredMethod("getEmail");
		Object result = m.invoke(obj);
		System.out.println(result);
		
		
	}
	
	

}