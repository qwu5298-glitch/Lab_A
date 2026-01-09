package tw.brad.tutor;

public class Brad16 {

	public static void main(String[] args) {
		int a = 10, b = 3;
		a = a ^ b; //a=13
		b = a ^ b; //b=10
		a = a ^ b; //a=3
		System.out.printf("a = %d, b = %d", a, b);

	}

}