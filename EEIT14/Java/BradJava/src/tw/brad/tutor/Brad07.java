package tw.brad.tutor;

public class Brad07 {

	public static void main(String[] args) {
		int year = 2000;
		boolean isLeap;
		
		if(year%4 == 0) {
			if(year%100==0) {
				if(year%400==0) {
					//29
					isLeap = true;
				}else {
					//28
					isLeap = false;
				}
			}else {
				//29
				isLeap = true;
			}
		}else {
			//28
			isLeap = false;
		}  
		
		if (year % 400 == 0 || (year % 4 == 0 && year % 100!=0)) {
			isLeap = true;
		}else {
			isLeap = false;
		}
		
		System.out.printf("%d年為%s年",year,isLeap?"潤":"平");
	}

}
