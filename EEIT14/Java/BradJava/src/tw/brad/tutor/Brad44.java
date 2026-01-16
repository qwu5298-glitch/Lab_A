package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Brad44 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileInputStream fin = new FileInputStream("dir1/report.pdf");
			FileOutputStream fout = new FileOutputStream("dir2/brad.pdf");
			
			int b;
			while ((b = fin.read()) != -1) {
				fout.write(b);
			}
			
			fout.flush();
			fout.close();
			fin.close();
			long time = System.currentTimeMillis() - start;
			System.out.println("OK:" + time);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}