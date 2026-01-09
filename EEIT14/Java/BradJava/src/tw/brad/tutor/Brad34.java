package tw.brad.tutor;

import java.util.ArrayList;
import java.util.List;

public class Brad34 {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Brad");
		names.add(0, "Andy");
		names.add("Brad");
		names.add(2, "Tony");
		names.add("Mark");
		names.add("Eric");
		System.out.println(names.size());
		for(String name:names) {
			System.out.println(name);
		}
		System.out.println("---");
		System.out.println(names.get(0));
		System.out.println(names.get(3));

	}

}
