// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 13 - Runtime Complexity with Collections.sort()

import java.util.*;

public class Testing {

	public static void main(String[] args) {

		int randomRange = 5000000; // Random number range
		int min = 1000; // Starting number of elements
		int max = 4096000; // Final maximum number of elements

		// n is number of elements
		for (int n = min; n <= max; n *= 2) {
			// Double n for every loop

			// Create a list of n random elements
			List<Integer> list = new ArrayList<Integer>();
			Random random = new Random(); // Random number stream
			for (int i = 0; i < n; i++) {
				int randomElement = random.nextInt(randomRange);
				list.add(randomElement);
			}

			// Obtain time it takes to sort list
			double timeStart = System.currentTimeMillis();
			Collections.sort(list);
			double timeEnd = System.currentTimeMillis();

			// Print number of elements and time results
			double time = timeEnd - timeStart;
			System.out.println(n + ", " + time);

		}
	}
}
