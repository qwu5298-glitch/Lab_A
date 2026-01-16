package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tw.brad.apis.MyClock;
import tw.brad.apis.MyDrawer;

public class MySign extends JFrame{
	private MyDrawer myDrawer;
	private JButton clear, undo, redo, color, saveObj, loadObj, saveJpeg;
	private JSlider width;
	private MyClock myClock;
	
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
		saveObj = new JButton("Save Lines");
		loadObj = new JButton("Load Lines");
		saveJpeg = new JButton("Save Jpeg");
		width = new JSlider(10, 200, 40);
		myClock = new MyClock();
		top.add(clear); top.add(undo);top.add(redo);
		top.add(color);
		top.add(saveObj); top.add(loadObj);
		top.add(saveJpeg); 
		top.add(width);
		top.add(myClock);
		add(top, BorderLayout.NORTH);
		
		setSize(1024, 480);
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
		saveObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveLines();
			}
		});
		loadObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadLines();
			}
		});
		saveJpeg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.saveJPEG();
			}
		});
		
	}
	
	private void changeColor() {
		Color color = JColorChooser.showDialog(null, "Change Color", myDrawer.getColor());
		if (color != null) {
			myDrawer.changeColor(color);
		}
	}
	
	private void saveLines() {
		JFileChooser jfc = new JFileChooser();
		if ( jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File saveFile = jfc.getSelectedFile();
			try {
				myDrawer.saveLines(saveFile);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR1");
			}
		}
	}
	
	private void loadLines() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File loadFile = jfc.getSelectedFile();
			try {
				myDrawer.loadLines(loadFile);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR2");
			}			
		}
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}