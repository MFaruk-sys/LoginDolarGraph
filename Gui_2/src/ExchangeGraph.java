import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
//import java.util.Timer;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.JTextField;




public class ExchangeGraph extends JFrame {
	Connection conn = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	GetInfoFromNet G2 = new GetInfoFromNet();
	Timer timer,timer1,timer2,timer3,timer4,timer5;
	
	
	public int x1,y1,x2,y2;
	private JTextField textField;
	private JTextField txtDolarGraphicsPer;
	public int val2=100;//1.dolar verisini tutmak için
	public int val3=100;//2.dolar verisini tutmak için
	public int val4=100;//3.dolar verisini tutmak için // tek tek yapmamýn sebebi olmuyor xd
	public int val5=100;
	public int val6=100;
	public int val7=100;
	
	//bu deðerleri zaten databaseden çekip içine atýacm 100 deðeri nemsiz.
	
	
	public void doAnimation(JProgressBar progressBar,JButton button){
		//DATABASE DE KÝ ÝLK DOLAR VERÝSÝNÝ ÇEKÝYORUM BURDA 
		int id=1;
		try{
			String query="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
			PreparedStatement pst = conn.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				 val2=Integer.parseInt(rs.getString("Dolar"));	
			}
			rs.close();
			pst.close();
		}
		catch(Exception a){
			a.printStackTrace();
		}
		ActionListener updateProBar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	
              int val = progressBar.getValue(); 
              //int val2 = Integer.parseInt(GetInfoFromNet.dolar3)*10+Integer.parseInt(GetInfoFromNet.dolar4);

              if (val <= val2) {
              if (val >= val2) {
              //  timer.stop();  
                return;
              }
              progressBar.setValue(++val);
              
              }
              else{
            	  if (val <= val2) {
                      //  timer.stop();  
                        return;
                      }
                      progressBar.setValue(--val);
                      
              }
         
            }
          };
          timer = new Timer(20, updateProBar);
          button.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                if (timer.isRunning()) {
                  timer.stop();
                  button.setText("Start");
                } else {
                  timer.start();
                  button.setText("Stop");
                }
              }
            });
	}
	
	//her seferinde tekrar etmemim sebebi timer sýkýntýsý yoksa animsayon olmuyor
	public void doAnimation_1(JProgressBar progressBar,JButton button){
		//DATABASE DE KÝ ÝKÝNCÝ DOLAR VERÝSÝNÝ ÇEKÝYORUM BURDA 
				int id=2;
				try{
					String query2="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
					PreparedStatement pst2 = conn.prepareStatement(query2);
					
					ResultSet rs2 = pst2.executeQuery();
					
					while(rs2.next()){
						 val3=Integer.parseInt(rs2.getString("Dolar"));
						
					}
					rs2.close();
					pst2.close();
				}
				catch(Exception a){
					a.printStackTrace();
				}
		ActionListener updateProBar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            			
            	int val = progressBar.getValue(); 
               
                
                if (val <= val3) {
                if (val >= val3) {
                //  timer.stop();  
                  return;
                }
                progressBar.setValue(++val);}
                else{
              	  if (val <= val3) {
                        //  timer.stop();  
                          return;
                        }
                        progressBar.setValue(--val);
                }
               
            }
          };
          timer1 = new Timer(20, updateProBar);
          button.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                if (timer1.isRunning()) {
                  timer1.stop();
                  button.setText("Start");
                } else {
                  timer1.start();
                  button.setText("Stop");
                }
              }
            });
	}
	public void doAnimation_2(JProgressBar progressBar,JButton button){
		//DATABASE DE KÝ ÜÇÜNCÜ DOLAR VERÝSÝNÝ ÇEKÝYORUM BURDA 
				int id=3;
				try{
					String query="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
					PreparedStatement pst = conn.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						 val4=Integer.parseInt(rs.getString("Dolar"));
						
					}
					rs.close();
					pst.close();
				}
				catch(Exception a){
					a.printStackTrace();
				}
		ActionListener updateProBar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            			
            	int val = progressBar.getValue(); 
                
                
                if (val <= val4) {
                if (val >= val4) {
                //  timer.stop();  
                  return;
                }
                progressBar.setValue(++val);//progressBar.setBounds(20+val, 11, 8, 158); istersek kaydýrýrýz
                }
                else{
              	  if (val <= val4) {
                        //  timer.stop();  
                          return;
                        }
                        progressBar.setValue(--val);
                }
               
            }
          };
          timer2 = new Timer(20, updateProBar);
          button.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
            	  
                if (timer2.isRunning()) {
                  timer2.stop();
                  button.setText("Start");
                } else {
                  timer2.start();
                  button.setText("Stop");
                }
              }
            });
	}
	
	
	public void doAnimation_3(JProgressBar progressBar,JButton button){
		//DATABASE DE KÝ ÝKÝNCÝ DOLAR VERÝSÝNÝ ÇEKÝYORUM BURDA 
				int id=4;
				try{
					String query2="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
					PreparedStatement pst2 = conn.prepareStatement(query2);
					
					ResultSet rs2 = pst2.executeQuery();
					
					while(rs2.next()){
						 val5=Integer.parseInt(rs2.getString("Dolar"));
						
					}
					rs2.close();
					pst2.close();
				}
				catch(Exception a){
					a.printStackTrace();
				}
		ActionListener updateProBar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            			
            	int val = progressBar.getValue(); 
               
                
                if (val <= val5) {
                if (val >= val5) {
                //  timer.stop();  
                  return;
                }
                progressBar.setValue(++val);}
                else{
              	  if (val <= val5) {
                        //  timer.stop();  
                          return;
                        }
                        progressBar.setValue(--val);
                }
               
            }
          };
          timer3 = new Timer(20, updateProBar);
          button.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                if (timer3.isRunning()) {
                  timer3.stop();
                  button.setText("Start");
                } else {
                  timer3.start();
                  button.setText("Stop");
                }
              }
            });
	}
	
	public void doAnimation_4(JProgressBar progressBar,JButton button){
		//DATABASE DE KÝ ÝKÝNCÝ DOLAR VERÝSÝNÝ ÇEKÝYORUM BURDA 
				int id=5;
				try{
					String query2="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
					PreparedStatement pst2 = conn.prepareStatement(query2);
					
					ResultSet rs2 = pst2.executeQuery();
					
					while(rs2.next()){
						 val6=Integer.parseInt(rs2.getString("Dolar"));
						
					}
					rs2.close();
					pst2.close();
				}
				catch(Exception a){
					a.printStackTrace();
				}
		ActionListener updateProBar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            			
            	int val = progressBar.getValue(); 
               
                
                if (val <= val6) {
                if (val >= val6) {
                //  timer.stop();  
                  return;
                }
                progressBar.setValue(++val);}
                else{
              	  if (val <= val6) {
                        //  timer.stop();  
                          return;
                        }
                        progressBar.setValue(--val);
                }
               
            }
          };
          timer4 = new Timer(20, updateProBar);
          button.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                if (timer4.isRunning()) {
                  timer4.stop();
                  button.setText("Start");
                } else {
                  timer4.start();
                  button.setText("Stop");
                }
              }
            });
	}
	
	public void doAnimation_5(JProgressBar progressBar,JButton button){
		//DATABASE DE KÝ ÝKÝNCÝ DOLAR VERÝSÝNÝ ÇEKÝYORUM BURDA 
				int id=6;
				try{
					String query2="select * from DolarInfo where ID= '"+id+"'";//girilen kiþiye göre bilgileri çekme
					PreparedStatement pst2 = conn.prepareStatement(query2);
					
					ResultSet rs2 = pst2.executeQuery();
					
					while(rs2.next()){
						 val7=Integer.parseInt(rs2.getString("Dolar"));
						
					}
					rs2.close();
					pst2.close();
				}
				catch(Exception a){
					a.printStackTrace();
				}
		ActionListener updateProBar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            			
            	int val = progressBar.getValue(); 
               
                
                if (val <= val7) {
                if (val >= val7) {
                //  timer.stop();  
                  return;
                }
                progressBar.setValue(++val);}
                else{
              	  if (val <= val7) {
                        //  timer.stop();  
                          return;
                        }
                        progressBar.setValue(--val);
                }
               
            }
          };
          timer5 = new Timer(20, updateProBar);
          button.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                if (timer5.isRunning()) {
                  timer5.stop();
                  button.setText("Start");
                } else {
                  timer5.start();
                  button.setText("Stop");
                }
              }
            });
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExchangeGraph frame = new ExchangeGraph();
					frame.setVisible(true);
					GetInfoFromNet.main(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExchangeGraph() {
		
		conn= sqliteconnect.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar(JProgressBar.VERTICAL);
		progressBar.setBounds(27, 11, 8, 158);
		progressBar.setValue(20);
		panel.add(progressBar);
		x1=progressBar.getX();
		y1=progressBar.getY();
		progressBar.setForeground(Color.GREEN);
		
		JProgressBar progressBar_1 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_1.setBounds(55, 11, 8, 158);
		panel.add(progressBar_1);
		progressBar_1.setValue(100);
		x2=progressBar_1.getX();
		y2=progressBar_1.getY();
		
		JProgressBar progressBar_2 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_2.setBounds(85, 11, 8, 158);
		panel.add(progressBar_2);
		progressBar_2.setValue(50);
		JProgressBar progressBar_3 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_3.setBounds(116, 11, 8, 158);
		panel.add(progressBar_3);
		progressBar_3.setValue(36);
		JProgressBar progressBar_4 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_4.setBounds(144, 11, 8, 158);
		panel.add(progressBar_4);
		progressBar_4.setValue(56);
		JProgressBar progressBar_5 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_5.setBounds(174, 11, 8, 158);
		panel.add(progressBar_5);
		progressBar_5.setValue(16);
		
		JButton btnNewButton = new JButton("update");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					//System.out.println(String.valueOf(GetInfoFromNet.dolar3)+String.valueOf(GetInfoFromNet.dolar4));//normalde 6 ve 0 string deðelri 60 olarak ekrana basýlýyor
					textField.setText(G2.getDolarInfo());
				doAnimation(progressBar, btnNewButton);
				
				doAnimation_1(progressBar_1, btnNewButton);
				
				doAnimation_2(progressBar_2, btnNewButton);
				doAnimation_3(progressBar_3, btnNewButton);
				doAnimation_4(progressBar_4, btnNewButton);
				doAnimation_5(progressBar_5, btnNewButton);
				
			}
		});
		btnNewButton.setBounds(263, 11, 89, 23);
		panel.add(btnNewButton);
		
		
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(266, 45, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		txtDolarGraphicsPer = new JTextField();
		txtDolarGraphicsPer.setHorizontalAlignment(SwingConstants.CENTER);
		txtDolarGraphicsPer.setEditable(false);
		txtDolarGraphicsPer.setText("Dolar Graphics per minutes");
		txtDolarGraphicsPer.setBounds(27, 180, 155, 20);
		panel.add(txtDolarGraphicsPer);
		txtDolarGraphicsPer.setColumns(10);
		
		JButton btnDrawLine = new JButton("Draw Line");
		btnDrawLine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DrawLine.main(null);

			}
		});
		btnDrawLine.setBounds(248, 76, 118, 23);
		panel.add(btnDrawLine);
		
		

		JButton btnDrawLine2 = new JButton("Move");
		btnDrawLine2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Move.main(null);
				//MoveDB.main(null);
			}
		});
		btnDrawLine2.setBounds(248, 100, 118, 23);
		panel.add(btnDrawLine2);

		
	}
}

