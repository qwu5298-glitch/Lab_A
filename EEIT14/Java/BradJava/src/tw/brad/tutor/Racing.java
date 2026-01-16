package tw.brad.tutor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame{
	private JButton go;
	private JLabel[] lanes;
	private Car[] cars;
	private int rank;
	
	public Racing() {
		super("Racing Game");
		
		setLayout(new GridLayout(9, 1));
		go = new JButton("Go!"); add(go);
		lanes = new JLabel[8];
		for (int i=0; i<lanes.length; i++) {
			lanes[i] = new JLabel(String.format("%d.", i+1 ));
			add(lanes[i]);
		}
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				go();
			}
		});
	}
	
	private void go() {
		rank = 0;
		cars = new Car[8];
		for (int i=0; i<lanes.length; i++) {
			cars[i] = new Car(i);
			cars[i].start();
		}
	}
	
	private class Car extends Thread{
		private int lane;
		private StringBuffer sb;
		
		Car(int lane){
			this.lane = lane;
			sb = new StringBuffer((lane+1) + ". ");
		}
		@Override
		public void run() {
			for (int i=0; i<100; i++) {
				if (i == 99) {
//					sb.append("> " + ++rank);
					sb.append(">  WINNER");
					stopgame();
				}else {
					sb.append(">");
				}
				lanes[lane].setText(sb.toString());
				
				try {
					Thread.sleep(10 + new Random().nextInt(100));
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}
	
	private void stopgame() {
		for (Car car : cars) {
			car.interrupt();
		}
	}
	
	public static void main(String[] args) {
		new Racing();
	}

}