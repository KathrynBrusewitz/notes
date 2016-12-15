/*-----------------------------------------------------------------------------
  CS 211
  02/10/2015
  Kathryn Brusewitz

  Class: Student
  Super Class: Object
  Implements: None

  Student record that encapsulates 5 data elements: last name, first name, 
  id number, average grade and grade letter.

 ------------------------------------------------------------------------------*/

public class Student {

    public Student(String last, String first, int id, double average, char grade) {
    	this.last = last;
    	this.first = first;
    	this.id = id;
    	this.average = average;
    	this.grade = grade;
    }

    @Override 
    public String toString() {
    	return String.format("%-10s %-10s %-6d %7.2f %5c", last, first, id, average, grade);
    }

    public String getLast() {
    	return last;
    }

    public String getFirst() {
    	return first;
    }

    public int getID() {
    	return id;
    }

    public double getAverage() {
    	return average;
    }

    public char getGrade() {
    	return grade;
    }

    private String last, first;
    private int id;
    private double average;
    private char grade;

}