import java.awt.*;
import javax.swing.*;

/**
 * Creates a recursive Sierpinski Triangle
 */
public class SierpinskiTriangle
{	
	public static void main(String[] args) throws InterruptedException 
	{
		JFrame win = new JFrame("Sierpinski Triangle");
		win.setSize(1000,700);
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = win.getContentPane();
		contentPane.setBackground(java.awt.Color.BLACK);
		
		Graphics g = contentPane.getGraphics();
		
		Thread.sleep(50);

		//drawTriangles method here


		Polygon triangleOutline = new Polygon();
		triangleOutline.addPoint(contentPane.getWidth()/2,0);
		triangleOutline.addPoint(contentPane.getWidth()/2-(int)Math.round(Math.tan(Math.toRadians(30))*contentPane.getHeight()),contentPane.getHeight()-1);
		triangleOutline.addPoint(contentPane.getWidth()/2+(int)Math.round(Math.tan(Math.toRadians(30))*contentPane.getHeight()),contentPane.getHeight()-1);
		
		g.drawPolygon(triangleOutline);
		
		
	}
	
	
	//drawTriangles
}