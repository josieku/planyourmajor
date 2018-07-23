
/**
 * Adds selected Physics electives that the user chooses into the Physics Major graph
 *
 *Primarily responsible: tdeshong
 *
 * @author jku, mkilling, tdeshong
 * @version 5-21-18
 */

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PhysicsElectivesPanel extends JPanel
{
    private JLabel quote;
    private String message;
    private JCheckBox PHYS220, PHYS234, PHYS311, PHYS320; 
    private LinkedList<Course> electivestoAdd;

    private JButton nextButton = new JButton ("NEXT");
    JPanel cards = new JPanel();
    JPanel currentPanel = new JPanel();

    CardLayout cl = new CardLayout();
    private Major finalgraph;
    /**
     * Constructor for objects of class PhysicsElectivesPanel
     */
    public PhysicsElectivesPanel()
    {
        finalgraph = new Major("PHYS");
        FinalPanel finalPanel = new FinalPanel(finalgraph);
        setBackground(new Color(176, 215, 255));

        //uses card layout to switch in between different panels 
        cards.setLayout(cl);
        cards.add(combineAllPanels(), "currentpanel"); //start panel
        cards.add(finalPanel, "finalpanel"); // final panel
        add(cards);
        cl.show(cards, "currentpanel");// shows current panel  
    }

    /**
     * Panel that shows the title message
     * Top most panel in the GUI
     */
    private JPanel makeTitle(){
        JPanel title = new JPanel();

        message = "<html><div style='text-align: center;'>2. Choose your higher level courses:<br><br/></html>";

        quote = new JLabel(message);
        quote.setFont(new Font("Futura", Font.BOLD, 24));

        title.setBackground(new Color(176, 215, 255));
        title.add(quote);
        return title;
    }

    /**
     * Panel that shows the check boxes
     * Center panel of the GUI
     * Hard coded in all of the information for each elective course
     */
    private JPanel makeCheckBoxPanel()
    {
        JPanel cbs = new JPanel();
        cbs.setBackground(new Color(176, 215, 255));

        PHYS220 = new JCheckBox("PHYS 220: Computer Simulation Methods");
        PHYS234 = new JCheckBox("PHYS 234: Techniques for Experimentalists"); 
        PHYS311 = new JCheckBox("PHYS 311: Advanced Astrophysics"); 
        PHYS320 = new JCheckBox("PHYS 320: Advanced Topics in Physics"); 

        PHYS220 = new JCheckBox("PHYS 220: Computer Simulation Methods");
        PHYS234 = new JCheckBox("PHYS 234: Techniques for Experimentalists"); 
        PHYS311 = new JCheckBox("PHYS 311: Advanced Astrophysics"); 
        PHYS320 = new JCheckBox("PHYS 320: Advanced Topics in Physics"); 

        PHYS220.setFont(new Font("Futura", Font.PLAIN, 12));
        PHYS234.setFont(new Font("Futura", Font.PLAIN, 12));
        PHYS311.setFont(new Font("Futura", Font.PLAIN, 12));
        PHYS320.setFont(new Font("Futura", Font.PLAIN, 12));

        CheckListener listener = new CheckListener();
        PHYS220.addItemListener(listener);
        PHYS234.addItemListener(listener); 
        PHYS311.addItemListener(listener); 
        PHYS320.addItemListener(listener); 

        cbs.add(PHYS220); cbs.add(PHYS234); cbs.add(PHYS311); cbs.add(PHYS320); 

        return cbs;
    }

    /**
     * Panel that shows the Next Button
     */
    private JPanel makeButtonsPanel()
    {
        JPanel buttons = new JPanel();
        ButtonListener b1 = new ButtonListener();

        nextButton.addActionListener(b1);
        buttons.setBackground(new Color(176, 215, 255));
        buttons.add(nextButton);
        return buttons;
    }

    /**
     * Panel that combines all of the panels into one
     */
    private JPanel combineAllPanels()
    {
        JPanel all = new JPanel();
        all.setLayout (new BoxLayout (all, BoxLayout.Y_AXIS));
        all.setBackground(new Color(176, 215, 255));

        all.add(makeTitle());
        all.add(makeCheckBoxPanel());
        all.add(makeButtonsPanel());
        return all;
    }

    private class CheckListener implements ItemListener
    {
         /**
         * If elective course is checked off, course is added to a LinkedList of Courses
         */
        public void itemStateChanged (ItemEvent event) {
            Electives listofElectives = new Electives();
            electivestoAdd=new LinkedList<Course>();
            if (PHYS220.isSelected()){
                electivestoAdd.add(listofElectives.PHYSElectives.get("PHYS220"));
            }
            if (PHYS234.isSelected()){
                electivestoAdd.add(listofElectives.PHYSElectives.get("PHYS234"));
            }
            if (PHYS311.isSelected()){
                electivestoAdd.add(listofElectives.PHYSElectives.get("PHYS311"));
            }
            if (PHYS320.isSelected()){
                electivestoAdd.add(listofElectives.PHYSElectives.get("PHYS320"));
            }        
            //System.out.println(electivestoAdd); TESTING
        }
    }
    public class ButtonListener implements ActionListener{
         /**
         * Adds LinkedList of Courses to the Physics graph
         * swiches to the next panel
         */
        public void actionPerformed(ActionEvent event){
            //catches the input that can not be converted into an integer
            try{
                if (event.getSource() == nextButton){
                    cl.show(cards, "finalpanel");
                    finalgraph.addElective(electivestoAdd);                     
                }                
            }catch (NumberFormatException e){
                System.out.println("error.");
            }
        }
    }
    
}
