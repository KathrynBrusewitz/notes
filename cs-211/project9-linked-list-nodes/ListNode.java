/*-----------------------------------------------------------------------------
  CS 211
  03/05/2015
  Kathryn Brusewitz

  Class: ListNode
  Super Class: Object
  Implements: None

 ------------------------------------------------------------------------------*/

public class ListNode {

	public ListNode() {
		this(0, null);
	}

	public ListNode(int data) {
		this(data, null);
	}

	public ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
	}

	public int data;
	public ListNode next;

}
