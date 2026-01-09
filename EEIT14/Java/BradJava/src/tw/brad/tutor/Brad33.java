package tw.brad.tutor;


import java.util.Set;
import java.util.TreeSet;

public class Brad33 {

	public static void main(String[] args) {
		Set<Integer> lottery = new TreeSet<>();
		while(lottery.size()<6) {
			lottery.add((int)(Math.random()*49+1));
		}
		for (Integer i : lottery) {
			System.out.println(i);
		}

	}

}
