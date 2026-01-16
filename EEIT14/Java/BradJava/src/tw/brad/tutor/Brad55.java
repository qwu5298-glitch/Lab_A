package tw.brad.tutor;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Brad55 {

	public static void main(String[] args) {
		try (Socket socket = new Socket(InetAddress.getByName("10.0.101.93"), 9999)){
			
			OutputStream out = socket.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
			writer.write("Hello, World");
			writer.flush();
			writer.close();
			
			System.out.println("TCP Send OK");
		} catch (Exception e) {
			System.out.println(e);
		}		
	}

}
