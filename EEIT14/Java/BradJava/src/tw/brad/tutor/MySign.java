package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tw.brad.apis.MyDrawer;

public class MySign extends JFrame{
	private MyDrawer myDrawer;
	private JButton clear, undo, redo, color;
	private JSlider width;
	
	public MySign() {
		super("MySign");
		
		myDrawer = new MyDrawer();
		setLayout(new BorderLayout());
		add(myDrawer, BorderLayout.CENTER);
		
		JPanel top = new JPanel(new FlowLayout());
		clear = new JButton("Clear");
		undo = new JButton("Undo");
		redo = new JButton("Redo");
		color = new JButton("Color");
		width = new JSlider(10, 200, 40);
		top.add(clear); top.add(undo);top.add(redo);
		top.add(color);top.add(width);
		add(top, BorderLayout.NORTH);
		
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	private void initEvent() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();
			}
		});
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();
			}
		});
		
		color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
		width.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(width.getValue()); 
				myDrawer.changeWidth(width.getValue()*0.1f);
			}
		});
	}
	
	private void changeColor() {
		Color color = JColorChooser.showDialog(null, "Change Color", myDrawer.getColor());
		if (color != null) {
			myDrawer.changeColor(color);
		}
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}