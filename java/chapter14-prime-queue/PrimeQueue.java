// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 14 - Prime Queue

import java.util.Queue;
import java.util.LinkedList;

public class PrimeQueue {

	public static Queue<Integer> getPrimes(int number) {

		// Create array of booleans
		Boolean[] prime = new Boolean[number];

		// Make each element in isPrime true to start with
		for (int i = 1; i < number; i++) {
			prime[i] = true;
		}

		// Start from 2 and check for primes
		for (long i = 2; i <= number; i++) {
			// Change int to long due to ArrayIndexOutOfBoundsException

			// If true...
			// (type cast i from long to int to work)
			if (prime[(int)i-1]) {

				// See if next numbers are primes
				for (long j = (i * i); j <= number; j += i) {
					prime[(int)j - 1] = false;
				}

			}
		}

		// Create and build primes queue
		Queue<Integer> primes = new LinkedList<Integer>();
		for (int i = 1; i < number; i++) {
			if (prime[i]) {
				primes.add(i+1);
			}
		}

		return primes;

	}
}
