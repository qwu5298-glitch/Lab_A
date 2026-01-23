package pra.tutor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.im.InputContext;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pra.apis.Doors;
import tw.brad.apis.MyClock;
import tw.brad.apis.MyDrawer;
import tw.brad.tutor.MySign;

public class ThreeDoors extends JFrame{
	private Doors doors;
	private JTextField doorstotal,totalTrials;
	private MyClock myClock;
	
	
	
	
	public ThreeDoors() {
		super("Three doors");
		doors = new Doors();
	
		setLayout(new BorderLayout());
		add(doors,BorderLayout.CENTER);
	
		JPanel top = new JPanel(new FlowLayout());
		doorstotal = new JTextField("3",10);
		totalTrials = new JTextField("1",10);
		top.add(new JLabel("門的數量:"));
		top.add(doorstotal);
		top.add(new JLabel("選擇次數:"));
		top.add(totalTrials);
		add(top, BorderLayout.NORTH);
		
		
		setSize(500, 400);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new ThreeDoors();
	}

}
