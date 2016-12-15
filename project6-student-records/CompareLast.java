/*-----------------------------------------------------------------------------
  CS 211
  02/10/2015
  Kathryn Brusewitz

  Class: CompareLast
  Super Class: Object
  Implements: Comparator<Student>
  
 ------------------------------------------------------------------------------*/
 
import java.util.*;

public class CompareLast implements Comparator<Student> {

    @Override 
    public int compare(Student s1, Student s2) {
		return s1.getLast().compareTo(s2.getLast());
    }

}