package tw.brad.tutor;

import java.io.File;

public class Brad40 {

	public static void main(String[] args) {
		File f1 = new File("d:/brad/test");
		if(f1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
