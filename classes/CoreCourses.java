
/**
 * Contains all of the core courses from each major.
 * 
 * This class uses the Java API JGraphx.
 *
 * * Primarily responsible: jku
 *
 * @author jku, mkilling, tdeshong
 * @version 5-21-18
 */
import java.util.*;
import javafoundations.*;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.mxgraph.model.mxCell;
import com.mxgraph.model.mxGraphModel;

public class CoreCourses
{
    public Hashtable<String, mxGraph> depts = new Hashtable<String, mxGraph>();
    private mxGraph csgraph = new mxGraph();
    private mxGraph physgraph = new mxGraph();
    
    /**
     * Constructor for the CoreCourses class
     * Instansiates the core courses in individual Major graphs and puts in a Hashtable
     */
    public CoreCourses()
    {
        depts.put("CS", CS());
        depts.put("PHYS", PHYS());
    }
   
    /**
     * Creates the graph of CS core courses
     */
    public mxGraph CS()
    {
        LinkedList<Course> cores = new LinkedList<Course>();
        cores.add(new Course("CS 111"));
        cores.add(new Course("CS 230", "CS 111"));
        cores.add(new Course("MATH 225", "CS 230"));
        cores.add(new Course("CS 231", "MATH 225"));
        cores.add(new Course("CS 235", "CS 230"));
        cores.add(new Course("CS 240", "CS 230"));
        cores.add(new Course("CS 251", "CS 230"));
        addToGraph(csgraph, cores);
        return csgraph;
    }

    /**
     * Creates the graph of Physics core courses
     */
    public mxGraph PHYS(){
        LinkedList<Course> cores = new LinkedList<Course>();
        cores.add(new Course("MATH 115"));
        cores.add(new Course("MATH 116", "MATH 115"));
        cores.add(new Course("PHYS 107", "MATH 115"));
        cores.add(new Course("PHYS 108", "PHYS 107 MATH 116"));
        cores.add(new Course("MATH 215", "MATH 116"));
        cores.add(new Course("PHYS 202", "PHYS 108 MATH 116"));
        cores.add(new Course("PHYS 207", "PHYS 108 MATH 215"));
        cores.add(new Course("PHYS 216", "MATH 215"));
        cores.add(new Course("PHYS 302", "PHYS 202 PHYS 207 PHYS 216"));
        cores.add(new Course("PHYS 305", "PHYS 202 PHYS 216"));
        cores.add(new Course("PHYS 310", "PHYS 202"));
        cores.add(new Course("PHYS 314", "PHYS 108 PHYS 207 PHYS 216"));
        addToGraph(physgraph, cores);
        return physgraph;
    }
    
    /**
     * Takes the core courses as a LinkedList of Course objects and adds it to the graph.
     * There are print statements to show testing during the process.
     */
    public void addToGraph(mxGraph g, LinkedList<Course> courseList){
        Object parent = g.getDefaultParent();
        g.getModel().beginUpdate();
        try{
            for (int i=0; i<courseList.size();i++){
                Course course = courseList.get(i);
                //System.out.println(course);
                Object newV = g.insertVertex(parent, null, course, 20, 20, 70, 50); //inserts a new cell into the graph
                LinkedList<Course> prereqList = course.getPrereq(); //gets the list of prerequisites for each course
                //System.out.println("prereq size" + prereqList.size());
                Object[] nodes = g.getChildVertices(parent); // existing cells in the graph
                int size = nodes.length-1;
                for (int k=0; k<prereqList.size();k++){
                    int tempInd = 0;
                    //System.out.println(size);
                    for (int ind = 0; ind<size; ind++){
                        //System.out.println(ind);
                        mxCell temp = (mxCell)nodes[ind];
                        //System.out.println("temp value: " + temp.getValue());
                        //System.out.println("prereq: " + prereqList.get(k).getFullCourse());
                        //System.out.println(prereqList.get(k).getFullCourse());
                        //System.out.println(temp.getValue().toString().equals(prereqList.get(k).getFullCourse()));
                        if (temp.getValue().toString().equals(prereqList.get(k).getFullCourse())){
                            tempInd = ind;
                            //System.out.println(tempInd);
                        }
                    }
                    mxCell prereq = (mxCell)nodes[tempInd];
                    //System.out.println(tempInd);
                    
                    // inserts a directed edge between the core course and its prereq
                    g.insertEdge(parent, null, "",
                                ((mxGraphModel)g.getModel()).getCell(((mxCell)prereq).getId()), 
                                 newV);
                }
            }
            //sets up the hierarchical layout for the graph
            mxHierarchicalLayout layout = new mxHierarchicalLayout(g);
            layout.setOrientation(SwingConstants.WEST);
            layout.execute(parent);
        }
        finally
        {
            g.getModel().endUpdate();
        }
    }

    /**
     * Testing in a new JFrame for graph display.
     */
    public static void main (String[] args){
        JFrame frame = new JFrame("Testing CoreCourses - CS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CoreCourses trial = new CoreCourses();
        
        mxGraphComponent graphComponent = new mxGraphComponent(trial.depts.get("CS"));
        graphComponent.setEnabled(false);
        
        frame.getContentPane().add(graphComponent);
        frame.pack();
        frame.setSize(750,750);
        frame.setVisible(true);        
    }
    
}
