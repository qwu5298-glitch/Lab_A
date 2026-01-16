package tw.brad.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Brad43 {

	public static void main(String[] args) {
		File source = new File ("dir1/file2.txt");
		try {
			FileInputStream fin = new FileInputStream(source);
			int len; byte[] buf = new byte[(int)source.length()];
			fin.read(buf);
			System.out.println(new String(buf));
			
			
			fin.close();
//			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
