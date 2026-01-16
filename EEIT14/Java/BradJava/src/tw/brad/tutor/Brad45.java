package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Brad45 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			FileInputStream fin = new FileInputStream("dir1/report.pdf");
			FileOutputStream fout = new FileOutputStream("dir2/brad2.pdf");
			
			int len; byte[] buf = new byte[4*1024];
			while ((len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
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
