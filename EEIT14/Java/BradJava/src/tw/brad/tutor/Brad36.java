package tw.brad.tutor;

public class Brad36 {

	public static void main(String[] args) {
		// Exception 例外, 異常
		int a = 10 ,b = 3;
		int c;
		int[] d = {1,2,3,4,5};
		try {
			c = a / b;
			System.out.println(c);
			System.out.println(d[30]);
		}catch(ArithmeticException e) {
			System.out.println("Ooooop!");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("xxxxxx!");
		}catch(RuntimeException e) {
			System.out.println("XXX");
		}
		System.out.println("Game Over");

	}

}
