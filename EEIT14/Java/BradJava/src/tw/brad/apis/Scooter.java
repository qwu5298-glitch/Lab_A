package tw.brad.apis;

public class Scooter extends Bike{
	private int gear;
	private String color;
	
	public Scooter() {
		super(1);
		System.out.println("Scooter()");
		color = "Yellow";
	}
	
	
	public Scooter(String color) {
		this.color = color;
	}
	
	public String getColor() {return color;}
	
	
	@Override
	public Scooter upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.8 * gear;
		return this;
	}
	
	//Overload
	public void upSpeed(int level) {
		speed = speed < 1 ? 1 : speed * 1.8 * level;
	}
	
//	public void upSpeedV2() {
//		speed = speed < 1 ? 1 : speed * 1.8 * gear;
//	}
	
	public void setGear(int gear) {
		if (gear >=0 && gear <= 4 ) {
			this.gear = gear;
		}
	}
	
	public int getGear() {
		return gear;
	}
	
	
}
