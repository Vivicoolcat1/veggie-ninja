
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.geom.AffineTransform;
	import java.net.URL;
import java.util.Random;
	public class Corn {
	 private int x;
	 private int y;
	 private Image img; 
	 private Random r;
		private int respX;
	 
		private AffineTransform tx;
	public Corn(int x, int y) {
		this.x=x;
		this.y=y;
		img = getImage("/imgs/Corn.png");//load the image for Tree
		r=new Random();
		
		tx = AffineTransform.getTranslateInstance(x, y );
			init(x, y); 
	}
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actualy picture location
		update();
		
		
		
		
		g2.drawImage(img, tx, null);
		g.drawRect(x,y,120,100);
		

	}
	/* update the picture variable location */
	private void update() {
		respX=r.nextInt(((650-10)+1)+10); //randomizing x value 
		y+=3; //falling down 
		
		tx.setToTranslation(x, y);
		tx.scale(.04,.04);
	}
public Rectangle getRect() {
	return new Rectangle(x,y,120,100);
}

public void changePicture(String newFileName) {
	img = getImage(newFileName);
	init(x, y);
}

//changing picture after collision 
public void die() {
	changePicture("/imgs/cutCorn.png");
	}
public void respawn() {
	changePicture("/imgs/Corn.png");
	y=-100;
	x=respX;
}
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.04,.04);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}


//getters and setters 
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int val) {
		x=val;
	}
	public void setY(int val) {
		y=val;
	}
	}


