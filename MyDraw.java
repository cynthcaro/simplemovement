import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class MyDraw extends JComponent{

	private BufferedImage image;
	private BufferedImage image2;
	private URL resource = getClass().getResource("run0.png");
	private URL backgroundresource = getClass().getResource("2D.jpg");
	
	public int x = 20;
	public int y = 20;

	public int state = 0;
	public MyDraw(){
		try{
			image2 = ImageIO.read(backgroundresource);
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void reloadImage(){
		state++;
		if(state == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run3.png");	
		}
		else if(state == 4){
			resource = getClass().getResource("run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run5.png");
			state = 0;
		}
		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void punchAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 13; ctr++){
					try {
						if(ctr==12){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("punch"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
	}

	public void kickAnimation(){
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 8; ctr++){
					try {
						if(ctr==7){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("kick"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread2.start();
	}

	public void knockdownAnimation(){
		Thread thread3 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 9; ctr++){
					try {
						if(ctr==8){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("knockdown"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread3.start();
	}

	public void standAnimation(){
		Thread thread4 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 8; ctr++){
					try {
						if(ctr==7){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("stand"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread4.start();
	}

	public void jumpAnimation(){
		Thread thread4 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 5 ; ctr++){
					try {
						if(ctr == 4){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("jump"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread4.start();
	}

	public void smrsltAnimation(){
		Thread thread5 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 4 ; ctr++){
					try {
						if(ctr == 3){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("smrslt"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread5.start();
	}

	public void dropattackAnimation(){
		Thread thread6 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 4 ; ctr++){
					try {
						if(ctr == 3){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("dropattack"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread6.start();
	}

	public void kick(){
		kickAnimation();
	}

	public void punch(){
		punchAnimation();
	}

	public void stand(){
		standAnimation();
	}

	public void knockdown(){
		knockdownAnimation();
	}

	public void jump(){
		jumpAnimation();
	}

	public void dropattack(){
		dropattackAnimation();
	}

	public void smrslt(){
		smrsltAnimation();
	}
	public void moveUp(){
		y = y - 5;
		reloadImage();
		repaint();
	}
	public void moveDown(){
		y = y + 5;
		reloadImage();
		repaint();
	}
	public void moveRight(){
		x = x + 5;
		reloadImage();
		repaint();
	}
	public void moveLeft(){
		x = x - 5;
		reloadImage();
		repaint();
	}
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.drawImage(image2, 0, 0, this);
		g.drawImage(image,x,y,this);
	}
}