/*-----------------------------------------------------------------------------
  CS 211
  02/10/2015
  Kathryn Brusewitz

  Class: CompareID
  Super Class: Object
  Implements: Comparator<Student>
  
 ------------------------------------------------------------------------------*/

import java.util.*;

public class CompareID implements Comparator<Student> {

    @Override 
    public int compare(Student s1, Student s2) {
		return s1.getID() - s2.getID(); 
    }

}