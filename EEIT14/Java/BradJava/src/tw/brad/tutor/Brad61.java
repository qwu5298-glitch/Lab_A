package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Brad61 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://pdfmyurl.com/?url=" + "https://www.gamer.com.tw");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setConnectTimeout(10*1000);
			conn.setReadTimeout(15*1000);
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			byte[] data = bin.readAllBytes();
			
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("dir1/test.pdf"));
			bout.write(data);
			bout.flush();
			bout.close();
			System.out.println("OK");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}