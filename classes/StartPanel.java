
/**
 * The first panel the user sees. 
 * Provides instructions on how to use the program and what it does.
 *
 *Primarily responsible: mkilling
 *
 * @author jku, mkilling, tdeshong
 * @version 5-21-18
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class StartPanel extends JPanel
{
    private JLabel quote, quote1, quote2, quote3;
    String message, message1, steps, start;
    private JButton startButton;
    JPanel cards = new JPanel();
    JPanel startPanel = new JPanel();
    CardLayout cl = new CardLayout();
    ChooseMajorPanel choosemajorpanel = new ChooseMajorPanel();

    /**
     * Constructor for objects of class AboutPanel
     */
    public StartPanel()
    {        
        setBackground(new Color(176, 215, 255));
        
        //uses card layout to switch in between different panels 
        cards.setLayout(cl);
        
        cards.add(combineAllPanels(), "startpanel");
        cards.add(choosemajorpanel, "choosemajorpanel");

        add(cards);
        cl.show(cards, "startpanel"); //first panel to show up (Start Panel)
    }
    
    /**
     * Panel that shows the title message
     * Top most panel in the GUI
     */
    private JPanel makeNorthPanel()
    {
        JPanel north = new JPanel();
        message = "<html><div style='text-align: center;'>PLAN YOUR MAJOR!!!<br/></html>";
 
        quote = new JLabel(message);
        quote.setFont(new Font("Futura", Font.BOLD, 24));

        north.add(quote);
        north.setBackground(new Color(176, 215, 255));
        return north;
    }
    
    /**
     * Panel that shows the about information
     * In the center of the GUI
     */
    private JPanel makeMiddlePanel()
    {
      JPanel middle = new JPanel();
      
      steps = "<html><div style='text-align: center;'><br></br>Let's get started!<br/><br/>Three simple steps<br/>1. Choose your major.<br/>2. Choose your higher level elective courses.<br/>3. See your 4-year major track!<br/><br/>"
        + "Please press the Start button to begin.<br/></html>"; 
      
      quote2 = new JLabel(steps);   
      quote2.setFont(new Font("Futura", Font.PLAIN, 18));
      
      middle.add(quote2);
      middle.setBackground(new Color(176, 215, 255));
      return middle;
    }
      
    /**
     * Panel that shows the Start button
     * bottom most panel in the GUI
     */
    private JPanel makeButtonPanel()
    {
        JPanel button = new JPanel();
        startButton = new JButton ("START!");
        button.add(startButton);
        startButton.addActionListener (new ButtonListener() );
        
        button.setBackground(new Color(176, 215, 255));
        
        return button;
    }
    
    /**
     * Panel that combines the top, middle, and bottom panels into one
     */
    private JPanel combineAllPanels()
    {
        JPanel all = new JPanel();
        all.setLayout (new BoxLayout(all, BoxLayout.Y_AXIS)); 
        all.add(makeNorthPanel());
        all.add(makeMiddlePanel());
        all.add(makeButtonPanel());
        all.setBackground(new Color(176, 215, 255));
        return all;
    }

    /**
     * Represents the action listener for the button
     */
    public class ButtonListener implements ActionListener{
        /**
         * Changes from the Start Panel to the next panel when the button is clicked
         */
        public void actionPerformed(ActionEvent event){
            //catches the input that can not be converted into an integer
            try{
                cl.show(cards, "choosemajorpanel"); //shows next panel on the cardlayout 
            }catch (NumberFormatException e){
                System.out.println("error.");
            }
        }
    }
}
