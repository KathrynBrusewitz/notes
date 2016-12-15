/*-----------------------------------------------------------------------------
  CS 211
  02/10/2015
  Kathryn Brusewitz

  Class: StudentRecords
  Super Class: Object
  Implements: None

  Reads in a file that contains student records. Display student information
  and is sorted by last name, first name, id, average grade, and grade letter.

 ------------------------------------------------------------------------------*/

import java.util.*;
import java.io.*;

public class StudentRecords {

	public static void main (String[] args) throws FileNotFoundException {

		File file = new File("StudentRecords.txt");
		if (!file.exists()) throw new FileNotFoundException("StudentRecords.txt not found!");

		List<Student> students = new ArrayList<Student>();
		Scanner sFile = new Scanner(file);

        while(sFile.hasNext()) {
        	Scanner sLine   = new Scanner(sFile.nextLine());
    		String  last    = sLine.next();
    		String  first   = sLine.next();
    		int     id      = sLine.nextInt();
    		double  average = sLine.nextDouble();
    		char    grade   = sLine.next().charAt(0);
    		students.add(new Student(last, first, id, average, grade));
    		sLine.close();
        }
        sFile.close();

        display("as read from the database file", students);
        Collections.sort(students, new CompareLast());
        display("after sorting by last name", students);
        Collections.sort(students, new CompareFirst());
        display("after sorting by first name", students);
        Collections.sort(students, new CompareID());
        display("after sorting by student ID", students);
        Collections.sort(students, new CompareAverage());
        display("after sorting by average", students);
        Collections.sort(students, new CompareGrade());
        display("after sorting by letter grade", students);
	}

	private static void display(String desc, List<Student> list) {
        System.out.format("Student Records, %s:%n", desc);
        System.out.println("Last Name  First Name   ID   Average Grade");
        System.out.println("---------- ---------- ------ ------- -----");
        for (Student s : list) System.out.println(s.toString());
        System.out.println();
	}

}