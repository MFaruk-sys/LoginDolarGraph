import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DrawLine extends JComponent {
	static int x1;//bu deðerler aslýnda y deðerleri ama baþta ynlýþ yaptým düzeltmedim
	static int x2;
	static int x3;
	static int x4;
	static int x5;
	static int x6;
	static int x7;
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
    public void paint(Graphics g)  {
		getDolarGraph(1);
		getDolarGraph2(2);
		getDolarGraph3(3);
		getDolarGraph4(4);
		getDolarGraph5(5);
		getDolarGraph6(6);
		getDolarGraph7(7);
        // Draw a simple line using the Graphics2D draw() method.
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(Color.RED);
        g2.draw(new Line2D.Double(100,150-x1, 130, 150-x2));//150 çýkarmmamýn sebebi grafigin düzgün olmasý için yoksa ters çýkýyor grafik
        
        g2.setColor(Color.GREEN);
        g2.draw(new Line2D.Double(130,150- x2, 160, 150-x3));
       
        g2.setColor(Color.BLUE);
        g2.draw(new Line2D.Double(160, 150-x3, 190, 150-x4));
        
        g2.setColor(Color.RED);
        g2.draw(new Line2D.Double(190, 150-x4, 210,150- x5));
        
        g2.setColor(Color.GREEN);
        g2.draw(new Line2D.Double(210, 150-x5, 240,150- x6));
       
        g2.setColor(Color.BLUE);
        g2.draw(new Line2D.Double(240, 150-x6, 270, 150-x7));
        
        g2.setStroke(new BasicStroke(3f));
        g2.setColor(Color.BLACK);
        g2.draw(new Line2D.Double(100,150, 270, 150));
        g2.setColor(Color.BLACK);
        g2.draw(new Line2D.Double(100,150, 100, 50));
        
        g2.setStroke(new BasicStroke(1f));
        g2.setColor(Color.GRAY);
        g2.draw(new Line2D.Double(130,150, 130, 150-x2));
        g2.setColor(Color.GRAY);
        g2.draw(new Line2D.Double(160,150,  160, 150-x3));
        g2.setColor(Color.GRAY);
        g2.draw(new Line2D.Double(190,150,  190, 150-x4));
        g2.setColor(Color.GRAY);
        g2.draw(new Line2D.Double(210,150,  210,150- x5));
        g2.setColor(Color.GRAY);
        g2.draw(new Line2D.Double(240,150,  240,150- x6));
        g2.setColor(Color.GRAY);
        g2.draw(new Line2D.Double(270,150,  270, 150-x7));
        
    }
	static Connection conn2 = null;
	
	void getDolarGraph(int id){
		 
		
		 try{
			
				String query="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
				PreparedStatement pst = conn2.prepareStatement(query);
				
				ResultSet rs = pst.executeQuery();

				while(rs.next()){
					 x1=Integer.parseInt(rs.getString("Dolar"));	
				}
				
				rs.close();
				pst.close();
			}
			catch(Exception a){
				a.printStackTrace();
			}
	}

	void getDolarGraph2(int id){
		
		 try{
				String query="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
				PreparedStatement pst = conn2.prepareStatement(query);
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
					 x2=Integer.parseInt(rs.getString("Dolar"));	
				}
				rs.close();
				pst.close();
			}
			catch(Exception a){
				a.printStackTrace();
			}
	}
	void getDolarGraph3(int id){
		 
		
		 try{
			 
				String query="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
				PreparedStatement pst = conn2.prepareStatement(query);
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
					 x3=Integer.parseInt(rs.getString("Dolar"));	
				}
				rs.close();
				pst.close();
			}
			catch(Exception a){
				a.printStackTrace();
			}
	}
	void getDolarGraph4(int id){
		 
		
		 try{
			
				String query="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
				PreparedStatement pst = conn2.prepareStatement(query);
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
					 x4=Integer.parseInt(rs.getString("Dolar"));	
				}
				rs.close();
				pst.close();
			}
			catch(Exception a){
				a.printStackTrace();
			}
	}
	void getDolarGraph5(int id){
		 
		
		 try{
			
				String query="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
				PreparedStatement pst = conn2.prepareStatement(query);
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
					 x5=Integer.parseInt(rs.getString("Dolar"));	
				}
				rs.close();
				pst.close();
			}
			catch(Exception a){
				a.printStackTrace();
			}
	}
	void getDolarGraph6(int id){
		 
		
		 try{
			
				String query="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
				PreparedStatement pst = conn2.prepareStatement(query);
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
					 x6=Integer.parseInt(rs.getString("Dolar"));	
				}
				rs.close();
				pst.close();
			}
			catch(Exception a){
				a.printStackTrace();
			}
	}
	void getDolarGraph7(int id){
		 
		
		 try{
			
				String query="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
				PreparedStatement pst = conn2.prepareStatement(query);
				
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
					 x7=Integer.parseInt(rs.getString("Dolar"));	
				}
				rs.close();
				pst.close();
			}
			catch(Exception a){
				a.printStackTrace();
			}
	}
    public static void main(String[] args) {
    	conn2=sqliteconnect.dbConnector();
        JFrame frame2 = new JFrame("Draw Line");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.getContentPane().add(new DrawLine());
        frame2.pack();
        frame2.setSize(new Dimension(420, 220));
        frame2.setVisible(true);
        frame2.setLayout(null);
        
       
    }

    
    }