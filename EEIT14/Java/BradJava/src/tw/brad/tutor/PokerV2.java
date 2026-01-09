package tw.brad.tutor;

public class PokerV2 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		int[] poker = new int[52];
		boolean isDup;
		int temp;
		for(int i=0; i<poker.length; i++) {
			do {
				temp = (int)(Math.random()*52);
			
				// 檢查機制
				isDup = false;
				for(int j = 0; j<i ; j++) {
					if(temp == poker[j]) {
						isDup = true;
						break;
					}
				}
			}while(isDup);
			
			poker[i] = temp;
			System.out.println(poker[i]);
			
		}
		System.out.println("---");
		System.out.println(System.currentTimeMillis()-start);
			

	}

}
