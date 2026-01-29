package tw.brad.apis;

import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class BradUtils {
	public static String calc(String x, String y, String op) {
		try {
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			StringBuilder sb = new StringBuilder();
			switch(op) {
				case "1": sb.append(intX + intY); break;
				case "2": sb.append(intX - intY); break;
				case "3": sb.append(intX * intY); break;
				case "4": 
					sb.append(intX / intY).append(" ... ").append(intX % intY); 
					break;
			}
			return sb.toString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public static int createScore() {
		return new Random().nextInt(101);
	}
	
	public static SortedMap[] parseFood(String json) {
		JSONArray root = new JSONArray(json);
		TreeMap<String, String>[] foods = new TreeMap[root.length()]; 
		System.out.println(root.length());
		try {
			for (int i=0; i<root.length(); i++) {
				JSONObject food = root.getJSONObject(i);
				TreeMap<String, String> map = new TreeMap<>();
				map.put("name", food.getString("Name").length()==0?"沒有名":food.getString("Name"));
				map.put("tel", food.getString("Tel").length()==0?"xx":food.getString("Tel"));
				map.put("city", food.getString("City").length()==0?"xx":food.getString("City"));
				map.put("town", food.getString("Town").length()==0?"xx":food.getString("Town"));
				map.put("addr", food.getString("Address").length()==0?"xx":food.getString("Address"));
				map.put("feature", food.getString("FoodFeature").length()==0?"xx":food.getString("FoodFeature"));
				map.put("picurl", food.getString("PicURL").length()==0?"xx":food.getString("PicURL"));
				foods[i] = map;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return foods;
	}
	
	public static String order2JSON(SortedMap[] rows) {
		JSONObject root = new JSONObject();
		if (rows.length > 0) {
			root.put("orderDate", rows[0].getOrDefault("OrderDate", ""));
			root.put("employee", rows[0].getOrDefault("LastName", ""));
			root.put("customer", String.format("%s(%s)", 
					rows[0].getOrDefault("CompanyName", ""),
					rows[0].getOrDefault("ContactName", "")
					));
			
			double total = 0;
			JSONArray details = new JSONArray();
			for (SortedMap<String,String> row: rows) {
				JSONObject obj = new JSONObject();
				details.put(obj);
				
				obj.put("pid", row.getOrDefault("ProductID", ""));
				obj.put("pname", row.getOrDefault("ProductName", ""));
				obj.put("price", row.getOrDefault("UnitPrice", ""));
				obj.put("qty", row.getOrDefault("Quantity", ""));
				
				double price = 
					Double.parseDouble(obj.get("price").toString());
				int qty = 
					Integer.parseInt(obj.get("qty").toString());
				double sum = price * qty;
				obj.put("sum", sum);
				
				total += sum;
				
			}
			root.put("total", total);
			root.put("details", details);
		}
		
		return root.toString();
	}
	
	public static int calcPages(int total, int rpp) {
		return  (int)(Math.ceil(total * 1.0 / 10));
	}
	

}