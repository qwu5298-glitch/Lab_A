package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class Brad59 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.pchome.com.tw/");
			URLConnection conn = url.openConnection();
			
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer sb = new StringBuffer();
			while ( (line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			System.out.println(sb.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}