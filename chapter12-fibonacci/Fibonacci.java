// Kathryn Brusewitz
// Bellevue College CS211
// Instructor - Bill Iverson
// Chapter 12 - Fibonacci

public class Fibonacci {

	public static void main(String[] args) {
		int test = 45;
		System.out.println(fibFast(test)); // a fast recursive version
		System.out.println(fibonacci(test)); // slow version in text
	}

	// Textbook Version
	public static int fibonacci(int a ) {
		if ( a <= 2 ) {
			return 1;
		} else {
			return fibonacci( a - 1 ) + fibonacci( a - 2 );
		}
	}

	// Main recursive method for fast Fibonacci
	public static int fibFast(int n) {
		if ( n == 2 || n == 1 ) {
			return 1;
		}
		return fibFast( n, 1, 1, 3 );
	}

	// Helper method for fast Fibonacci
	private static int fibFast(int last, int a, int b, int n) {

		// If the end equals count then return the sum of a and b
		if ( last == n ) {
			return ( a + b );
		} else {
			// Otherwise keep calling fibFast and pass in sum of a and b as b parameter
			return fibFast( last, b, (a + b), (n + 1) );
		}

	}

}
