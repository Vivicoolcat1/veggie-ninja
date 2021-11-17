

	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.awt.geom.AffineTransform;
	import java.net.URL;
	public class Potato {
	 private int x;
	 private int y;
	 private Image img; 	
		private AffineTransform tx;
	public Potato(int x, int y) {
		this.x=x;
		this.y=y;
		img = getImage("/imgs/Potato.png"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y );
			init(x, y); 
	}
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		
		//call update to update the actualy picture location
		update();
		
		
		
		
		g2.drawImage(img, tx, null);
		
		g.drawRect(x+30,y+10,90,80);

	}
	/* update the picture variable location */
	private void update() {
y++;
		
tx.setToTranslation(x, y);
tx.scale(.2,.2);	
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.2,.2);
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
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);
	}
	public void die() {
		changePicture("/imgs/slicedPotato.png");
		}


public Rectangle getRect() {
	return new Rectangle(x+30,y+10,90,80);
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


