
/**
 * Contains a frame with 3 tabs
 * Tabs: About, Add School and Evaluate
 * 
 * Primarily responsible: mkilling
 *
 * @author jku & tdeshong & mkilling
 * @version 05-21-2018
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlanMajorGUI
{
    public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Plan Your Major!");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.setBackground(new Color(176, 215, 255));
      
      StartPanel panel = new StartPanel();
      
      frame.add(panel);
      frame.setLocationRelativeTo(null);
      frame.pack();
      frame.setSize(1250, 700);
      frame.setVisible(true);
   }
}
