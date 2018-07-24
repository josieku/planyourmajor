
/**
 * Contains the electives for each major. 
 *
 *  Primarily responsible: tdeshong
 *  
 * @author jku, mkilling, tdeshong
 * @version 5-21-18
 */
import java.util.*;
public class Electives
{
    //stores each major's electives in a Hashtable
    public Hashtable<String, Course> CSElectives = new Hashtable<String, Course>();
    public Hashtable<String, Course> PHYSElectives = new Hashtable<String, Course>();
    
    /**
     * Constructor for objects of class Electives
     */
    public Electives()
    {
        CSCourses();
        PHYSCourses();
    }

    /**
     * Hard codes in each CS elective into the Hashtable
     */
    public void CSCourses()
    {
        CSElectives.put("CS220", new Course("CS 220", "CS 111"));
        CSElectives.put("CS225", new Course("CS 225", "CS 111"));
        CSElectives.put("CS232", new Course("CS 232", "CS 230"));
        CSElectives.put("CS234", new Course("CS 234", "CS 230"));
        CSElectives.put("CS242", new Course("CS 242", "CS 230"));
        CSElectives.put("CS301", new Course("CS 301", "CS 230 CS 240"));
        CSElectives.put("CS304", new Course("CS 304", "CS 230"));
        CSElectives.put("CS307", new Course("CS 307", "CS 230"));
        CSElectives.put("CS310", new Course("CS 310", "CS 231"));
        CSElectives.put("CS312", new Course("CS 312", "CS 230 MATH 225"));
        CSElectives.put("CS313", new Course("CS 313", "CS 230"));
        CSElectives.put("CS315", new Course("CS 315", "CS 230"));
        CSElectives.put("CS320", new Course("CS 320", "CS 230"));
        CSElectives.put("CS322", new Course("CS 322", "EDUC 110"));
        CSElectives.put("CS332", new Course("CS 332", "CS 230"));
        CSElectives.put("CS341", new Course("CS 341", "CS 240"));
        CSElectives.put("CS342", new Course("CS 342", "CS 230 CS 240"));
        CSElectives.put("MATH203", new Course("MATH 203", "MATH 116"));
        CSElectives.put("MATH205", new Course("MATH 205", "MATH 116"));
        CSElectives.put("MATH206", new Course("MATH 206", "MATH 205"));
        CSElectives.put("MATH210", new Course("MATH 210", "MATH 205"));
        CSElectives.put("MATH214", new Course("MATH 214", "MATH 205"));
        CSElectives.put("MATH215", new Course("MATH 215", "MATH 116"));
        CSElectives.put("MATH220", new Course("MATH 220", "MATH 205"));
        CSElectives.put("MATH223", new Course("MATH 223", "MATH 116"));
    }
    
    /**
     * Hard codes in each Physics elective into the Hashtable
     */    
    public void PHYSCourses()
    {
        PHYSElectives.put("PHYS220", new Course("PHYS 220", "PHYS 107 MATH 116"));
        PHYSElectives.put("PHYS234", new Course("PHYS 234", "PHYS 107"));
        PHYSElectives.put("PHYS311", new Course("PHYS 311", "PHYS 207"));
        PHYSElectives.put("PHYS320", new Course("PHYS 320", "PHYS 207 PHYS 302"));
    }
}
