import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;


import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Home extends JFrame {
	//this is the first class beginning of the project
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField email;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	public static String userforlogged;//login den sonra ki ekranda bilgileri almak için kimin girdiðini tutuyor
	
	int xx,xy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setUndecorated(true);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection =null;
	Logged log = new Logged();

	/**
	 * Create the frame.
	 */
	public Home() {
		connection =sqliteconnect.dbConnector();
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Company");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(129, 317, 84, 27);
		panel.add(lblNewLabel);
		
		JLabel lblY = new JLabel("");
		
		lblY.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		lblY.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Home.this.setLocation(x - xx, y - xy);  
			}
		});
		lblY.setBounds(-38, 0, 420, 275);
		lblY.setVerticalAlignment(SwingConstants.TOP);
		lblY.setIcon(new ImageIcon(Home.class.getResource("/images/bg.jpg")));
		panel.add(lblY);
		
		Button lblNewButton = new Button("Register");
		lblNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home.this.dispose();
				Register reg1 = new Register();
				reg1.setVisible(true);
			}
		});
		lblNewButton.setForeground(Color.WHITE);
		lblNewButton.setBackground(new Color(241, 57, 83));
		lblNewButton.setBounds(43, 366, 263, 36);
		panel.add(lblNewButton);
		
		Button btnNewButton = new Button("SignUp");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try{
					String query="select * from Users where username=? and password=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					userforlogged=username.getText();
					pst.setString(1,username.getText());
					pst.setString(2,passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					
					int count=0;
				
					while(rs.next()){
						count=count+1;
					}
					if(count==1){
						JOptionPane.showMessageDialog(null, "correct");
						Home.this.dispose();
						//mytimetask i çarðýyorum 10 saniyede bir dolarýn grafigini database e kaydediyor
						try {
							MyTimeTask.main(null);
						} catch (ParseException e1) {
							
							e1.printStackTrace();
						}
						
						Logged log = new Logged();
						log.setUndecorated(true);
						log.setVisible(true);
						
					}
					else if(count>1){
						JOptionPane.showMessageDialog(null, "duplicate");
					}
					else{
						JOptionPane.showMessageDialog(null, "wrong");
					}
					rs.close();
					pst.close();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(241, 57, 83));
		btnNewButton.setBounds(395, 363, 283, 36);
		contentPane.add(btnNewButton);
		
		username = new JTextField();
		username.setBounds(395, 83, 283, 36);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(395, 58, 114, 14);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(395, 132, 54, 14);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(395, 157, 283, 36);
		contentPane.add(email);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(395, 204, 96, 14);
		contentPane.add(lblPassword);
		
		JLabel lblRepeatPassword = new JLabel("REPEAT PASSWORD");
		lblRepeatPassword.setBounds(395, 275, 133, 14);
		contentPane.add(lblRepeatPassword);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			 public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode()==KeyEvent.VK_ENTER){
		        	try{
						String query="select * from Users where username=? and password=? ";
						PreparedStatement pst = connection.prepareStatement(query);
						userforlogged=username.getText();
						pst.setString(1,username.getText());
						pst.setString(2,passwordField.getText());
						
						ResultSet rs = pst.executeQuery();
						
						int count=0;
						
						while(rs.next()){
							count=count+1;
						}
						if(count==1){
							JOptionPane.showMessageDialog(null, "correct");
							Home.this.dispose();
							//mytimetask i çarðýyorum 10 saniyede bir dolarýn grafigini database e kaydediyor
							try {
								MyTimeTask.main(null);
							} catch (ParseException e1) {
								
								e1.printStackTrace();
							}
							
							Logged log = new Logged();
							log.setUndecorated(true);
							log.setVisible(true);
							
						}
						else if(count>1){
							JOptionPane.showMessageDialog(null, "duplicate");
						}
						else{
							JOptionPane.showMessageDialog(null, "wrong");
						}
						rs.close();
						pst.close();
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1);
						
					}
				}
			};
		        
		});
		passwordField.setBounds(395, 229, 283, 36);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(395, 293, 283, 36);
		contentPane.add(passwordField_1);
	}
}
