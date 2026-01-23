package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Brad58 {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7777);
			Socket socket = server.accept();
			
			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
			byte[] data = bin.readAllBytes();
			bin.close();
			server.close();
			
			InetAddress ip = socket.getInetAddress();
			//----------------------------------
			String filename = String.format("dir2/b%s.jpg", ip.getHostAddress().replace(':', '.'));
			BufferedOutputStream bout = 
				new BufferedOutputStream(
					new FileOutputStream(filename));
			bout.write(data);
			bout.flush();
			bout.close();
			System.out.println("Upload Success");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}