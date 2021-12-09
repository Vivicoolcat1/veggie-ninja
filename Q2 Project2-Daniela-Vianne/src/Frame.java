import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener, MouseMotionListener {
	int mouseY = MouseInfo.getPointerInfo().getLocation().y; 
	int mouseX = MouseInfo.getPointerInfo().getLocation().x;
	//CREATE THE OBJECT (STEP 1)
	Background 	bg 	= new Background(0, -100);
	
Broccoli b= new Broccoli(100,200);
Lettuce l =new Lettuce(200,300);
Corn c = new Corn( 100, 100);
Onion o = new Onion(280,100);
Knife sword= new Knife(250,490);
Potato p= new Potato(400, 300);
Carrot ca= new Carrot(300, 400);
Table t=new Table(-150,450);
boolean bisDead=false;
boolean oisDead=false;
boolean cisDead=false;
boolean lisDead=false;
boolean pisDead=false;
boolean caisDead=false;
 Image img =getImage("/imgs/x.png");

public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
b.paint(g);
l.paint(g);
c.paint(g);
o.paint(g);
sword.paint(g);
p.paint(g);
ca.paint(g);
t.paint(g);
collide();

if(bisDead==false && b.getY()>580) {
	g.drawImage(img, 200, 100, 250,100, 250, 200, 200, 200, null);
}
}
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {
		JFrame f = new JFrame("Vegtable Slice");
		f.setSize(new Dimension(700, 600));
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addMouseMotionListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
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
	public void collide() {
		if(b.getRect().intersects(sword.getRect())) {
			b.die();
			bisDead=true;
			if(lisDead==true) {
				l.respawn();
			}
		
		}
	    if(l.getRect().intersects(sword.getRect())) {
			l.die();
			lisDead=true;
			if(caisDead==true) {
				ca.respawn();
			}
		}
		if(ca.getRect().intersects(sword.getRect())) {
			ca.die();
			caisDead=true;
			if(cisDead==true) {
				c.respawn();
			}
		}
		if(c.getRect().intersects(sword.getRect())) {
			c.die();
			cisDead=true;
			if(oisDead==true) {
				o.respawn();
			}
		}
		if(o.getRect().intersects(sword.getRect())) {
			o.die();
			oisDead=true;
			if(pisDead==true) {
				p.respawn();
			}
		}
		if(p.getRect().intersects(sword.getRect())) {
			p.die();
			pisDead=true;
			if(bisDead==true) {
				b.respawn();
			}
		}
		
	}
	
	
	/*public void Start() {
		sword.setX(mouseX);
		sword.setY(mouseY); 
	}*/ 
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		 
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		 
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println(arg0.getKeyCode());

		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		sword.setPositioin(e.getX(), e.getY());
	}

}
