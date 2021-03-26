package followthecard;

/**
 * @(#)Magic.java
 *
 *
 * @author 
 * @version 1.00 2015/12/18
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


public class FollowTheCard extends JPanel implements MouseListener{
    	
    public FollowTheCard(){
        addMouseListener(this);
    }
    
        Random r = new Random();
    	 
        int stage = 1; 
    	 
    	static double c1X = 45,c1Y = 75;
        static double c2X = 135,c2Y = 75;
        static double c3X = 225,c3Y = 75;
        static double c4X = 315,c4Y = 75;
        
        static double ic1X = c1X,ic1Y = 75;
        static double ic2X = c2X,ic2Y = 75;
        static double ic3X = c3X,ic3Y = 75;
        static double ic4X = c4X,ic4Y = 75;
    	
        static double c1Xa = 1,c1Ya = 1;
        static double c2Xa = -1,c2Ya = -1;
        static double c3Xa = 1,c3Ya = 1;
        static double c4Xa = -1,c4Ya = -1;
    	
    	static int randomizer = 2;
    	static int modifier = 4;
    	int cardWidth = 30;
    	int cardHeight = 45;
    	
    	static String answer = "";
    	
        static int a,b,c,d;
    	
    	static String pick = "Pick a card";
    	
    	static boolean start = false;
        static boolean end = false;
        static boolean middle = false;
    	String Card = "";
        
        
    	public String setCards(){
         
         a = 1 + r.nextInt(4);
         b = 1 + r.nextInt(4);
         while(b == a)b = 1 + r.nextInt(4);
         c = 1 + r.nextInt(4);
         while(c == b || c == a)c = 1 + r.nextInt(4);
         d = 1 + r.nextInt(4);
         while(d == c || d == b || d == a)d = 1 + r.nextInt(4);
         
         String code = a + "" + b + "" + c + "" + d;
         //System.out.println(code);
    	   return code;
    	}
        
    	public int findCode(String code, String card){
    	  int place = 0;
    	  int number = Integer.parseInt(card);
    	  if(code.substring(0,1).equals(String.valueOf(number)))place = 1;
        else if(code.substring(1,2).equals(String.valueOf(number)))place = 2;
        else if(code.substring(2,3).equals(String.valueOf(number)))place = 3;
        else if(code.substring(3,4).equals(String.valueOf(number)))place = 4;
    	  return place;
    	}
    	
    	public void moveCard1() {
		if (c1X + c1Xa < 0){
         c1Xa = r.nextInt(randomizer)+1;
		}
		if (c1X + c1Xa > getWidth() - 30){
         c1Xa = -1*(r.nextInt(randomizer)+1);
		}
		if (c1Y + c1Ya < 0){
         c1Ya = r.nextInt(randomizer)+1;
		}
		if (c1Y + c1Ya > getHeight() - 50){
         c1Ya = -1*(r.nextInt(randomizer)+1);
    	}
		c1X = c1X + c1Xa;
		c1Y = c1Y + c1Ya;
	}	
		
    	public void moveCard2() {
		if (c2X + c2Xa < 0){
         c2Xa = r.nextInt(randomizer)+1;
		}
		if (c2X + c2Xa > getWidth() - 30){
         c2Xa = -1*(r.nextInt(randomizer)+1);
		}
		if (c2Y + c2Ya < 0){
         c2Ya = r.nextInt(randomizer)+1;
		}
		if (c2Y + c2Ya > getHeight() - 50){
         c2Ya = -1*(r.nextInt(randomizer)+1);
    	}
		c2X = c2X + c2Xa;
		c2Y = c2Y + c2Ya;
	}	
		
	public void moveCard3() {
		if (c3X + c3Xa < 0){
         c3Xa = r.nextInt(randomizer)+1;
		}
		if (c3X + c3Xa > getWidth() - 30){
         c3Xa = -1*(r.nextInt(randomizer)+1);
		}
		if (c3Y + c3Ya < 0){
         c3Ya = r.nextInt(randomizer)+1;
		}
		if (c3Y + c3Ya > getHeight() - 50){
         c3Ya = -1*(r.nextInt(randomizer)+1);
    	}
		c3X = c3X + c3Xa;
		c3Y = c3Y + c3Ya;
	}	
		
	public void moveCard4() {
		if (c4X + c4Xa < 0){
         c4Xa = r.nextInt(randomizer)+1;
		}
		if (c4X + c4Xa > getWidth() - 30){
         c4Xa = -1*(r.nextInt(randomizer)+1);
		}
		if (c4Y + c4Ya < 0){
         c4Ya = r.nextInt(randomizer)+1;
		}
		if (c4Y + c4Ya > getHeight() - 50){
         c4Ya = -1*(r.nextInt(randomizer)+1);
    	}
		c4X = c4X + c4Xa;
		c4Y = c4Y + c4Ya;
	}
	
	public void moveCards(){
			moveCard1();
			moveCard2();
			moveCard3();
			moveCard4();
			randomizer = 1+r.nextInt(modifier);
		}
		
        public void lastMove() throws InterruptedException{
      double c1Xd,c1Yd,
             c2Xd,c2Yd,
             c3Xd,c3Yd,
             c4Xd,c4Yd;
          
      c1Xd = ic1X - c1X;
      c2Xd = ic2X - c2X;
      c3Xd = ic3X - c3X;
      c4Xd = ic4X - c4X;
      c1Yd = ic1Y - c1Y;
      c2Yd = ic2Y - c2Y;
      c3Yd = ic3Y - c3Y;
      c4Yd = ic4Y - c4Y;
		
	   c1Xd = c1Xd/100;
      c2Xd = c2Xd/100;
      c3Xd = c3Xd/100;
      c4Xd = c4Xd/100;
      c1Yd = c1Yd/100;
      c2Yd = c2Yd/100;
      c3Yd = c3Yd/100;
      c4Yd = c4Yd/100;
		
		for(int i = 0; i <= 100; i++){
		   c1X = c1X + c1Xd;
         c2X = c2X + c2Xd;
         c3X = c3X + c3Xd;
         c4X = c4X + c4Xd;
         c1Y = c1Y + c1Yd;
         c2Y = c2Y + c2Yd;
         c3Y = c3Y + c3Yd;
         c4Y = c4Y + c4Yd;
         repaint();
         Thread.sleep(5);
		}
		}
	
        
        public boolean contain(double x, double y){
            boolean h = true;
            if(x >= c1X && x <= c1X+cardWidth && y >= c1Y && y <= c1Y+cardHeight){
                Card = "1";
                //System.out.println(Card);
            }
            else if(x >= c2X && x <= c2X+cardWidth && y >= c2Y && y <= c2Y+cardHeight){
                Card = "2";
                //System.out.println(Card);
            }
            else if(x >= c3X && x <= c3X+cardWidth && y >= c3Y && y <= c3Y+cardHeight){
                Card = "3";
                //System.out.println(Card);
            }
            else if(x >= c4X && x <= c4X+cardWidth && y >= c4Y && y <= c4Y+cardHeight){
                Card = "4";
                //System.out.println(Card);
            }
            else{
                h = false;
            }
            return h;
        }
        
        int clickCount;
        @Override
        public void mouseClicked(MouseEvent e){
            if(middle == true && contain(e.getX(),e.getY())){
                end = true;
            }
            if(contain(e.getX(),e.getY()))start = true;
        }
        
    	@Override
	public void paint(Graphics g) {
                super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
				
		g2d.setBackground(Color.BLACK);
			
                
            g2d.setColor(Color.BLACK); 
            g2d.fillRect((int)c1X,(int)c1Y,cardWidth,cardHeight);
            g2d.setColor(Color.WHITE);
            g2d.drawRect((int)c1X,(int)c1Y,cardWidth,cardHeight);
            g2d.setColor(Color.BLACK);
            g2d.fillRect((int)c2X,(int)c2Y,cardWidth,cardHeight); 
            g2d.setColor(Color.WHITE); 
            g2d.drawRect((int)c2X,(int)c2Y,cardWidth,cardHeight);
            g2d.setColor(Color.BLACK);
            g2d.fillRect((int)c3X,(int)c3Y,cardWidth,cardHeight);
            g2d.setColor(Color.WHITE); 
            g2d.drawRect((int)c3X,(int)c3Y,cardWidth,cardHeight);
            g2d.setColor(Color.BLACK);
            g2d.fillRect((int)c4X,(int)c4Y,cardWidth,cardHeight);
            g2d.setColor(Color.WHITE); 
            g2d.drawRect((int)c4X,(int)c4Y,cardWidth,cardHeight);
				
	    if(stage == 1){		
            //g2d.setColor (Color.BLACK); 
            //g2d.drawString(pick,(int)(getWidth()/2.5),65);
                    
            g2d.setColor (Color.YELLOW);            
            g2d.drawString(String.valueOf(a),(int)c1X+15,(int)c1Y+15);
            g2d.drawString(String.valueOf(b),(int)c2X+15,(int)c2Y+15);
            g2d.drawString(String.valueOf(c),(int)c3X+15,(int)c3Y+15);
            g2d.drawString(String.valueOf(d),(int)c4X+15,(int)c4Y+15);
            
            Font f = new Font("Dialog", Font.PLAIN, 20);
            g2d.setFont(f);
            g2d.setColor(Color.red);
            g2d.drawString("Pick A Card", 150,200);
            
	    }
				else if(stage == 2){
            
				}
				else{
            
            
            g2d.setColor (Color.YELLOW);
            g2d.drawString(String.valueOf(a),(int)c1X+15,(int)c1Y+15);
            g2d.drawString(String.valueOf(b),(int)c2X+15,(int)c2Y+15);
            g2d.drawString(String.valueOf(c),(int)c3X+15,(int)c3Y+15);
            g2d.drawString(String.valueOf(d),(int)c4X+15,(int)c4Y+15);
            
            
            g2d.setColor(Color.BLACK);
            g2d.drawString(answer,getWidth()-7,getHeight()-4);
            
            Font f = new Font("Dialog", Font.PLAIN, 20);
            g2d.setFont(f);
            g2d.setColor(Color.red);
            g2d.drawString("Pick Your Card", 140,200);
            
				}
                
	}
        
        public static void main (String[] args) throws InterruptedException{
      
        FollowTheCard f = new FollowTheCard(); 
        Random r = new Random();
      
        Object[] difficulty = {"Easy", "Medium", "Hard","INSANE","IMPOSSIBLE!!!"};
        Object difficultyselect = JOptionPane.showInputDialog(null,"What difficulty would you like to play?",
        "Follow the Card", JOptionPane.PLAIN_MESSAGE, null, difficulty, difficulty[0]);
      
        String code = f.setCards();
        
        
        int pause = 5;
        int time = 500;
        if(difficultyselect.equals("Easy")){
             pause = 5;
             time = 1000;
             f.modifier = 5;
        }
        else if(difficultyselect.equals("Medium")){
            pause = 4;
            time = 1500;
            f.modifier = 10;
        }
        else if(difficultyselect.equals("Hard")){
            pause = 3;
            time = 2000;
            f.modifier = 12;
        }
        else if(difficultyselect.equals("INSANE")){
            pause = 2;
            time = 2500;
            f.modifier = 15;
        }
        else if(difficultyselect.equals("IMPOSSIBLE!!!")){
            pause = 1;
            time = 3000;
            f.modifier = 30;
        }
        
        JFrame frame = new JFrame("Follow That Card!!!");
        frame.add(f);
	frame.setSize(400,400);
        frame.setLocation(517,155);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
        while(!start){
            Thread.sleep(100);
        }
        String card = f.Card;
        
	f.stage = 2;
	int m = 0;
	boolean d = true;
		
	while(d == true){
	f.moveCards();
	f.repaint();
	Thread.sleep(pause);
        m++;
	if(m == time)d = false;
        }
        
        
        
        String code2 = f.setCards();
	f.stage = 3;
        int place = f.findCode(code,card);
        f.answer = code2.substring(Integer.parseInt(card)-1,Integer.parseInt(card));
        middle = true;
        f.repaint();
        Thread.sleep(100);
        f.answer = "";
        f.repaint();
        
	
        while(!end){
            Thread.sleep(100);
        }
        
        String choice = f.Card;
        
	if(card.equals(choice)){
        JOptionPane.showConfirmDialog(null, "You win!!!", "Good Game!",JOptionPane.PLAIN_MESSAGE);
	System.exit(0);
	}
        else{
        JOptionPane.showConfirmDialog(null, "You lose", "You suck",JOptionPane.OK_OPTION);
        System.out.println(place); 
        System.exit(0);
}
}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
