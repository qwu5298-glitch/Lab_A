package tw.brad.apis;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Line {
	private List<Point> points;
	private Color color;
	private float width;
	
	public Line(Color color, float width) {
		points = new ArrayList<Point>();
		this.color = color;
		this.width = width;
	}
	
	public void addPoint(int x, int y) {
		Point p = new Point(x, y);
		points.add(p);
	}
	
	public int getPointX(int i) {
		return points.get(i).getX();
	}
	public int getPointY(int i) {
		return points.get(i).getY();
	}
	public int getSize() {return points.size();}
	
	public Color getColor() {
		return color;
	}
	public float getWidth() {return width;}
}