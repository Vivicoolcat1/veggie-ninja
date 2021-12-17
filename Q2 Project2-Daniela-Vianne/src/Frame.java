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
	
//Broccoli b= new Broccoli(100,200);
//Lettuce l =new Lettuce(200,300);
//Corn c = new Corn( 100, 100);
//Onion o = new Onion(280,100);
Knife sword= new Knife(250,490);
//Potato p= new Potato(400, 300);
//Carrot ca= new Carrot(300, 400);

Table t=new Table(-150,450);
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
 

public void paint(Graphics g) {
		super.paintComponent(g);
		bg.paint(g);
//b.paint(g);
//l.paint(g);
//c.paint(g);
//o.paint(g);
sword.paint(g);
//p.paint(g);
//ca.paint(g);
t.paint(g);
collide();

g.setColor(Color.white);
g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
g.drawString(score + "", 320, 90);


//if(bisDead==false && b.getY()>580) {
	//g.drawImage(img, 200, 100, 250,100, 250, 200, 200, 200, null);
//}



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
	   
//			broc[0] = new Broccoli(50, 0);
//			let[0] = new Lettuce(100, 0);
//			on[0] = new Onion(150, 0);
//			corn[0] = new Corn(200, 0);
//			po[0] = new Potato(250, 0);
//			car[0] = new Carrot(300, 0);
			
			for(int i = 0; i<broc.length; i++) {
					broc[i] = new Broccoli(r.nextInt(((650-10)+1)+10), -1*(i*500));
					let[i] = new Lettuce(r.nextInt(((650-10)+1)+10), -1*(i*500));
					on[i] = new Onion(r.nextInt(((650-10)+1)+10), -1*(i*500));
					corn[i] = new Corn(r.nextInt(((650-10)+1)+10), -1*(i*500));
					po[i] = new Potato(r.nextInt(((650-10)+1)+10), -1*(i*500));
					car[i] = new Carrot(r.nextInt(((650-10)+1)+10), -1*(i*500));
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
				score++;
			}
		} 
		
	    for(int i = 0; i<let.length; i++){
	    	if(let[i].getRect().intersects(sword.getRect())) {
	    		let[i].die();
	    		score++;
	    	}
	    }
	    
	    for(int i = 0; i<car.length; i++) {
	    	if(car[i].getRect().intersects(sword.getRect())) {
	    		car[i].die();
	    		score++;
	    	}
	    }
	    
	    for(int i = 0; i<corn.length; i++) {
	    	if(corn[i].getRect().intersects(sword.getRect())) {
	    		corn[i].die();
	    		score++;
	    	}
	    }
	    
	    for(int i = 0; i < on.length; i++) {
	    	if(on[i].getRect().intersects(sword.getRect())) {
	    		on[i].die();
	    		score++;
	    	}
	    }
	    
		for(int i = 0; i<po.length; i++) {
			if(po[i].getRect().intersects(sword.getRect())) {
				po[i].die();
				score++; 
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
