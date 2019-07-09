import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Move extends JFrame {
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	/**bu uygulamada neden bmoyleyaptýn diyenler için 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int count=1;
	public int i=1;
	public void doAnimation(JProgressBar progressBar,JButton button){

		ActionListener updateProBar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
            	int val = progressBar.getValue(); 
            	int val2=150;
			if (val <= val2) {
              if (val >= val2) {
              //  timer.stop();  
                return;
              }
              progressBar.setValue(++val);
              
              if(progressBar.getX()>18){//bu 18 panelde invisible olduklarý nokta
            	  progressBar.setBounds(progressBar.getX()-i, 23, 9, 151);
            	  
              }
              else{//panelde kayboldukalrý zaman en saga ekliyorum tekrar ordan kayamaya devam ediyor
            	  progressBar.setBounds(88, 23, 9, 151);
            	  Random rand = new Random();
          	    	progressBar.setValue(rand.nextInt(100));
              }
                
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
          Timer timer = new Timer(50, updateProBar);
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Move frame = new Move();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public Move() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(90, 23, 134, 168);
		panel.add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-14, 23, 39, 151);
		panel.add(panel_1);
		
		JProgressBar progressBar = new JProgressBar(JProgressBar.VERTICAL);
		progressBar.setBounds(25, 23, 9, 151);
		panel.add(progressBar);
		progressBar.setValue(50);
		
		JProgressBar progressBar_1 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_1.setBounds(33, 23, 9, 151);
		panel.add(progressBar_1);
		progressBar_1.setValue(70);
		
		JProgressBar progressBar_2 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_2.setValue(40);
		progressBar_2.setBounds(41, 23, 9, 151);
		panel.add(progressBar_2);
		
		JProgressBar progressBar_3 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_3.setValue(60);
		progressBar_3.setBounds(49, 23, 9, 151);
		panel.add(progressBar_3);
		
		JProgressBar progressBar_4 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_4.setValue(10);
		progressBar_4.setBounds(57, 23, 9, 151);
		panel.add(progressBar_4);
		
		JProgressBar progressBar_5 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_5.setValue(80);
		progressBar_5.setBounds(65, 23, 9, 151);
		panel.add(progressBar_5);
		
		JProgressBar progressBar_6 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_6.setValue(50);
		progressBar_6.setBounds(73, 23, 9, 151);
		panel.add(progressBar_6);
		
		JProgressBar progressBar_7 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_7.setValue(60);
		progressBar_7.setBounds(81, 23, 9, 151);
		panel.add(progressBar_7);
		
		JProgressBar progressBar_8 = new JProgressBar(SwingConstants.VERTICAL);
		progressBar_8.setValue(50);
		progressBar_8.setBounds(89, 23, 9, 151);
		panel.add(progressBar_8);
		
		JButton btnNewButton = new JButton("MOVE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doAnimation(progressBar, btnNewButton);
				doAnimation(progressBar_1, btnNewButton);
				doAnimation(progressBar_2, btnNewButton);
				doAnimation(progressBar_3, btnNewButton);
				doAnimation(progressBar_4, btnNewButton);
				doAnimation(progressBar_5, btnNewButton);
				doAnimation(progressBar_6, btnNewButton);
				doAnimation(progressBar_7, btnNewButton);
				doAnimation(progressBar_8, btnNewButton);
			}
		});
		btnNewButton.setBounds(291, 23, 89, 23);
		panel.add(btnNewButton);
	}
}
