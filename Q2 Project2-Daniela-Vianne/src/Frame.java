import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
collide();
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
	
	public void collide() {
		if(b.getRect().intersects(sword.getRect())) {
			b.die();
		}
	    if(l.getRect().intersects(sword.getRect())) {
			l.die();
		}
		if(ca.getRect().intersects(sword.getRect())) {
			ca.die();
		}
		if(c.getRect().intersects(sword.getRect())) {
			c.die();
		}
		if(o.getRect().intersects(sword.getRect())) {
			o.die();
		}
		if(p.getRect().intersects(sword.getRect())) {
			p.die();
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

