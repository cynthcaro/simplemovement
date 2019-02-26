import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Random;

public class MyDraw extends JComponent{

	private BufferedImage image;
	private BufferedImage image2;
	private URL resource = getClass().getResource("run0.png");
	private URL backgroundresource = getClass().getResource("2D.jpg");
	
	public int x = -5;
	public int y = 215;
	public int height = 0;
	public int width = 0;

	public int state = 0;
	public Random randomizer;

 	public int NumberEnemy;
	Monsters[] monsters = new Monsters [20];

	public MyDraw(){
		randomizer = new Random();
		spawnEnemy();

		try{
			image2 = ImageIO.read(backgroundresource);
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}

		height = image.getHeight();
		width = image.getWidth();

		GameStart();
	}

	public void GameStart(){
		Thread gameThread = new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						for(int c = 0; c < monsters.length; c++){
							if(monsters[c]!=null){
								monsters[c].moveTo(x,y);
								repaint();
							}
						}
						Thread.sleep(100);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
			}
		});
		gameThread.start();
	}

	public void spawnEnemy(){
		if(NumberEnemy < 10){
			monsters[NumberEnemy] = new Monsters(randomizer.nextInt(500), randomizer.nextInt(500), this);
			NumberEnemy++;
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

				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 10;
						}
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

				for(int x=0; x<monsters.length; x++){
					if(monsters[x]!=null){
						if(monsters[x].contact){
							monsters[x].life = monsters[x].life - 10;
						}
					}
				}		
			}
		});
		thread2.start();
	}

	public void jumpAnimation(){
		Thread thread3 = new Thread(new Runnable(){
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
		thread3.start();
	}

	public void smrsltAnimation(){
		Thread thread4 = new Thread(new Runnable(){
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
				        Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread4.start();
	}

	public void dropattackAnimation(){
		Thread thread5 = new Thread(new Runnable(){
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
				        Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread5.start();
	}

	public void kick(){
		kickAnimation();
	}

	public void punch(){
		punchAnimation();
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
		if (y < 185){
			y = 185;
		}
		y = y - 5;
		reloadImage();
		repaint();
		checkCollision();
	}
	public void moveDown(){
		if (y > 210){
			y = 210;
		} 
		y = y + 5;
		reloadImage();
		repaint();
		checkCollision();
	}
	public void moveRight(){
		x = x + 5;
		reloadImage();
		repaint();
		checkCollision();
	}
	public void moveLeft(){
		if (x < 0){
			x = 0;
		}
		x = x - 5;
		reloadImage();
		repaint();
		checkCollision();
	}

	public void checkCollision(){
		int xChecker = x + width;
		int yChecker = y;

		for(int x=0; x<monsters.length; x++){
			boolean collideX = false;
			boolean collideY = false;

			if(monsters[x]!=null){
				monsters[x].contact = false;

				if(yChecker > monsters[x].yPos){
					if(yChecker-monsters[x].yPos < monsters[x].height){
						collideY = true;
					}
				}
				else{
					if(monsters[x].yPos - yChecker < monsters[x].height){
						collideY = true;
					}
				}

				if(xChecker > monsters[x].xPos){
					if(xChecker-monsters[x].xPos < monsters[x].width){
						collideX = true;
					}
				}
				else{
					if(monsters[x].xPos - xChecker < 5){
						collideX = true;
					}
				}
			}

			if(collideX && collideY){
				System.out.println("collision!");
				monsters[x].contact = true;
			}
		}
	}
	
	public void paintComponent (Graphics g){
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.drawImage(image2, 0, 0, this);
		g.drawImage(image,x,y,this);
		g.drawImage(image, x, y, this);

	for(int c = 0; c < monsters.length; c++){
			if(monsters[c]!=null){
				g.drawImage(monsters[c].image, monsters[c].xPos, monsters[c].yPos, this);
				g.setColor(Color.GREEN);
				g.fillRect(monsters[c].xPos+7, monsters[c].yPos, monsters[c].life, 2);
			}	
		}
	}
}