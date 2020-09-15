 import java.awt.*;
 import javax.swing.*;
 import java.awt.geom.*;
  
public class CartoonCharacter extends JApplet {
    public static void main(String s[]) {
    JFrame frame = new JFrame();
    frame.setTitle("2D Cartoon Character");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JApplet applet = new CartoonCharacter();
    applet.init();
    frame.getContentPane().add(applet);
    frame.pack();
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);  
   }
      
    public void init() {
    JPanel panel = new PathPanel();
    getContentPane().add(panel);
    } 
     class PathPanel extends JPanel {
    public PathPanel() {
    setPreferredSize(new Dimension(560, 480));
    } 
 
    public void paintComponent(Graphics g) {
    super.paintComponent(g);   
    Graphics2D g2 = (Graphics2D)g;
    Area body, legs,feet, head, ears,hair;
    
     //BODY
    GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD);	  
     path.moveTo(240,250);
     path.lineTo(315,265);
     path.quadTo(310,295,320,315);
     path.lineTo(240,315);
     path.lineTo(240,250);
     path.closePath();
     g2.setColor(new Color(54,65,28));
     g2.fill(path);
     body = new Area(path); 
     
     //LEGS
     GeneralPath path1 = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
     path1.moveTo(320,315);
     path1.quadTo(320,350,350,365); 
     path1.lineTo(310,365);
     path1.lineTo(300,340);
     path1.lineTo(300,330);
     path1.lineTo(270,365);
     path1.lineTo(255,365);
     path1.lineTo(240,315);
     path1.lineTo(320,315);
     path1.closePath();
     g2.setColor(Color.BLUE);
     g2.fill(path1);
     legs = new Area(path1);
     
     //FEET 
      Arc2D.Double leftfoot = new Arc2D.Double(305, 348, 60, 46, 0, 180, Arc2D.CHORD);//LEFT FOOT     
     feet=new Area(leftfoot);
     feet.add(legs);
     body.add(feet);
     g2.setColor(new Color(192,86,39));
     g2.fill(feet);
     g2.setColor(Color.BLACK);
     Stroke stroke1 = new BasicStroke(8f);
     g2.setStroke(stroke1);
     g2.draw(body);
     
     Arc2D.Double rightfoot = new Arc2D.Double(245, 348, 50, 46, 0, 180, Arc2D.CHORD); 
     g2.setColor(new Color(192,86,39));
     g2.fill(rightfoot);
     g2.setColor(Color.BLACK);
     g2.draw(rightfoot);
      
      // GROUND
     g2.fill(new Ellipse2D.Double(175, 370, 210,8));  
     
    //HEAD  
    int x1Points[] = {215, 240, 310, 350, 350, 215};
    int y1Points[] = {125, 250, 270, 240, 160, 125};    
    GeneralPath path2 = new GeneralPath(GeneralPath.WIND_EVEN_ODD,x1Points.length);   
    path2.moveTo(x1Points[0], y1Points[0]);

for (int index = 1; index < x1Points.length; index++) {
        path2.lineTo(x1Points[index], y1Points[index]);
}; 
    path2.closePath();     
    head = new Area(path2); 
    
    //EAR
   Shape ear = new Ellipse2D.Double(220, 200, 25, 40); 
    ears = new Area(ear);
    head.add(ears) ;	
    g2.setColor(new Color(218,148,55));
    g2.fill(head);      
      
    Shape earShadow = new Ellipse2D.Double(227, 210, 13, 16); //HIJA Te VESHI
    g2.setColor(new Color(251,172,67));
    g2.fill(earShadow);
    
     //HAIR       
   GeneralPath path3 = new GeneralPath(GeneralPath.WIND_EVEN_ODD);	  
     path3.moveTo(350,180);
     path3.lineTo(360,160);
     path3.lineTo(320,100);
     path3.quadTo(280,90,210,130);
     path3.lineTo(175,120);
     path3.lineTo(225,205);
     path3.quadTo(240,190,250,230);
     path3.lineTo(255,190);
     path3.lineTo(245,185);
     path3.lineTo(245,165);
     path3.lineTo(225,153);
     path3.quadTo(275,190,320,160);
     path3.lineTo(300,150);
     path3.lineTo(350,170);
     path3.lineTo(350,180);
     path3.closePath();
     g2.setColor(new Color(157,60,33));
     g2.fill(path3);
     
     //<HAIR SHADOW>
           g2.setColor(new Color(212,80,39));
       GeneralPath path5 = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
       path5.moveTo(350,170);
       path5.lineTo(360,160);
       path5.lineTo(320,100);
       path5.quadTo(260,90,220,130);
       path5.quadTo(260,110,350,170);
       path5.closePath();       
       path5.moveTo(230,140);
       path5.quadTo(285,130,305,160);
       path5.quadTo(275,165,255,150);
       path5.closePath();       
       path5.moveTo(210,130);
       path5.lineTo(175,120);
       path5.lineTo(205,145);
       path5.lineTo(220,150);
       path5.closePath();      
       path5.moveTo(250,230);
       path5.lineTo(255,190);
       path5.lineTo(247,187);
       path5.closePath();
       g2.fill(path5);   
       //</HAIR SHADOW>
       
     g2.setColor(Color.black);//stroke at hair
     g2.setStroke(new BasicStroke(4f));
     g2.draw(path3);     
     
     hair = new Area(path3); 
     hair.add(head);
     Stroke stroke = new BasicStroke(10f);
     g2.setStroke(stroke);
     g2.draw(hair); //stroke at head & hair
             
      g2.setColor(new Color(255,172,60)); //**FACE SHADOW
      g2.setStroke(new BasicStroke(9.0f,BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));        
      int[]x1={327,262,257,265,340,340};
      int y1[]={175,190,225,230,230,180};
      g2.drawPolygon(x1,y1,6); 
      g2.fillPolygon(x1,y1,6); 
      
      GeneralPath path4 = new GeneralPath(GeneralPath.WIND_EVEN_ODD);	
      g2.setColor(new Color(218,148,55));  
      path4.moveTo(305,193);
      path4.quadTo(285,190,290,215);
      path4.lineTo(330,215);
      path4.lineTo(335,193);
      path4.lineTo(305,193);
      path4.closePath();
     g2.fill(path4);
          
     g2.setColor( Color.BLACK); //**EYES 
      g2.fill(new Ellipse2D.Double(295, 200, 12, 22));
      g2.fill(new Ellipse2D.Double(315, 200, 12, 22));      
     
       g2.setColor(new Color(90,113,50));//**SHIRT SHADOW
       GeneralPath path6 = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
       path6.moveTo(258,278);
       path6.lineTo(240,315);
       path6.lineTo(312,308);
       path6.lineTo(310,285);
       path6.lineTo(305,290);
       path6.closePath();
       g2.fill(path6);
       
       g2.setColor(new Color(242,106,34));//**SHOES SHADOW
       Shape shoeShadow = new Ellipse2D.Double(270, 355, 12, 10);
       g2.fill(shoeShadow);
       Shape shoeShadow2 = new Ellipse2D.Double(332, 353, 18, 10);
       g2.fill(shoeShadow2);             
       
   //ARMS
   Shape arm = new RoundRectangle2D.Double(290,213, 18,70, 13,13);
   Shape shirt = new Rectangle2D.Double(290,203, 18,20);
   Shape shirt1 = new RoundRectangle2D.Double(290,195, 18,20, 11,11);
   Shape finger = new Ellipse2D.Double(295,260, 18,9);
      
   Area Arm, Finger,Shirt,area,armShadow,fingerShadow;
   Arm=new Area(arm);
   Finger=new Area(finger);
   area=new Area(shirt);
   Shirt=new Area(shirt1);
   Arm.add(Finger);
   Shirt.add(area);        
    
   AffineTransform tr = new AffineTransform();
   tr.rotate(Math.toRadians(13));
   shirt = tr.createTransformedShape(Shirt);
   Shape arm1 = tr.createTransformedShape(Arm);
   Shirt.add(Arm);
   Shape rightarm = tr.createTransformedShape(Shirt);
   
   g2.setStroke(new BasicStroke(12f));     
   g2.setColor(Color.BLACK);
   g2.draw(rightarm); 
   g2.setColor(new Color(251,172,67));
   g2.fill(arm1);
   g2.setColor(new Color(90,113,50));
   g2.fill(shirt);      
    
   AffineTransform tr1 = new AffineTransform();
   tr1.rotate(Math.toRadians(-65));
    arm1 = tr1.createTransformedShape(Arm);
   g2.translate(-2,458);
   
   g2.setColor(Color.BLACK);
   g2.draw(arm1);
   g2.setColor(new Color(251,172,67));
   g2.fill(arm1);  
    
   Shape armshadow = new RoundRectangle2D.Double(290,213, 8,70, 13,13);
   Shape fingershadow = new RoundRectangle2D.Double(295,266, 15,5,11,11);
   armShadow=new Area(armshadow);
   fingerShadow = new Area(fingershadow);
   armShadow.add(fingerShadow);
   armshadow=tr1.createTransformedShape(armShadow);
   g2.setColor(new Color(217,148,54));
   g2.fill(armshadow);     
      }      
   }
}