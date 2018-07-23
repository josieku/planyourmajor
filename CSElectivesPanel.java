
/**
 * Adds selected CS electives that the user chooses into the CS Major graph
 *
 * Primarily responsible: mkilling
 *
 * @author jku, mkilling, tdeshong
 * @version 5-21-18
 */

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CSElectivesPanel extends JPanel
{
    private JLabel quote;
    private String message;
    private JCheckBox CS220, CS225, CS232, CS234, CS242, CS301, CS304, CS307, CS310, CS312, CS313, CS315, CS320, CS322, 
    CS332, CS341, CS342, MATH203, MATH205, MATH206, MATH210, MATH214, MATH215, MATH220, MATH223;
    private LinkedList<Course> electivestoAdd;

    private JButton nextButton = new JButton ("NEXT");
    JPanel cards = new JPanel();
    JPanel currentPanel = new JPanel();

    CardLayout cl = new CardLayout();
    private Major finalgraph;

    /**
     * Constructor for objects of class CSElectivesPanel
     */
    public CSElectivesPanel()
    {
        finalgraph = new Major("CS");
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

        message = "<html><div style='text-align: center;'>2. Choose your higher level courses:<br>Please choose at least <b>one</b> 200-level and <b>two</b> 300-level <b>CS</b> Courses and at least <b>one</b> 200-level <b>MATH</b> course.<br/></html>";

        quote = new JLabel(message);
        quote.setFont(new Font("Futura", Font.PLAIN, 18));
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
        JPanel cbs = new JPanel(); //cbs = check boxes
        cbs.setLayout (new GridLayout(14,2));
        cbs.setBackground(new Color(216, 213, 219));

        CS220 = new JCheckBox("CS 220: Human-Computer Interaction");
        CS225 = new JCheckBox("CS 225: Making and Fabrication: Methods, Culture, and a Heuristic Approach to Technology"); 
        CS232 = new JCheckBox("CS 232: Artificial Intelligence"); 
        CS234 = new JCheckBox("CS 234: Data, Analytics, and Visualization"); 
        CS242 = new JCheckBox("CS 242: Computer Networks"); 
        CS301 = new JCheckBox("CS 301: Compiler and Runtime System Design"); 
        CS304 = new JCheckBox("CS 304: Databases with Web Interfaces"); 
        CS307 = new JCheckBox("CS 307: Computer Graphics"); 
        CS310 = new JCheckBox("CS 310: Foundations of Cryptology"); 
        CS312 = new JCheckBox("CS 312: Logic in Computer Science"); 
        CS313 = new JCheckBox("CS 313: Computational Biology"); 
        CS315 = new JCheckBox("CS 315: Data and Text Mining for the Web"); 
        CS320 = new JCheckBox("CS 320: 320 Tangible User Interfaces"); 
        CS322 = new JCheckBox("CS 322: Seminar: Learning and Teaching in a Digital World"); 
        CS332 = new JCheckBox("CS 332: Visual Processing by Computer and Biological Vision Systems"); 
        CS341 = new JCheckBox("CS 341: Operating Systems"); 
        CS342 = new JCheckBox("CS 342: Computer Security and Privacy"); 
        MATH203 = new JCheckBox("MATH 203: Mathematics for Economics and Finance"); 
        MATH205 = new JCheckBox("MATH 205: Multivariable Calculus"); 
        MATH206 = new JCheckBox("MATH 206: Linear Algebra"); 
        MATH210 = new JCheckBox("MATH 210: Differential Equations"); 
        MATH214 = new JCheckBox("MATH 214: Euclidean and Non-Euclidean Geometry"); 
        MATH215 = new JCheckBox("MATH 215: Mathematics for the Sciences I"); 
        MATH220 = new JCheckBox("MATH 220: Probability and Elementary Statistics"); 
        MATH223 = new JCheckBox("MATH 223: Number Theory");

        CS220.setFont(new Font("Futura", Font.PLAIN, 12));
        CS225.setFont(new Font("Futura", Font.PLAIN, 12));
        CS232.setFont(new Font("Futura", Font.PLAIN, 12)); 
        CS234.setFont(new Font("Futura", Font.PLAIN, 12));
        CS242.setFont(new Font("Futura", Font.PLAIN, 12));
        CS301.setFont(new Font("Futura", Font.PLAIN, 12));
        CS304.setFont(new Font("Futura", Font.PLAIN, 12)); 
        CS307.setFont(new Font("Futura", Font.PLAIN, 12)); 
        CS310.setFont(new Font("Futura", Font.PLAIN, 12));
        CS312.setFont(new Font("Futura", Font.PLAIN, 12));
        CS313.setFont(new Font("Futura", Font.PLAIN, 12)); 
        CS315.setFont(new Font("Futura", Font.PLAIN, 12)); 
        CS320.setFont(new Font("Futura", Font.PLAIN, 12));
        CS322.setFont(new Font("Futura", Font.PLAIN, 12));
        CS332.setFont(new Font("Futura", Font.PLAIN, 12));
        CS341.setFont(new Font("Futura", Font.PLAIN, 12)); 
        CS342.setFont(new Font("Futura", Font.PLAIN, 12));
        MATH203.setFont(new Font("Futura", Font.PLAIN, 12));
        MATH205.setFont(new Font("Futura", Font.PLAIN, 12));
        MATH206.setFont(new Font("Futura", Font.PLAIN, 12));
        MATH210.setFont(new Font("Futura", Font.PLAIN, 12));
        MATH214.setFont(new Font("Futura", Font.PLAIN, 12));
        MATH215.setFont(new Font("Futura", Font.PLAIN, 12));
        MATH220.setFont(new Font("Futura", Font.PLAIN, 12));
        MATH223.setFont(new Font("Futura", Font.PLAIN, 12));

        CheckListener listener = new CheckListener();
        CS220.addItemListener(listener);
        CS225.addItemListener(listener); 
        CS232.addItemListener(listener); 
        CS234.addItemListener(listener); 
        CS242.addItemListener(listener); 
        CS301.addItemListener(listener); 
        CS304.addItemListener(listener); 
        CS307.addItemListener(listener); 
        CS310.addItemListener(listener); 
        CS312.addItemListener(listener); 
        CS313.addItemListener(listener); 
        CS315.addItemListener(listener); 
        CS320.addItemListener(listener); 
        CS322.addItemListener(listener); 
        CS332.addItemListener(listener); 
        CS341.addItemListener(listener); 
        CS342.addItemListener(listener); 
        MATH203.addItemListener(listener); 
        MATH205.addItemListener(listener); 
        MATH206.addItemListener(listener); 
        MATH210.addItemListener(listener); 
        MATH214.addItemListener(listener); 
        MATH215.addItemListener(listener); 
        MATH220.addItemListener(listener); 
        MATH223.addItemListener(listener);

        cbs.add(CS220); cbs.add(CS225); cbs.add(CS232); cbs.add(CS234); cbs.add(CS242);
        cbs.add(CS301); cbs.add(CS304); cbs.add(CS307); cbs.add(CS310); cbs.add(CS312);
        cbs.add(CS313); cbs.add(CS315); cbs.add(CS320); cbs.add(CS322); cbs.add(CS332);
        cbs.add(CS341); cbs.add(CS342); cbs.add(MATH203); cbs.add(MATH205); cbs.add(MATH206);
        cbs.add(MATH210); cbs.add(MATH214); cbs.add(MATH215); cbs.add(MATH220); cbs.add(MATH223);
        
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
        all.setLayout (new BoxLayout(all, BoxLayout.Y_AXIS));
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
            if (CS220.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS220"));
            }
            if (CS225.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS225"));
            }
            if (CS232.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS232"));
            }
            if (CS234.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS234"));
            }        
            if (CS242.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS242"));
            }
            if (CS304.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS304"));
            }
            if (CS307.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS307"));
            }
            if (CS301.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS301"));
            }
            if (CS310.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS310"));
            }
            if (CS312.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS312"));
            }
            if (CS313.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS313"));
            }        
            if (CS315.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS315"));
            }
            if (CS320.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS320"));
            }
            if (CS322.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS322"));
            }
            if (CS332.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS332"));
            }
            if (CS341.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS341"));
            }        
            if (CS342.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("CS342"));
            }
            if (MATH203.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("MATH203"));
            }
            if (MATH205.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("MATH205"));
            }
            if (MATH206.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("MATH206"));
            }              
            if (MATH210.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("MATH210"));
            }            
            if (MATH214.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("MATH214"));
            }              
            if (MATH215.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("MATH215"));
            }              
            if (MATH220.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("MATH220"));
            }             
            if (MATH223.isSelected()){
                electivestoAdd.add(listofElectives.CSElectives.get("MATH223"));
            }
            //System.out.println(electivestoAdd); TESTING
        }
    }
    public class ButtonListener implements ActionListener{
        /**
         * Adds LinkedList of Courses to the CS graph
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
    
    /**
     * Testing code
     */
    public static void main (String[] args){
        JFrame frame = new JFrame("Testing for Major Class");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CSElectivesPanel test = new CSElectivesPanel();

        frame.getContentPane().add(test.combineAllPanels());
        frame.pack();
        frame.setSize(750,750);
        frame.setVisible(true); 
    }
}
