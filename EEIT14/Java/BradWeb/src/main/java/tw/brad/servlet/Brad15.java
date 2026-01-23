package tw.brad.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

@WebServlet("/Brad15")
public class Brad15 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String source = "C:\\Users\\User\\git\\repository\\BradWeb\\src\\main\\webapp\\upload\\coffee.jpg";
		String target = "C:\\Users\\User\\git\\repository\\BradWeb\\src\\main\\webapp\\upload\\coffee2.jpg";

		BufferedImage img = ImageIO.read(new File(source));
		Graphics2D g2d = img.createGraphics();
		
		Font f1 = new Font(null, Font.BOLD, 72);
		
		AffineTransform transform = new AffineTransform();
		transform.rotate(Math.toRadians(-30));
		Font f2 = f1.deriveFont(transform);
		
		g2d.setFont(f2);
		g2d.setColor(Color.BLUE);
		g2d.drawString("版權沒有, 歡迎盜連", 600, 600);
		
		
		response.setContentType("image/jpeg");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
		
		ImageIO.write(img, "JPEG", new File(target));
		
	}

}