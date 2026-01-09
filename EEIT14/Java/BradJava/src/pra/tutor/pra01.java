package pra.tutor;


public class pra01 {

	public static void main(String[] args) {
		 int year =2300;
		 boolean isleap = true;
		 
		 if(year%400==0||(year%4==0&&year%100!=0)) {
			isleap=true; 
		 }else {
			isleap=false;
			 }
		 System.out.printf("%d年為%s年",year,isleap?"潤":"平");
    }
}
	


