
/**
 * Displays the graph of the user's selected major.
 *
 *Primarily responsible: tdeshong
 *
 * @author jku, mkilling, tdeshong
 * @version 5-21-18
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class FinalPanel extends JPanel 
{
    private JLabel messageQuote, legendQuote;
    private String message, legend;
    private JButton exit;
    Major finalgraph;
    //StartPanel startpanel = new StartPanel();
    JPanel cards = new JPanel();
    CardLayout cl = new CardLayout();
    
    /**
     * Constructor for objects of class FinalPanel
     */
    public FinalPanel(Major finalgraph)
    {
        setBackground(new Color(176, 215, 255));
        this.finalgraph = finalgraph;
        
        //uses card layout to switch in between different panels 
        cards.setLayout(cl);
        cards.add(combineAllPanels(), "currentpanel"); //current panel
        add(cards);
        cl.show(cards, "currentpanel");// shows current panel  
    }

    /**
     * Panel that shows the title message
     * Top most panel in the GUI
     */
    private JPanel makeTitle(){
        JPanel title = new JPanel();
        
        message = "3. See your 4-year major track!";
        messageQuote = new JLabel(message);
        messageQuote.setFont(new Font("Futura", Font.BOLD, 24));

        title.setBackground(new Color(176, 215, 255));
        title.add(messageQuote);
        return title;
    }
    
    /**
     * Panel that shows the legend 
     * Second top most panel in the GUI
     */
    private JPanel makeLegend(){
        JPanel legendDescription = new JPanel();
        
        legend = "Blue = Core Courses || Yellow = Electives";        
        legendQuote = new JLabel(legend);
        legendQuote.setFont(new Font("Future", Font.PLAIN, 16));
        
        legendDescription.setBackground(new Color(176, 215, 255));
        legendDescription.add(legendQuote);
        return legendDescription;
    }
    
    /**
     * Panel that shows the graph of courses in the major selected by the user
     */
    private JPanel makeGraphPanel(){
        JPanel graphPanel = new JPanel();
        graphPanel.setBackground(new Color(176, 215, 255));
        mxGraphComponent graphComponent = new mxGraphComponent(finalgraph.getGraph());
        graphComponent.setEnabled(false);
        graphPanel.add(graphComponent);
        return graphPanel;
    }

    /**
     * Panel that combines all of the panels into one
     */
    private JPanel combineAllPanels()
    {
        JPanel all = new JPanel();
        all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));
        all.setBackground(new Color(176, 215, 255));
        
        all.add(makeTitle());
        all.add(makeLegend());
        all.add(makeGraphPanel());
        all.add(makeButtonPanel());
        
        return all;
    }
    
    private JPanel makeButtonPanel()
    {
        JPanel button = new JPanel();
        button.setBackground(new Color(176, 215, 255));
        exit = new JButton("EXIT");
        exit.addActionListener(new ButtonListener());
        button.add(exit);
        return button;
    }
    
    /**
     * Represents the action listener for the button
     */
    public class ButtonListener implements ActionListener{
        /**
         * Exits the program when the button is clicked
         */
        public void actionPerformed(ActionEvent event){
            //catches the input that can not be converted into an integer
            try{
                System.exit(0); //exits the program
            }catch (NumberFormatException e){
                System.out.println("error.");
            }
        }
    }
}
