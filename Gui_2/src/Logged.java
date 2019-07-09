import java.awt.Color;
import java.awt.EventQueue;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logged extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField surname;
	private JTextField phone;
	private JTextField mail;
	public JPanel controlLabel_1;
	public int count=0;
	int xx,xy;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logged frame = new Logged();
					frame.setUndecorated(true);
					frame.setVisible(true);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	Connection conn = null;
	private JTextField textField_1;
	private JTextField textField;
	/**
	 * Create the frame.
	 */
	public Logged() {
		conn=sqliteconnect.dbConnector();
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 706, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(106, 0, 584, 69);
		contentPane.add(panel_2);
		panel_2.setForeground(Color.BLACK);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setLocation(321, 11);
		lblNewLabel_2.setSize(56, 50);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(Logged.class.getResource("/images/black-envelope.png")));
		
		textField_1 = new JTextField();
		textField_1.setSize(156, 28);
		textField_1.setLocation(348, 22);
		panel_2.add(textField_1);
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setSize(56, 28);
		label.setLocation(75, 22);
		panel_2.add(label);
		label.setIcon(new ImageIcon(Logged.class.getResource("/images/round-account-button-with-user-inside.png")));
		
		textField = new JTextField();
		textField.setSize(156, 28);
		textField.setLocation(100, 22);
		panel_2.add(textField);
		textField.setEnabled(false);
		textField.setColumns(10);
		panel_2.setVisible(true);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 105, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		//pencereyi hareket ettirmek için
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            Logged.this.setLocation(x - xx, y - xy);  
			}
		});
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Account");
		lblNewLabel_1.setIcon(new ImageIcon(Logged.class.getResource("/images/user.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 26, 85, 35);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JButton btnGeneral = new JButton("Profile");
		btnGeneral.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(count<1){
					try{
						JOptionPane.showMessageDialog(null, Home.userforlogged);
						
						String query="select * from Users where Username= '"+Home.userforlogged+"'";//girilen kiþiye göre bilgileri çekme
						PreparedStatement pst = conn.prepareStatement(query);
						
						ResultSet rs = pst.executeQuery();
						
						while(rs.next()){
							name.setText(rs.getString("Username"));
							surname.setText(rs.getString("Surname"));
							mail.setText(rs.getString("Mail"));
							phone.setText(rs.getString("Phone"));
							textField_1.setText(rs.getString("Mail"));
							textField.setText(rs.getString("Username"));
						}
						
					}
					catch(Exception a){
						a.printStackTrace();
					}
					controlLabel_1.setVisible(true);
					count++;
				}
				else{
				try{
					String query="select * from Users where Username='"+name.getText()+"'"; //girilen kiþiye göre bilgileri çekme
					PreparedStatement pst = conn.prepareStatement(query);
					
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()){
						name.setText(rs.getString("Username"));
						surname.setText(rs.getString("Surname"));
						mail.setText(rs.getString("Mail"));
						phone.setText(rs.getString("Phone"));
						textField_1.setText(rs.getString("Mail"));
						textField.setText(rs.getString("Username"));
					
					}
				}
				catch(Exception a){
					a.printStackTrace();
				}
				controlLabel_1.setVisible(true);
				
				
			}
		}
		});
		btnGeneral.setFocusable(false);
		btnGeneral.setFocusTraversalKeysEnabled(false);
		btnGeneral.setFocusPainted(false);
		btnGeneral.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnGeneral.setForeground(Color.BLACK);
		btnGeneral.setBounds(0, 72, 105, 35);
		panel.add(btnGeneral);
		
		JButton btnNews = new JButton("News");
		btnNews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controlLabel_1.setVisible(false);
				
				ExchangeGraph E1 = new ExchangeGraph();
				E1.setVisible(true);
			}
		});
		
		btnNews.setForeground(Color.BLACK);
		btnNews.setFocusable(false);
		btnNews.setFocusTraversalKeysEnabled(false);
		btnNews.setFocusPainted(false);
		btnNews.setBounds(0, 118, 105, 35);
		panel.add(btnNews);
		
		JPanel panel_1 = new JPanel();
		controlLabel_1=panel_1;
		panel_1.setVisible(false);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(102, 0, 611, 437);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(118, 136, 92, 31);
		panel_1.add(lblNewLabel);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(118, 181, 92, 31);
		panel_1.add(lblSurname);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(118, 231, 92, 31);
		panel_1.add(lblMail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(118, 277, 92, 31);
		panel_1.add(lblPhone);
		
		name = new JTextField();
		name.setBounds(244, 141, 155, 20);
		panel_1.add(name);
		name.setColumns(10);
		
		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(244, 186, 155, 20);
		panel_1.add(surname);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(244, 282, 155, 20);
		panel_1.add(phone);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(244, 236, 155, 20);
		panel_1.add(mail);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					String query="Update Users set Username='"+name.getText()+"' where Surname='"+surname.getText()+"'";
					PreparedStatement pst = conn.prepareStatement(query);
									
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(Logged.class.getResource("/images/edit.png")));
		btnNewButton.setBounds(409, 140, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton button = new JButton("Edit");
		button.setFocusPainted(false);
		button.setFocusable(false);
		button.setForeground(Color.RED);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					String query="Update Users set Surname='"+surname.getText()+"' where Username='"+name.getText()+"'";
					PreparedStatement pst = conn.prepareStatement(query);
									
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
			}
		});
		button.setIcon(new ImageIcon(Logged.class.getResource("/images/edit.png")));
		button.setBounds(409, 185, 89, 23);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Edit");
		button_1.setFocusPainted(false);
		button_1.setFocusable(false);
		button_1.setForeground(Color.RED);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					String query="Update Users set Mail='"+mail.getText()+"' where Surname='"+surname.getText()+"'";
					PreparedStatement pst = conn.prepareStatement(query);
									
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		button_1.setIcon(new ImageIcon(Logged.class.getResource("/images/edit.png")));
		button_1.setBounds(409, 235, 89, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Edit");
		button_2.setFocusPainted(false);
		button_2.setFocusable(false);
		button_2.setForeground(Color.RED);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					String query="Update Users set Phone='"+phone.getText()+"' where Surname='"+surname.getText()+"'";
					PreparedStatement pst = conn.prepareStatement(query);
									
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
					
				}
			}
		});
		button_2.setIcon(new ImageIcon(Logged.class.getResource("/images/edit.png")));
		button_2.setBounds(409, 281, 89, 23);
		panel_1.add(button_2);
		
		
		
	}
}
