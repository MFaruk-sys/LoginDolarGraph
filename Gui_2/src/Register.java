
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	int xx,xy;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame2 = new Register();
					
					frame2.setUndecorated(true);
					frame2.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;
	/**
	 * Create the frame.
	 */
	public Register() {
		
		conn=sqliteconnect.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 100, 308, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
	
		
		
		JLabel label = new JLabel("USERNAME");
		label.setBounds(5, 141, 114, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(5, 166, 283, 36);
		contentPane.add(textField);
		
		JLabel label_1 = new JLabel("EMAIL");
		label_1.setBounds(5, 215, 54, 14);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(5, 240, 283, 36);
		contentPane.add(textField_1);
		
		JLabel label_2 = new JLabel("PASSWORD");
		label_2.setBounds(5, 287, 96, 14);
		contentPane.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(5, 312, 283, 36);
		contentPane.add(passwordField);
		
		JLabel label_3 = new JLabel("REPEAT PASSWORD");
		label_3.setBounds(5, 358, 133, 14);
		contentPane.add(label_3);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(5, 376, 283, 36);
		contentPane.add(passwordField_1);
		
		Button button = new Button("Register & Sign In");
		button.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					String query = "insert into Users (Username,Mail,Password) values (?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					
					Home.userforlogged=textField.getText();
					
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, passwordField.getText());
				
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Saved");
					pst.close();
					Register.this.dispose();
					Thread.sleep(1000);
					Logged log = new Logged();
					log.setVisible(true);
					
					
					
					
				}
				catch(Exception a){
					a.printStackTrace();
				}
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(5, 423, 283, 36);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 302, 130);
		contentPane.add(lblNewLabel);
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Register.this.setLocation(x - xx, y - xy);  
			}
		});
		
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/images/bg.jpg")));
		
		Button button_1 = new Button("Register & Quit");
		button_1.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					String query = "insert into Users (Username,Mail,Password) values (?,?,?)";
					PreparedStatement pst = conn.prepareStatement(query);
					
					
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, passwordField.getText());
				
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Saved");
					pst.close();
					Register.this.dispose();
					
					
				}
				catch(Exception a){
					a.printStackTrace();
				}
				
			}
		});
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(241, 57, 83));
		button_1.setBounds(5, 471, 283, 36);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Quit");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register.this.dispose();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(241, 57, 83));
		button_2.setBounds(5, 518, 283, 36);
		contentPane.add(button_2);
	
		
	}
}
