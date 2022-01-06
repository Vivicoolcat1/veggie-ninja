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
public class Broccoli {
 private int x;
 private int y;
 private Image img; 
 private Random r;
 private boolean isAlive;
 private boolean hasBeenHit;
	private int respX;
	private int startingY;
	private int yv;
	private AffineTransform tx;
public Broccoli(int x, int y,boolean isAlive, boolean hasBeenHit) {
	startingY=y;
	yv=0;
	this.x=x;
	this.y=y;
	this.isAlive=isAlive;
	this.hasBeenHit=hasBeenHit;
	img = getImage("/imgs/broccoli.png"); //load the image for Tree
	r=new Random();
	respX=r.nextInt(((550-10)+1)+10);
	tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 
}
	
public void paint(Graphics g) {
	//these are the 2 lines of code needed draw an image on the screen
	Graphics2D g2 = (Graphics2D) g;
	
	//call update to update the actualy picture location
	update();
	
	g2.drawImage(img, tx, null);
	

}
	
/* update the picture variable location */
private void update() {
y+=yv; //falling down 
tx.setToTranslation(x,y); //randomizing x value
tx.scale(.04,.04);	
respX=r.nextInt(((650-10)+1)+10);
}

public void changePicture(String newFileName) {
	img = getImage(newFileName);
	init(x, y);
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

//creates a rectangle around broccoli object for collision
public Rectangle getRect() {
	return new Rectangle(x, y, 85, 90);
}
	
//changing picture after collision 	
public void die() {
changePicture("/imgs/slicedBroccoli.png");

}

//chnage image and return object to starting position
public void respawn() {
	changePicture("/imgs/broccoli.png");
	y=startingY;
	x=respX;
}

//gravity and starting velocity  
public void start() {
	yv=6;
}
	
//getters and setters
public int getX() {
	return x;
}
public int getY() {
	return y;
}
public boolean getHit() {
	return hasBeenHit;
}
public boolean getAlive() {
	return isAlive;
}
public void setX(int val) {
	x=val;
}
public void setY(int val) {
	y=val;
}
public void setDead(boolean sat) {
	isAlive=sat;
}
public void setHit(boolean stat) {
	hasBeenHit=stat;
}
}
