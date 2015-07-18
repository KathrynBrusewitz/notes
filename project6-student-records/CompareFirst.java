/*-----------------------------------------------------------------------------
  CS 211
  02/10/2015
  Kathryn Brusewitz

  Class: CompareFirst
  Super Class: Object
  Implements: Comparator<Student>
  
 ------------------------------------------------------------------------------*/

import java.util.*;

public class CompareFirst implements Comparator<Student> {

    @Override 
    public int compare(Student s1, Student s2) {
		return s1.getFirst().compareTo(s2.getFirst());
    }

}