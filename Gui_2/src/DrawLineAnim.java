import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import java.util.Calendar;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

// !! Class names should begin with upper-case letter
public class DrawLineAnim extends JPanel {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private static final double DELKA = 150;
   private static final int SX = 250;
   private static final int SY = SX;
   private static final int DELAY = 1000;
   // private List<Line2D> lineList = new ArrayList<>();
   private Timer timer = new Timer(DELAY, new TaskPerformer());
   private Line2D line;

   public DrawLineAnim() {
      timer.start();
   }

   private void doDrawing() {
      int xSekunda, ySekunda;

      int SECOND = Calendar.getInstance().get(Calendar.SECOND) + 1;

      xSekunda = (int) ((int) SX + Math.round(Math
            .sin((6 * SECOND * Math.PI / 180)) * DELKA));
      ySekunda = (int) ((int) SY - Math.round(Math
            .cos((6 * SECOND * Math.PI / 180)) * DELKA));

      // Line2D line = new Line2D.Double(SX, SY, xSekunda, ySekunda);
      line = new Line2D.Double(SX, SY, xSekunda, ySekunda);
      // lineList.add(line);
      repaint();

      // info
     
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(2 * SX, 2 * SY);
   }

   @Override
   public void paintComponent(final Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g;
      g2d.setColor(Color.black);

      // to give smoother lines
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      // iterate through our list and draw lines it holds
      if (line != null) {
         g2d.draw(line);
      }

   }

   private class TaskPerformer implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         if (!isShowing() && timer != null && timer.isRunning()) {
            timer.stop();
         } else {
            doDrawing();
         }
      }
   }
   
   

   private static void createAndShowGui() {
	   DrawLineAnim mainPanel = new DrawLineAnim();

      JFrame frame = new JFrame("surface");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }
   
   
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}