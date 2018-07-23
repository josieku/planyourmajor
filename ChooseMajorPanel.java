
/**
 * The second panel where the user selects their major from a drop down menu. 
 *
 *Primarily responsible: tdeshong
 *
 * @author jku, mkilling, tdeshong
 * @version 5-21-18
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ChooseMajorPanel extends JPanel
{
    private JLabel quote;
    private String message;
    private String[] majors;
    private JButton nextButton = new JButton ("NEXT");
    private JComboBox majorsList;
    JPanel cards = new JPanel();
    CardLayout cl = new CardLayout();
    private String majorChosen;

    /**
     * Constructor for objects of class AboutPanel
     */
    public ChooseMajorPanel() 
    {      
      CSElectivesPanel CSPanel = new CSElectivesPanel();
      PhysicsElectivesPanel physPanel = new PhysicsElectivesPanel();
      setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
    
      cards.setLayout(cl);
      //uses card layout to switch in between different panels 
      cards.add(combineAllPanels(), "2"); //current panel
      cards.add(CSPanel, "cspanel"); // next panel
      cards.add(physPanel, "physpanel");
      add(cards);
      cl.show(cards, "2");// shows current panel  
    }
    
    /**
     * Panel that shows the title message
     * Top most panel in the GUI
     */
    private JPanel makeNorthPanel()
    {
        JPanel north = new JPanel();
        message = "<html><div style='text-align: center;'>1. Choose a major out of these subjects:<br/></html>";
        
        quote = new JLabel(message);
        quote.setFont(new Font("Futura", Font.BOLD, 18));
        north.add(quote);
        north.setBackground(new Color(176, 215, 255));
        return north;
    }
    
    /**
     * Panel that shows the combo box
     */
    private JPanel makeCBPanel()
    {
      JPanel cb = new JPanel();
      String majors[] = {"Computer Science", "Physics"} ;
      
      majorsList = new JComboBox(majors);
      majorsList.setSelectedIndex(1);
      majorsList.addActionListener(new ComboListener() );
      
      cb.add(majorsList);
      cb.setBackground(new Color(176, 215, 255));
      return cb;
    }
    
     /**
     * Panel that shows the Next button
     * bottom most panel in the GUI
     */
    private JPanel makeButtonsPanel()
    {
      JPanel buttons = new JPanel();
      ButtonListener b1 = new ButtonListener();
      
      nextButton.addActionListener(b1);
      
      buttons.add(nextButton);
      buttons.setBackground(new Color(176, 215, 255));
      return buttons;
    }
      
    /**
     * Panel that combines all of the panels into one
     */
    private JPanel combineAllPanels()
    {
        JPanel all = new JPanel();
        all.setLayout (new BoxLayout(all, BoxLayout.Y_AXIS));
        all.add(makeNorthPanel());
        all.add(makeCBPanel());
        all.add(makeButtonsPanel());
        all.setBackground(new Color(176, 215, 255));
        return all;
    }

    /**
     * Represents the action listener for the button
     */
    public class ComboListener implements ActionListener{
        /**
         * assigns majorChosen String to the major that the user selected
         */
        public void actionPerformed(ActionEvent event){
             JComboBox cb = (JComboBox)event.getSource();
             majorChosen = (String)cb.getSelectedItem();
             //System.out.println("MAJORCHOSEN: " + majorChosen); TESTING
             majorChosen = majors[majorsList.getSelectedIndex()];
        }
    }
    
    public class ButtonListener implements ActionListener{
        /**
         * Changes from the current Panel to the next panel when the button is clicked 
         * depending on which major is chosen by the user
         */
        public void actionPerformed(ActionEvent event){
            //catches the input that can not be converted into an integer
            try{
                  //go to cs electives panel
                  if (event.getSource() == nextButton && majorChosen.equals("Computer Science")){
                     cl.show(cards, "cspanel");
                    }
                  //go to physics electives panel
                  if (event.getSource() == nextButton && majorChosen.equals("Physics")){
                      cl.show(cards, "physpanel");
                    }
            }catch (NumberFormatException e){
                System.out.println("error.");
            }
        }
    }
}
