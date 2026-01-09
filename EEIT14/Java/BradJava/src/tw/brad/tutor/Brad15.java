package tw.brad.tutor;

public class Brad15 {

	public static void main(String[] args) {
		int a;
		int[] a1;
		int[][] a2 = new int[2][3]; //2 x 3
		System.out.println(a2);
		System.out.println(a2.length);
		System.out.println(a2[0]);
		System.out.println(a2[0].length);
		System.out.println("-----");
		
		int[][] b = new int[3][];
		System.out.println(b.length);
		b[0] = new int[2];
		b[1] = new int[3];
		b[2] = new int[4];
		System.out.println("-----");
		for(int[] v : b) {
			for(int vv : v) {
				System.out.print(vv + " ");
			}
			System.out.println();
		}

	}

}
