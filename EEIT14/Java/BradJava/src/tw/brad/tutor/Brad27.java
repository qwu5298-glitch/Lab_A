package tw.brad.tutor;

public class Brad27 {
	public static void main(String[] args) {
		Brad271 obj1 = new Brad271();
//		obj1.m1((byte)1);
		obj1.m1((byte)0, (byte)0);
	}
}
class Brad271 {
	// overload
	void m1() {}
	//int m1(int a) {System.out.println("m1(int)");return 1;}
	//int m1(byte a) {System.out.println("m1(byte)");return 1;}
	public int m1(double a) {System.out.println("m1(double)");return 1;}
	private int m1(byte a, int b) {System.out.println("m1(byte,int)");return 1;}
	int m1(int a, byte b) {System.out.println("m1(int,byte)");return 1;}
}