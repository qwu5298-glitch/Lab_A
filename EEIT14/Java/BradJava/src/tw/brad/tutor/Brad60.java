package tw.brad.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Brad60 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://s.yimg.com/ny/api/res/1.2/ly_tvThZOtCCtvTGqaUCeg--/YXBwaWQ9aGlnaGxhbmRlcjt3PTk2MDtoPTcyMDtjZj13ZWJw/https://s.yimg.com/uu/api/res/1.2/pxUQ8uvpNMg7KWsQznRSPA--~B/aD0yMTM4O3c9Mjg1MDthcHBpZD15dGFjaHlvbg--/https://d29szjachogqwa.cloudfront.net/images/user-uploaded/3304A461-C9EA-4D1F-A509-A81E27EEB98E.jpg");
			URLConnection conn = url.openConnection();
			
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			byte[] data = bin.readAllBytes();
			
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("dir1/test.jpg"));
			bout.write(data);
			bout.flush();
			bout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}