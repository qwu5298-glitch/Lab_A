package tw.brad.tutor;

import java.util.HashSet;
import java.util.Set;

public class Brad32 {

	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		names.add("Brad");
		names.add("Andy");
		names.add("Eric");
		System.out.println(names);
		for(String name : names) {
			System.out.println(name);
		}

	}

}
