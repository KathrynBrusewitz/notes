/*-----------------------------------------------------------------------------
  CS 211
  02/19/2015
  Kathryn Brusewitz

  Class: Primes
  Super Class: Object
  Implements: None

  Given a maximum value, this will find all primes up to that value (inclusive).
  Uses Sieve of Eratosthenes algorithm:
  http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

 ------------------------------------------------------------------------------*/

import java.util.*;
import java.io.*;
import java.lang.Math;

public class Primes {
	public static void main (String[] args) {
		int n, p, size;
		Queue<Integer> numbers = new LinkedList<Integer>();
		Queue<Integer> primes = new LinkedList<Integer>();

		Scanner scn = new Scanner(System.in);
		System.out.print("\nEnter Max Value: ");
		n = scn.nextInt();

		// Create queue of numbers to process (2 through n inclusive):
		for (int i = 2; i <= n; i++) { 
			numbers.add(i); 
		}

		System.out.println("\nSTART:");
		System.out.println("numbers[] = " + numbers);
		System.out.println("primes[] = " + primes);

		do {
			// Obtain next prime / Remove from numbers / Add to primes:
			p = numbers.remove();
			primes.add(p);
			// Eliminate all numbers that are divisible by p:
			size = numbers.size();
			for (int i = 0; i < size; i++) {
				if (numbers.peek() % p == 0) numbers.remove();
				else numbers.add(numbers.remove());
			}
		} while (p < Math.sqrt(n));

		// Add remaining values in the numbers queue to primes queue:
		while (!numbers.isEmpty()) {
			primes.add(numbers.remove());
		}

		System.out.println("\nEND:");
		System.out.println("numbers[] = " + numbers);
		System.out.println("primes[] = " + primes);
	}
}