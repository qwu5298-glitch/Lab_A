package tw.brad.tutor;

public class Brad38 {
	public static void main(String[] args) {
		Brad381.m1();
	}
}
class Brad381 {
	static void m1() {
		try {
			System.out.println(10 / 0);;
			System.out.println("try");
			//return;
		}catch(Exception e) {
			System.out.println("ee");
			return;
		}finally {
			System.out.println("f");
		}
		System.out.println("OK");
	}
}