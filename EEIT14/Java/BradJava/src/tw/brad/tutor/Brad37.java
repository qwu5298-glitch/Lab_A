package tw.brad.tutor;

public class Brad37 {

	public static void main(String[] args) {
		Bird b1 = new Bird();
		System.out.println(b1.leg);
		try {
			b1.setLeg(1);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("xxxxxxx");
		}
	}

}
class Bird {
	int leg;
	Bird(){leg = 2;}
	void setLeg(int leg) throws Exception{
		if(leg >= 0 && leg <= 2) {
			this.leg = leg;
		}else {
//			this.leg = 2;
			throw new Exception();
		}
	}
}