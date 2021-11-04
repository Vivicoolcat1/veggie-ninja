import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;
public class Broccoli {
 private int x;
 private int y;
 private Image img; 	
	private AffineTransform tx;
public Broccoli(int x, int y) {
	this.x=x;
	this.y=y;
	img = getImage("/imgs/broccoli.png"); //load the image for Tree
	tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 
}
public void paint(Graphics g) {
	//these are the 2 lines of code needed draw an image on the screen
	Graphics2D g2 = (Graphics2D) g;
	
	
	//call update to update the actualy picture location
	update();
	
	
	
	
	g2.drawImage(img, tx, null);
	g.drawRect(x, y, 85, 90);
	

}
/* update the picture variable location */
private void update() {
y++;
tx.setToTranslation(x,y);
tx.scale(.04,.04);	
	
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
public Rectangle getRect() {
	return new Rectangle(x, y, 85, 90);
}
public void die() {
	//switch image when knife and broccoli collide (rectangle method)
	// reset position to top 
}

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
