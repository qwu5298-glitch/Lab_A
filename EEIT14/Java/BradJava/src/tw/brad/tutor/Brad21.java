package tw.brad.tutor;

import tw.brad.apis.Bike;

public class Brad21 {

	public static void main(String[] args) {
		String s1 = new String();
		byte[] b2 = {65,66,67,68};
		String s2 = new String(b2);
		System.out.println(s1);
		System.out.println(s2);
		
		Bike b1 = new Bike();
		System.out.println(b1);
		
		String s3 = new String(b2,1,2);
		System.out.println(s3);
		
		char c1 = '資';
		char c2 = s2.charAt(2);
		System.out.println(c2);
		
	}

}
