package tw.brad.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Brad42 {

	public static void main(String[] args) {
		String mesg = "Hello, Brad\n";
		try {
			FileOutputStream fout = new FileOutputStream("dir1/file3.txt", true);
			fout.write(mesg.getBytes());
			fout.flush();
			fout.close();
			System.out.println("OK");
		}catch(FileNotFoundException e) {
			System.out.println("1:"+ e);
		}catch(IOException e){
			System.out.println("2:"+ e);
		}

	}

}
