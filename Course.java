
/**
 * This class will represent each individual course.
 * 
 * Primarily responsible: jku
 *
 * @author mkilling, jku, tdeshong
 * @version 5-21-18
 */
import java.util.*;
public class Course
{
    private String department;
    private String courseNum;
    private String fullCourse;
    LinkedList<Course> prereqList = new LinkedList<Course>();

    /**
     * Constructor for objects of class Course
     */
    public Course(String course)
    {
        fullCourse = course;
        Scanner sc = new Scanner(course);
        department = sc.next();
        courseNum = sc.next();
        sc.close();
    }
    
    /**
     * Second Constructor for objects of class Course
     * includes parameter for prereq if course has a prereq
     */
    public Course(String course, String prereq)
    {
        fullCourse = course;
        Scanner sc = new Scanner(course);
        department = sc.next();
        courseNum = sc.next();
        sc.close();
        
        Scanner read = new Scanner(prereq);
        while (read.hasNext()){
            String dept = read.next();
            String num = read.next();
            this.prereqList.add(new Course(dept+" "+ num));
        }
        read.close();
    }
    
    /**
     * getters for Course object information
     */
    public String getFullCourse()
    {
        return fullCourse;
    }
    
    public LinkedList<Course> getPrereq()
    {
        return prereqList;
    }
    
    public String toString()
    {
        return fullCourse;
    }
    
    /**
     * Testing for Course class
     */
    public static void main (String[] args){
        System.out.println("Testing for Course class:");
        Course test1 = new Course("CS 230", "CS 111");
        System.out.println("Expected: CS 230 \nActual: " + test1);
        System.out.println("Tests getFullCourse()\nExpected: CS 230\nActual: " + test1.getFullCourse());
        Course test2 = new Course("CS 240", "CS 230 CS 111");
        System.out.println("Expected: CS 240 \nActual: " + test2);
        System.out.println("Shows prerequisites for CS 240\nExpected: CS 230 CS 111\nActual: " + test2.getPrereq());
        
        Course test3 = new Course("CS 111");
        System.out.println("Expected: CS 111 \nActual: " + test3);
        

    }
    
}
