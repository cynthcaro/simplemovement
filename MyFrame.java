import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class MyFrame extends JFrame implements KeyListener{

	private MyDraw myDraw;

	public MyFrame(){
		this.myDraw = new MyDraw();
		addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_UP){
			myDraw.moveUp();
			System.out.println("pos: " + myDraw.x + ", " + myDraw.y);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			myDraw.moveDown();
			System.out.println("pos: " + myDraw.x + ", " + myDraw.y);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			myDraw.moveRight();
			System.out.println("pos: " + myDraw.x + ", " + myDraw.y);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			myDraw.moveLeft();
			System.out.println("pos: " + myDraw.x + ", " + myDraw.y);
		}
	}

	public void keyReleased(KeyEvent e){
		
	}

	public void keyTyped(KeyEvent e){
		
	}

	public static void main(String args []){
		MyFrame gameFrame = new MyFrame();
		MyDraw drawing = new MyDraw();
		gameFrame.setSize(400,300);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);
		gameFrame.getContentPane().add(gameFrame.myDraw);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("Hello!!");
	}
}