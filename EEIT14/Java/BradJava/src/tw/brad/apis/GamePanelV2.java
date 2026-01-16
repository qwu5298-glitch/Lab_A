package tw.brad.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanelV2 extends JPanel{
	private BufferedImage[] ballImgs = new BufferedImage[4];
	private String[] source = {"dir3/ball0.png","dir3/ball1.png",
						"dir3/ball2.png","dir3/ball3.png"};
	private int[] ballWs = new int[4];
	private int[] ballHs = new int[4];
	private int viewW, viewH;
	private ArrayList<BallTask> balls = new ArrayList<>();
	private Timer timer = new Timer();
	
	public GamePanelV2() {
		setBackground(Color.GREEN);
		try {
			for (int i=0; i<ballImgs.length; i++) {
				ballImgs[i] = ImageIO.read(new File(source[i]));
				ballWs[i] = ballImgs[i].getWidth();
				ballHs[i] = ballImgs[i].getHeight();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		timer.schedule(new RefreshView(), 0, 16);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BallTask ball = new BallTask(e.getX(), e.getY());
				balls.add(ball);
				timer.schedule(ball, 300, 30);
			}
		});
	}
	
	private class RefreshView extends TimerTask{
		@Override
		public void run() {
			repaint();
		}
	}
	
	private class BallTask extends TimerTask {
		int ballX, ballY;
		int dx, dy;
		int imgIndex;
		
		public BallTask(int ballX, int ballY) {
			imgIndex = new Random().nextInt(4);
			dx = (int)(Math.random()*17 - 8);
			dy = (int)(Math.random()*17 - 8);
			this.ballX = ballX - (int)(ballWs[imgIndex] / 2.0); 
			this.ballY = ballY - (int)(ballHs[imgIndex] / 2.0);
		}
		
		@Override
		public void run() {
			if (ballX < 0 || ballX + ballWs[imgIndex] > viewW) {
				dx *= -1;
			}
			if (ballY < 0 || ballY + ballHs[imgIndex] > viewH) {
				dy *= -1;
			}
			ballX += dx;
			ballY += dy;			
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		viewW = getWidth(); viewH = getHeight();
		
		for (BallTask ball : balls) {
			g.drawImage(ballImgs[ball.imgIndex], ball.ballX, ball.ballY, null);
		}
	}
	
	
	
	
}