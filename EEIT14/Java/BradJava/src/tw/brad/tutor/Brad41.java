package tw.brad.tutor;

import java.io.File;
import java.io.IOException;

public class Brad41 {

	public static void main(String[] args) {
		File root = new File(".");
		System.out.println(root.getAbsolutePath());
		File dir1 = new File("./dir1");
		File dir2 = new File("./dir2");
		File dir3 = new File("./dir3");
		System.out.println(dir1.exists());
		System.out.println(dir2.exists());
		if(!dir3.exists()) {
			dir3.mkdir();
		}else{
			System.out.println("dir3 exist");
		}
		System.out.println("----");
		File f1 = new File("dir1/file1.txt");
		if (!f1.exists()) {
			try {
				f1.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		
		
	}

}
