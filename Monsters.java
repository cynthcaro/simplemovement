import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.JComponent;

public class Monsters{

	public int xPos = 0;
	public int yPos = 50;
	public int width = 0;
	public int height = 0;
	public int life = 20;
	public boolean idle = true;
	public boolean alive = true;
	public boolean contact = false;

	public BufferedImage image;
	public URL resource = getClass().getResource("Monster/Sidle0.png");

	public Monsters(MyDraw comp){
		try{
		image = ImageIO.read(resource);
		}
		catch(IOException e){
		e.printStackTrace();
		}
		
		animate(comp);
	}

	public Monsters(int xPass, int yPass, MyDraw comp){
		xPos = xPass;
		yPos = yPass;

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}

		height = image.getHeight();
		width = image.getWidth();

		animate(comp);
	}

	public void animate(MyDraw compPass){
		Thread monThread = new Thread(new Runnable(){
			public void run(){
				while(idle){
					for(int ctr = 0; ctr < 5; ctr++){
						try {
							if(ctr==4){
								resource = getClass().getResource("Monster/Sidle0.png");
							}
							else{
								resource = getClass().getResource("Monster/Sidle"+ctr+".png");
							}
							
							try{
								image = ImageIO.read(resource);
							}
							catch(IOException e){
								e.printStackTrace();
							}
					        compPass.repaint();
					        Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					if(life<=0){
						die(compPass);
					}
				}
			}
		});
		monThread.start();
	}

	public void moveTo(int toX, int toY){
		if(xPos<toX){
			xPos++;
		}
		else if(xPos>toX){
			xPos--;
		}

		if(yPos<toY){
			yPos++;
		}
		else if(yPos>toY){
			yPos--;
		}
	}

	public void die(MyDraw compPass){
		idle = false;
		if(alive){
			Thread monThread = new Thread(new Runnable(){
				public void run(){
					for(int ctr = 0; ctr < 4; ctr++){
						try {					
							resource = getClass().getResource("Monster/Sdie"+ctr+".png");
							
							try{
								image = ImageIO.read(resource);
							}
							catch(IOException e){
								e.printStackTrace();
							}
					        compPass.repaint();
					        Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			});
			monThread.start();
		}
		alive = false;
	}
}



