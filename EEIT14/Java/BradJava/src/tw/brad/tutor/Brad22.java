package tw.brad.tutor;

public class Brad22 {

	public static void main(String[] args) {
		System.out.println("Brad".charAt(2));
		String s1 = "Brad";
		String s2 = "Brad";
		int a = 10 , b = 3;
		System.out.println(a == b);
		System.out.println(s1 == s2);
		String s3 = new String("Brad");
		String s4 = new String("Brad");
		System.out.println(s3 == s4);
		System.out.println(s1 == s3);
		
		System.out.println(s1.equals(s4));

	}

}
