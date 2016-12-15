/*-----------------------------------------------------------------------------
  CS 211
  02/02/2015
  Kathryn Brusewitz

  Class: RecursiveSquares
  Super Class: Object
  Implements: None

  Displays first 8 squares, first 15 squares, and first square

  Uses recursive method that accepts an integer parameter n and prints the first 
  n squares separated by commas, with the odd squares in descending order 
  followed by the even squares in ascending order. 

 ------------------------------------------------------------------------------*/

import java.util.*;
import java.io.*;

public class RecursiveSquares {
	
	public static void main (String[] args) {
		System.out.format("Call writeSquares(8): ");
		writeSquares(8);
		System.out.println();

		System.out.format("Call writeSquares(15): ");
		writeSquares(15);
		System.out.println();

		System.out.format("Call writeSquares(1): ");
		writeSquares(1);
		System.out.println();
	}

	private static void writeSquares(int n) {
		if (n < 1) throw new IllegalArgumentException();

		if (n == 1) {
			System.out.format("1");
		} else if (n % 2 == 0) {
			writeSquares(n - 1);
			System.out.format(", %d", n * n);
		} else {
			System.out.format("%d, ", n * n);
			writeSquares(n - 1);
		}
	}
}