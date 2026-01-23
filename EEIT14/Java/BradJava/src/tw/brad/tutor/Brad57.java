package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.Socket;

public class Brad57 {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket(InetAddress.getByName("10.0.101.93"), 7777);
			BufferedOutputStream bout = new BufferedOutputStream(socket.getOutputStream());
			
			BufferedInputStream bin = 
				new BufferedInputStream(new FileInputStream("dir1/brad.jpg"));
			byte[] buf = new byte[4*1024*1024];
			int len;
			while ( (len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			
			bin.close();
			bout.flush();
			bout.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}