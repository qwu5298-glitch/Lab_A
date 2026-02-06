package tw.brad.h2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
/*
 * ObjectMapper => Jackson core
 * Object -> JSON: Map, List, POJO => JSON
 * JSON -> Object: 對應
 * write / read
 * writeValueAsString
 * writeValue => JSON File
 * readValue
 * 
 * readTree
 * writerWithDefaultPrettyPrinter()
 */
public class Brad09 {

	public static void main(String[] args) {
		// Java Object -> JSON String
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String,Object> map = new HashMap<>();
		map.put("name", "Alice");
		map.put("age", 18);
		String json = "";
		try {
			 json = mapper.writeValueAsString(map);
		}catch(JacksonException je) {
			System.out.println(je);
		}		
		System.out.println(json);
		System.out.println("-------------");
		
		String json2 = """
					{
					  "date" : "1996-07-08 00:00:00",
					  "details" : [ {
					    "pname" : "Jack's New England Clam Chowder",
					    "price" : 7.7000,
					    "qty" : 10
					  }, {
					    "pname" : "Manjimup Dried Apples",
					    "price" : 42.4000,
					    "qty" : 35
					  }, {
					    "pname" : "Louisiana Fiery Hot Pepper Sauce",
					    "price" : 16.8000,
					    "qty" : 15
					  } ],
					  "employee" : "Peacock",
					  "customer" : "Hanari Carnes"
					}				
				""";
		
		Map<String,Object> result;
		result = mapper.readValue(json2, new TypeReference<Map<String,Object>>(){});
		System.out.println(result.get("date"));
		System.out.println(result.get("employee"));
		System.out.println(result.get("customer"));
		List<Map<String,Object>> details = (List<Map<String,Object>>)result.get("details");
		System.out.println(details.size());
		System.out.println(details.get(0).get("pname"));
		
		
	}

}