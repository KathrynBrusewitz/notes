/*-----------------------------------------------------------------------------
  CS 211
  03/05/2015
  Kathryn Brusewitz

  Class: ListClient
  Super Class: Object
  Implements: None

  Demonstrates replacing each int in a LinkedIntlist with n copies of that int.

 ------------------------------------------------------------------------------*/

import java.util.*;
import java.io.*;

class ListClient {

	public static void main(String[] args) {

		final int MAX = 9;
		Scanner in = new Scanner(System.in);
		LinkedIntList list = new LinkedIntList();
		
		System.out.print("Enter " + MAX + " numbers: ");
		for (int i = 0; i < MAX; i++) list.add(in.nextInt());
		in.nextLine();

		System.out.print("Enter factor: ");
		list.stretch(in.nextInt());

		System.out.println("New List: " + list);

		in.close();
    
	}
}