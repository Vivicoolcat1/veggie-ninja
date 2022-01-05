import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Font;
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
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener, MouseMotionListener {
	int mouseY = MouseInfo.getPointerInfo().getLocation().y; 
	int mouseX = MouseInfo.getPointerInfo().getLocation().x;
	int score = 0; 
	Random r = new Random();
	//CREATE THE OBJECT (STEP 1)
	Background 	bg 	= new Background(0, -100);
	

Knife sword= new Knife(250,490);

Table ta=new Table(-150,450);
boolean bisDead=false;
boolean oisDead=false;
boolean cisDead=false;
boolean lisDead=false;
boolean pisDead=false;
boolean caisDead=false;
Broccoli[] broc = new Broccoli[10];
Lettuce[] let = new Lettuce[10];
Corn[] corn = new Corn[10];
Onion[] on = new Onion[10];
Potato[] po = new Potato[10];
Carrot[] car = new Carrot[10];
 Image img =getImage("/imgs/x.png");
 long startTime=System.currentTimeMillis();

public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);

sword.paint(g);

ta.paint(g);
collide();
g.setColor(Color.white);
g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
g.drawString("Score: " + score , 30, 70);

//timing
long elapsedTime = System.currentTimeMillis() - startTime;
long timeRemaining = 90000 - elapsedTime; 
g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
g.drawString("Time Remaining: " + timeRemaining/1000, 400, 70);



for(int i = 0; i<broc.length; i++) {
	broc[i].paint(g);
	let[i].paint(g);
	on[i].paint(g);
	corn[i].paint(g);
	po[i].paint(g);
	car[i].paint(g);
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



			
			for(int i = 0; i<broc.length; i++) {
					broc[i] = new Broccoli(r.nextInt(((650-10)+1)+10), -1*(i*500),true,false);
					let[i] = new Lettuce(r.nextInt(((650-10)+1)+10), -1*(i*500),true,false);
					on[i] = new Onion(r.nextInt(((650-10)+1)+10), -1*(i*500),true,false);
					corn[i] = new Corn(r.nextInt(((650-10)+1)+10), -1*(i*500),true,false);
					po[i] = new Potato(r.nextInt(((650-10)+1)+10), -1*(i*500),true,false);
					car[i] = new Carrot(r.nextInt(((650-10)+1)+10), -1*(i*500),true,false);
				}

				
		
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
		for(int i = 0; i<broc.length; i++) {
			if(broc[i].getRect().intersects(sword.getRect())) {
	    		broc[i].die();
	    		broc[i].setDead(false);
	    	if(broc[i].getAlive()==false && broc[i].getHit()==false)
	    		score ++;
	    	broc[i].setHit(true);
	    	}
		} 
		
	    for(int i = 0; i<let.length; i++){
	    	if(let[i].getRect().intersects(sword.getRect())) {
	    		let[i].die();
	    		let[i].setDead(false);
	    	if(let[i].getAlive()==false && let[i].getHit()==false)
	    		score ++;
	    	let[i].setHit(true);
	    	}
	    }
	    
	    for(int i = 0; i<car.length; i++) {
	    	if(car[i].getRect().intersects(sword.getRect())) {
	    		car[i].die();
	    		car[i].setDead(false);
	    	if(car[i].getAlive()==false && car[i].getHit()==false)
	    		score ++;
	    	car[i].setHit(true);
	    	}
	    }
	    
	    for(int i = 0; i<corn.length; i++) {
	    	if(corn[i].getRect().intersects(sword.getRect())) {
	    		corn[i].die();
	    		corn[i].setDead(false);
	    	if(corn[i].getAlive()==false && corn[i].getHit()==false)
	    		score ++;
	    	corn[i].setHit(true);
	    	}
	    	
	    }
	    
	    for(int i = 0; i < on.length; i++) {
	    	if(on[i].getRect().intersects(sword.getRect())) {
	    		on[i].die();
	    		on[i].setDead(false);
	    	if(on[i].getAlive()==false && on[i].getHit()==false)
	    		score ++;
	    	on[i].setHit(true);
	    	}
	    }
	    
		for(int i = 0; i<po.length; i++) {
			if(po[i].getRect().intersects(sword.getRect())) {
	    		po[i].die();
	    		po[i].setDead(false);
	    	if(po[i].getAlive()==false && po[i].getHit()==false)
	    		score ++;
	    	po[i].setHit(true);
	    	}
		}

		
	}
	
	
	
	
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
