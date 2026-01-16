package tw.brad.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Brad46 {

	public static void main(String[] args) {
		File source = new File ("dir1/file2.txt");
		int c;
		try {
			FileReader reader = new FileReader(source);
			while((c = reader.read())!= -1) {
				System.out.print((char)c);
			}
			
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		

	}

}
