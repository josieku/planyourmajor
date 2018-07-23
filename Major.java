
/**
 * This class will represent each major offered in Wellesley. It will include a 
 * directed graph that connects all core and chosen elective courses to their 
 * prerequisites. It implements the Graph<T> interface. All the courses are in the 
 * graph already, so the addCourse method only applies to elective courses that are 
 * to be chosen by the user.
 * 
 * This class uses the Java API JGraphx.
 * 
 * Primarily responsible: jku
 * 
 * @mkilling tdeshong jku
 * @05/22/2018
 */

import javafoundations.*;
import java.util.*;
import javax.swing.*;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGraphModel;
import javax.swing.SwingConstants;

public class Major 
{    
    private mxGraph major;
    
    /**
     * Constructor for objects of class Major.  Instantiates the 
     * specified core courses in the major graph.
     */
    public Major(String str)
    {
        if (str.equals("CS")){
            CoreCourses CS = new CoreCourses();
            major = CS.depts.get("CS");
        }
        else if (str.equals("PHYS")){
            CoreCourses PHYS = new CoreCourses();
            major = PHYS.depts.get("PHYS");
        }
    }

    /**
     * Adds the LinkedList of Course objects that represent the 
     * user's chosen elective courses in the GUI to the graph.
     */
    public void addElective(LinkedList<Course> courseList){
        Object parent = major.getDefaultParent();
        major.getModel().beginUpdate();
        try{
            for (int i=0; i<courseList.size();i++){
                Course course = courseList.get(i); //get the course from list
                Object newV = major.insertVertex(parent, null, course, 20, 20, 70, 50, "fillColor=yellow"); //insert it as a cell
                LinkedList<Course> prereqList = course.getPrereq(); //list of prereqs
                Object[] nodes = major.getChildVertices(parent); //list of existing nodes
                int size = nodes.length-1;
                for (int k=0; k<prereqList.size();k++){
                    int tempInd = 0;
                    mxCell prereq;
                    //checks if the prereq exists in the graph
                    for (int ind = 0; ind<size; ind++){
                        mxCell temp = (mxCell)nodes[ind];
                        if (temp.getValue().toString().equals(prereqList.get(k).getFullCourse())){
                            // if the temporary cell equals to a prereq, the index will point to that cell
                            tempInd = ind;
                        }
                    }
                    //if the prereq does not exist, create a new vertex of mxCell type
                    if (!((mxCell)nodes[tempInd]).getValue().toString().equals(prereqList.get(k).getFullCourse())){
                        Object a = major.insertVertex(parent, null, prereqList.get(k), 20, 20 , 70, 50, "fillColor=yellow");
                        prereq = (mxCell)a; 
                    } else{
                        prereq = (mxCell)nodes[tempInd];
                    }
                    //insert the directed edge from prereq to elective in graph
                    major.insertEdge(parent, null, "",
                                ((mxGraphModel)major.getModel()).getCell(prereq.getId()), 
                                 newV);
                }
            }
            
            //sets the hierarchical layout for the directed graph
            mxHierarchicalLayout layout = new mxHierarchicalLayout(major);
            layout.setOrientation(SwingConstants.WEST);
            layout.execute(parent);
        }
        finally
        {
            major.getModel().endUpdate();
        }
    }
    
    /**
     * Getter to return the Major graph.
     */
    public mxGraph getGraph(){
        return major;
    }
    
    /**
     * Testing in a new JFrame for graph display.
     */
    public static void main (String[] args){
        JFrame frame = new JFrame("Testing for Major Class");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Major trial = new Major("CS");
        LinkedList<Course> newList = new LinkedList<Course>();
        newList.add(new Course("CS 232", "CS 230"));
        newList.add(new Course("CS 320", "CS 230"));
        trial.addElective(newList);
        
        mxGraphComponent graphComponent = new mxGraphComponent(trial.getGraph());
        graphComponent.setEnabled(false);
        
        frame.getContentPane().add(graphComponent);
        frame.pack();
        frame.setSize(750,750);
        frame.setVisible(true);        
    }
    
}
