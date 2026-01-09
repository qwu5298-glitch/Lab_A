package tw.brad.tutor;

public class Brad24 {

	public static void main(String[] args) {
		Brad242 obj1 = new Brad242();
//		Brad241 obj2 = new Brad241();
//		Brad241 obj3 = new Brad241();
//		obj1.m1();
//		obj1.m2();
	}
}
	

class Brad241{
	int a =123;
	
	{System.out.println("{}"+a);}
	static {System.out.println("static{}");}
	
	Brad241(){System.out.println("Brad241()"+a);}
	void m1(){System.out.println("Brad241():m1");}
	static void m2() {System.out.println("Brad241():m2");}
}	
	
class Brad242 extends Brad241{
	Brad242(){System.out.println("Brad242()");}
}
	
	
	
	

