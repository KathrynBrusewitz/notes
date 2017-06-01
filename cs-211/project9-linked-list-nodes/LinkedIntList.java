/*-----------------------------------------------------------------------------
  CS 211
  03/05/2015
  Kathryn Brusewitz

  Class: LinkedIntList
  Super Class: Object
  Implements: None

 ------------------------------------------------------------------------------*/

public class LinkedIntList {

	public LinkedIntList() {
		front = null;
	}

	public void add(int value) {
		if (front == null) {
			front = new ListNode(value);
		}
        	else {
			ListNode current = front;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new ListNode(value);
		}
	}

	public int size() {
		int size = 0;
    	
		ListNode current = front;
    	
		while (current != null) {
			++size;
			current = current.next;
		}

		return size;
	}

	public String toString() {
		if (front == null) {
			return "[]";
		}
		else {
			String result = "[" + front.data;
			ListNode current = front.next;
			while (current != null) {
				result += ", " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	public void stretch(int n) {
		if (n < 1) front = null;
		else {
			ListNode current = front;
			while (current != null) {
				ListNode saveNext = current.next; // Save the next node
				for (int i = 1; i < n; i++)   	  // Relink current to new nodes
					current.next = new ListNode(current.data, current.next);
				current = saveNext; 			  // Move to the saved node
			}
		}
	}

	private ListNode front;

}
