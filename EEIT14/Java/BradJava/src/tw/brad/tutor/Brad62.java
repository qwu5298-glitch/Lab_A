package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Brad62 {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx");
			URLConnection conn = url.openConnection();
			
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer sb = new StringBuffer();
			while ( (line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			System.out.println(sb.length());
			parseJSON(sb.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
		System.out.println(root.length());

		for (int i = 0 ; i <root.length() ; i++ ) {
			JSONObject row = root.getJSONObject(i);
			String name = row.getString("Name");
			String addr = row.getString("Address");
			String tel = row.getString("Tel");
			System.out.printf("%s : %s :%s\n", name, addr, tel);
		}
		
	}
	
	
	
}