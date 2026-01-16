package tw.brad.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Brad53 {

	public static void main(String[] args) {
		byte[] buf = new byte[1024];
		try {
			DatagramSocket socket = new DatagramSocket(8888);
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			System.out.println("wait...");
			socket.receive(packet);
			socket.close();
			System.out.println("Receive OK");
			
			byte[] data = packet.getData();
			int len = packet.getLength();
			InetAddress urip = packet.getAddress();
			System.out.printf("%s : %s\n", urip.getHostAddress(),new String(data, 0, len));
			
		} catch (Exception e) {
			System.out.println(e);
		} 

	}

}
