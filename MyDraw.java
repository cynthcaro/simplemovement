import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
public class MyDraw extends JComponent{

	private BufferedImage image;
	private URL resource = getClass().getResource("run0.png");
	
	public int x = 20;
	public int y = 20;

	public MyDraw(){
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void moveUp(){
		y = y - 5;
		repaint();
	}
	public void moveDown(){
		y = y + 5;
		repaint();
	}
	public void moveRight(){
		x = x + 5;
		repaint();
	}
	public void moveLeft(){
		x = x - 5;
		repaint();
	}
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.drawImage(image,x,y,this);
	}
}