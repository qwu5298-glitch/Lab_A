package tw.brad.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private BufferedImage ballImg;
	private Timer timer;
	private int ballX, ballY, ballW, ballH, viewW, viewH;
	private int dx, dy;
	
	public GamePanel() {
		setBackground(Color.GREEN);
		try {
			ballImg = ImageIO.read(new File("dir3/ball3.png"));
			ballW = ballImg.getWidth();
			ballH = ballImg.getHeight();
		} catch (IOException e) {
			System.out.println(e);
		}
		
		dx = dy = 4;
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				moveBall();
			}
		}, 500, 60);
	}
	
	private void moveBall() {
		if (ballX < 0 || ballX + ballW > viewW) {
			dx *= -1;
		}
		if (ballY < 0 || ballY + ballH > viewH) {
			dy *= -1;
		}
		ballX += dx;
		ballY += dy;
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth(); viewH = getHeight();
		g.drawImage(ballImg, ballX, ballY, null);
		
	}
}