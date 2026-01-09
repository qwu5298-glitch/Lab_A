package tw.brad.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class MyDrawer extends JPanel {
	private List<LineV2> lines, recycle;
	private Color defaultColor;
	private float defaultWidth;
	
	
	public MyDrawer() {
		setBackground(Color.YELLOW);
		
		lines = new ArrayList<>();
		recycle = new ArrayList<>();
		defaultColor = Color.BLUE;
		defaultWidth = 4f;
		
		MyListener listener = new MyListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		
		for (LineV2 line : lines) {
			g2d.setColor(line.getColor());
			g2d.setStroke(new BasicStroke(line.getWidth()));
			for (int i = 1; i< line.getSize(); i++) {
				g2d.drawLine(
						line.getPointX(i-1), line.getPointY(i-1), 
						line.getPointX(i), line.getPointY(i));
			}
		}
		
	}
	
	private class MyListener extends MouseAdapter {
		
		@Override
		public void mousePressed(MouseEvent e) {
			LineV2 line = new LineV2(defaultColor, defaultWidth);
			line.addPoint(e.getX(), e.getY());
			lines.add(line);
			
			recycle.clear();
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			lines.getLast().addPoint(e.getX(), e.getY());
			repaint();
		}
	}
	
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size() > 0) {
			recycle.add(lines.removeLast());
			repaint();
		}
	}
	public void redo() {
		if (recycle.size() > 0) {
			lines.add(recycle.removeLast());
			repaint();
		}
	}
	
	
	public void changeColor(Color newColor) {
		defaultColor = newColor;
	}
	public Color getColor() {return defaultColor;}
	
	public void changeWidth(float width) {
		defaultWidth = width;
	}
}